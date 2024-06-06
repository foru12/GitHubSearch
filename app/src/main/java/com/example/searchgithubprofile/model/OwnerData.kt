package com.example.searchgithubprofile.model

import com.google.gson.annotations.SerializedName


data class OwnerData(
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)