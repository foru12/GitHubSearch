package com.example.searchgithubprofile.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchgithubprofile.model.file.FileItem
import com.example.searchgithubprofile.repo.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class RepositoryDetailsViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val TAG = "RepositoryDetailsViewModel"

    private val _files = MutableStateFlow<List<FileItem>?>(null)
    val files: StateFlow<List<FileItem>?> get() = _files

    private val _expandedFiles = MutableStateFlow<Map<String, List<FileItem>>>(emptyMap())
    val expandedFiles: StateFlow<Map<String, List<FileItem>>> get() = _expandedFiles

    private val _loadingStates = MutableStateFlow<Map<String, Boolean>>(emptyMap())
    val loadingStates: StateFlow<Map<String, Boolean>> get() = _loadingStates

    fun loadRepositoryContents(owner: String, repo: String) {
        viewModelScope.launch {
            try {
                val result = githubRepository.getRepositoryDetalis(owner, repo)
                _files.value = result
                Log.d(TAG, "Loaded repository contents successfully")
            } catch (e: Exception) {
                _files.value = emptyList()
                Log.e(TAG, "Error loading repository contents", e)
            }
        }
    }

    suspend fun loadAdditionalFiles(url: String): List<FileItem> {
        return githubRepository.getAdditionalFiles(url)
    }

    fun toggleExpanded(file: FileItem) {
        viewModelScope.launch {
            val currentState = _loadingStates.value[file.url] ?: false
            if (file.type == "dir") {
                if (_expandedFiles.value.containsKey(file.url)) {
                    val newMap = _expandedFiles.value.toMutableMap()
                    newMap.remove(file.url)
                    _expandedFiles.value = newMap
                    Log.d(TAG, "Collapsed folder: ${file.name}")
                } else {
                    if (!currentState) {
                        val newLoadingState = _loadingStates.value.toMutableMap()
                        newLoadingState[file.url] = true
                        _loadingStates.value = newLoadingState
                        Log.d(TAG, "Expanding folder: ${file.name}")

                        try {
                            val children = loadAdditionalFiles(file.url)
                            val newMap = _expandedFiles.value.toMutableMap()
                            newMap[file.url] = children
                            _expandedFiles.value = newMap
                            Log.d(TAG, "Loaded children for ${file.name}: ${children.size} items")
                        } catch (e: Exception) {
                            // handle error if needed
                            Log.e(TAG, "Error loading additional files for ${file.name}", e)
                        } finally {
                            val newLoadingState = _loadingStates.value.toMutableMap()
                            newLoadingState[file.url] = false
                            _loadingStates.value = newLoadingState
                            Log.d(TAG, "Finished loading children for ${file.name}")
                        }
                    }
                }
            }
        }
    }
}