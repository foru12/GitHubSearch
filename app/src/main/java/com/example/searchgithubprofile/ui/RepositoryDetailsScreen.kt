package com.example.searchgithubprofile.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.searchgithubprofile.model.file.FileItem
import com.example.searchgithubprofile.viewmodel.RepositoryDetailsViewModel
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch

@Composable
fun FileListItem(file: FileItem, viewModel: RepositoryDetailsViewModel, navigateToWebView: (String) -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val expandedFiles by viewModel.expandedFiles.collectAsState()
    val loadingStates by viewModel.loadingStates.collectAsState()
    val children = expandedFiles[file.url]
    val isLoading = loadingStates[file.url] ?: false

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable(onClick = {
                if (file.type == "dir") {
                    viewModel.toggleExpanded(file)
                }
                if (file.type == "file"){
                    Log.d("Navigation", "Navigating to webview/${file.htmlUrl}")
                    navigateToWebView(file.htmlUrl.toString())


                }
            })
    ) {
        Icon(
            imageVector = getFileIcon(file.type),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = file.name)

        if (isLoading && children == null) {
            Spacer(modifier = Modifier.width(8.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp),
                strokeWidth = 2.dp
            )
        }
    }

    if (file.type == "dir" && children != null) {
        Column(modifier = Modifier.padding(start = 16.dp)) {
            children.forEach { child ->
                FileListItem(file = child, viewModel = viewModel,navigateToWebView = navigateToWebView)
            }
        }
    }
}
@Composable
fun RepositoryDetailsScreen(
    owner: String,
    repository: String,
    navigateToWebView: (String) -> Unit,
    viewModel: RepositoryDetailsViewModel = hiltViewModel(),

) {
    val files by viewModel.files.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRepositoryContents(owner, repository)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Repository Details", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        files?.let { fileList ->
            if (fileList.isNotEmpty()) {
                FileList(files = fileList, viewModel = viewModel, navigateToWebView = navigateToWebView)
            } else {
                Text(text = "No files found")
            }
        } ?: run {
            Text(text = "Loading...")
        }
    }
}

@Composable
fun FileList(files: List<FileItem>, viewModel: RepositoryDetailsViewModel,navigateToWebView: (String) -> Unit) {
    LazyColumn {
        items(files) { file ->
            FileListItem(file = file, viewModel = viewModel,navigateToWebView = navigateToWebView)
        }
    }
}

@Composable
fun getFileIcon(type: String): ImageVector {
    return when (type) {
        "file" -> Icons.Default.InsertDriveFile
        "dir" -> Icons.Default.Folder
        else -> Icons.Default.InsertDriveFile
    }
}
