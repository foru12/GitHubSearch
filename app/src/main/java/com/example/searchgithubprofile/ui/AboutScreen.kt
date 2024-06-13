package com.example.searchgithubprofile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("About this App", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text("This app demonstrates the use of Jetpack Compose, Paging 3, ktor, Hilt, Coil, and other modern Android development tools.")
    }
}