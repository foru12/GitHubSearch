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
import io.ktor.util.network.UnresolvedAddressException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
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
    private val _newSearchResults = MutableStateFlow<PagingData<SearchItem>>(PagingData.empty())

    val isLoading: StateFlow<Boolean> = _isLoading
    val isRefreshing: StateFlow<Boolean> = _isRefreshing
    val errorMessage: StateFlow<String?> = _errorMessage
    val languagesMap: StateFlow<Map<String, Map<String, Int>>> = _languagesMap
    val newSearchResults: StateFlow<PagingData<SearchItem>> = _newSearchResults

    init {

        viewModelScope.launch {
            try {
                _query.flatMapLatest { query ->
                    if (query.isEmpty()) {
                        _isLoading.value = true
                        flowOf(PagingData.empty<SearchItem>())
                    } else {
                        _isLoading.value = true
                        //Специальная задержка для показа
                        delay(5000)
                        repository.getSearchResults(query).cachedIn(viewModelScope)
                    }
                }.collectLatest {
                    _newSearchResults.value = it
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                handleRefreshError(e)
            }

        }


    }

    private fun handleRefreshError(exception: Exception) {
        when (exception) {
            is IOException -> {
                _errorMessage.value = "Network error: Check your internet connection"
            }

            is UnresolvedAddressException -> {
                _errorMessage.value = "Unresolved address error: Please try again later"
            }

            else -> {
                _errorMessage.value = "Error refreshing data: ${exception.message}"
            }
        }
        Log.e("SearchViewModel", "Refresh error", exception)
    }

    fun refresh() {
        viewModelScope.launch {
            Log.d("SearchViewModel", "Refresh started")
            try {
                _isRefreshing.value = true
                _errorMessage.value = null
                _newSearchResults.value = PagingData.empty() // Очистка предыдущих результатов
                val currentQuery = _query.value
                if (currentQuery.isNotEmpty()) {
                    //Специальная задержка для показа
                    delay(5000)
                    //Спецаильная ошибка для теста
                    //throw RuntimeException("Simulated error for testing purposes")
                    val newResults =
                        repository.getSearchResults(currentQuery).cachedIn(viewModelScope).first()
                    _newSearchResults.value = newResults
                }
            } catch (e: Exception) {
                handleRefreshError(e)
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    fun fetchLanguages(repositoryId: String, languagesUrl: String) {
        viewModelScope.launch {
            try {
                val languages = repository.getLanguages(languagesUrl)
                _languagesMap.value = _languagesMap.value.toMutableMap().apply {
                    this[repositoryId] = languages
                }
            } catch (e: Exception) {
                handleRefreshError(e)
              
            }
        }
    }

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }
}