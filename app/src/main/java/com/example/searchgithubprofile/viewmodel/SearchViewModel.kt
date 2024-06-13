package com.example.searchgithubprofile.viewmodel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.searchgithubprofile.model.SearchItem
import com.example.searchgithubprofile.model.repo.RepositoryData
import com.example.searchgithubprofile.repo.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {
    private val _query = MutableStateFlow("")
    private val _errorMessage = MutableStateFlow<String?>(null)
    private val _languagesMap = MutableStateFlow<Map<String, Map<String, Int>>>(emptyMap())
    private val _isRefreshing = MutableStateFlow(false)
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    val isRefreshing: StateFlow<Boolean> = _isRefreshing
    val errorMessage: StateFlow<String?> = _errorMessage
    val languagesMap: StateFlow<Map<String, Map<String, Int>>> = _languagesMap

    var searchResults = _query.flatMapLatest { query ->
        if (query.isEmpty()) {
            flowOf(PagingData.empty<SearchItem>())
        } else {
            repository.getSearchResults(query)
                .cachedIn(viewModelScope)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    init {
        viewModelScope.launch {
            searchResults.collectLatest { pagingData ->
                pagingData.map { item ->
                    Log.d("SearchViewModel", "Received search result: $item")
                }
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            Log.d("SearchViewModel", "Refresh started")
            try {
                _isRefreshing.value = true
                _errorMessage.value = null
                _isLoading.value = true
                //Это чтобы проетстить ошибку при обновление
                //throw IllegalArgumentException("Testing error handling")
                searchResults = _query.flatMapLatest { query ->
                    if (query.isEmpty()) {
                        flowOf(PagingData.empty<SearchItem>())
                    } else {
                        repository.getSearchResults(query)
                            .cachedIn(viewModelScope)
                    }
                }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
                _isRefreshing.value = false
                _isLoading.value = false
                Log.d("SearchViewModel", "Refresh ended")
                Log.d("SearchViewModel", "Loading ended")
                searchResults.collectLatest { pagingData ->
                    pagingData.map { item ->
                        Log.d("SearchViewModel", "Received search result during refresh: $item")
                    }
                }
            }catch (e:Exception){
                _isRefreshing.value = false
                _errorMessage.value = "Error refreshing data: ${e.message}"
                _isLoading.value = false
                Log.d("SearchViewModel", "Refresh ended")
                Log.d("SearchViewModel", "Loading ended")
                Log.d("SearchViewModel", e.toString())
            } finally {
                _isRefreshing.value = false
                _isLoading.value = false
                Log.d("SearchViewModel", "Refresh ended")
                Log.d("SearchViewModel", "Loading ended")
            }
        }
    }

    fun fetchLanguages(repositoryId: String, languagesUrl: String) {
        viewModelScope.launch {
            try {
                val languages = repository.getLanguages(languagesUrl)
                Log.d("SearchViewModel", "Fetched languages for repo $repositoryId: $languages")
                _languagesMap.value = _languagesMap.value.toMutableMap().apply {
                    this[repositoryId] = languages
                }
            } catch (e: Exception) {
                Log.e("fetchLanguages", "Error fetching languages: ${e.message}")
            }
        }
    }

    fun onQueryChanged(newQuery: String) {
        Log.d("SearchViewModel", "Query changed to: $newQuery")
        _query.value = newQuery
    }
}