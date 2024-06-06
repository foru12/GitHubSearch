package com.example.searchgithubprofile.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.searchgithubprofile.model.RepositoryData
import com.example.searchgithubprofile.repo.GithubRepository
import com.example.searchgithubprofile.viewmodel.DateUtil.formatDateTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {
    private val _query = MutableStateFlow("")
    private val _languagesMap = MutableStateFlow<Map<String, Map<String, Int>>>(emptyMap())
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing



    val languagesMap: StateFlow<Map<String, Map<String, Int>>> = _languagesMap



    var searchResults = _query.flatMapLatest { query ->
        if (query.isEmpty()) {
            flowOf(PagingData.empty())
        } else {
            repository.getSearchResults(query).cachedIn(viewModelScope)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    // Метод для обновления данных
    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                searchResults = _query.flatMapLatest { query ->
                    if (query.isEmpty()) {
                        flowOf(PagingData.empty())
                    } else {
                        repository.getSearchResults(query).cachedIn(viewModelScope)
                    }
                }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
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
                Log.e("fetchLanguages", "Error fetching languages: ${e.message}")
            }
        }
    }


    fun onQueryChanged(newQuery: String) {
        Log.d("onQueryChanged",newQuery)
        _query.value = newQuery
    }
}