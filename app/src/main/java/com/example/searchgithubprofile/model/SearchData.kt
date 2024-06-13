package com.example.searchgithubprofile.model

sealed class SearchItem {
    data class User(
        val login: String?,
        val avatarUrl: String?,
        val score: Double?,
        val htmlUrl: String?
    ) : SearchItem()

    data class Repository(
        val name: String?,
        val description: String?,
        val forksCount: String?,
        val owner : String
    ) : SearchItem()
}