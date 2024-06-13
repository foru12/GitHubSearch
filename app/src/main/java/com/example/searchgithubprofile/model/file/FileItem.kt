package com.example.searchgithubprofile.model.file

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileItem(
    val name: String,
    val type: String,
    val url : String,
    @SerialName("html_url") var htmlUrl: String? = null,
    var children: List<FileItem>? = null,
    var isExpanded: Boolean = false,
    var isLoading: Boolean = false
)
