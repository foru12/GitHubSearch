package com.example.searchgithubprofile.model.users

import com.example.searchgithubprofile.model.repo.RepositoryData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchDataUsersResponse(
    @SerialName("items")
    val items: List<UserData>
)
