package com.example.searchgithubprofile.model

import com.google.gson.annotations.SerializedName

data class RepositoryData(
    val id: Int,
    val name: String,
    val description: String?,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("stargazers_count") val stars: Int,
    val ownerData: OwnerData,
    @SerializedName("languages_url") val languages : String
)