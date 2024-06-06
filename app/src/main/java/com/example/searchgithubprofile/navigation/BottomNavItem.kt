package com.example.searchgithubprofile.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Search : BottomNavItem("Search", Icons.Filled.Search, "search")
    object About : BottomNavItem("About", Icons.Filled.Info, "about")
}