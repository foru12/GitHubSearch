package com.example.searchgithubprofile.model

import com.google.gson.annotations.SerializedName


data class ProfileData(
    val login: String,
    val bio: String?,
    @SerializedName("avatar_url") val avatarUrl: String,
    val blog: String?,
    val followers: Int,
    val following: Int
)