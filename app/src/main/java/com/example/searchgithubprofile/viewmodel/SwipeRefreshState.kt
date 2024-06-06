package com.example.searchgithubprofile.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class SwipeRefreshState(
    isRefreshing: Boolean = false
) {
    private val _isRefreshing: MutableState<Boolean> = mutableStateOf(isRefreshing)
    val isRefreshing: MutableState<Boolean>
        get() = _isRefreshing

    private val _refreshListeners: SnapshotStateList<() -> Unit> = SnapshotStateList()
    val refreshListeners: List<() -> Unit>
        get() = _refreshListeners

    fun isRefreshingChanged(newValue: Boolean) {
        _isRefreshing.value = newValue
    }

    fun addRefreshListener(listener: () -> Unit) {
        _refreshListeners.add(listener)
    }

    fun removeRefreshListener(listener: () -> Unit) {
        _refreshListeners.remove(listener)
    }

    fun clearRefreshListeners() {
        _refreshListeners.clear()
    }
}