package com.example.searchgithubprofile.model.repo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileData(
    @SerialName("login")
    val login: String,

    @SerialName("bio")
    val bio: String?,

    @SerialName("avatar_url")
    val avatarUrl: String,

    @SerialName("blog")
    val blog: String?,

    @SerialName("followers")
    val followers: Int,

    @SerialName("following")
    val following: Int
)