package com.example.searchgithubprofile.model.repo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchDataRepoResponse(
    @SerialName("items")
    val items: List<RepositoryData>
)