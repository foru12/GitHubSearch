package com.example.searchgithubprofile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchgithubprofile.model.ProfileData
import com.example.searchgithubprofile.repo.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    val userDetails = username.flatMapLatest { username ->
        flow {
            emit(repository.getUserDetails(username))
        }.catch { emit(ProfileData("", "", "", "", 0, 0)) }
    }.stateIn(viewModelScope, SharingStarted.Lazily, ProfileData("", "", "", "", 0, 0))

    fun setUsername(newUsername: String) {
        _username.value = newUsername
    }
}