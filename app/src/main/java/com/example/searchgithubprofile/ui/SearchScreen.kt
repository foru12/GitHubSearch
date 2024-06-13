package com.example.searchgithubprofile.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.material.Card
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.searchgithubprofile.model.SearchItem
import com.example.searchgithubprofile.model.repo.RepositoryData
import com.example.searchgithubprofile.model.users.UserData
import com.example.searchgithubprofile.viewmodel.SearchViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    handleUserClick: (SearchItem.User) -> Unit,
    handleRepositoryClick: (SearchItem.Repository) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var isSearchInitiated by remember { mutableStateOf(false) }
    val repositories = viewModel.searchResults.collectAsLazyPagingItems()
    val scrollState = rememberLazyListState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (isSearchInitiated) Arrangement.Top else Arrangement.Center
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    if (!isLoading && !isRefreshing) {
                        searchText = it
                        if (it.text.isEmpty()) {
                            isSearchInitiated = false
                        }
                    }
                },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                enabled = !isLoading && !isRefreshing,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            Log.d("isLoading",isLoading.toString())
                            Log.d("isRefreshing",isRefreshing.toString())
                            if (!isLoading && !isRefreshing) {
                                isSearchInitiated = true
                                viewModel.onQueryChanged(searchText.text)
                            }
                        },
                        enabled = !isLoading && !isRefreshing
                    ) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    cursorColor = Color.Black
                )

            )

            // Отображаем сообщение об ошибке, если оно есть
            errorMessage?.let { message ->
                Text(
                    text = message,
                    color = Color.Red,
                    modifier = Modifier.padding(8.dp)
                )
            }

            // Отображаем индикатор загрузки
            if (isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            } else if (isSearchInitiated && errorMessage == null) {
                // Отображаем список результатов или индикатор загрузки
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing),
                    onRefresh = { viewModel.refresh() },
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(repositories.itemCount) { index ->
                            val item = repositories[index]
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                elevation = 4.dp,
                                shape = MaterialTheme.shapes.medium
                            ) {
                                when (item) {
                                    is SearchItem.User -> {
                                        UserItem(item) {
                                            handleUserClick(it)
                                        }
                                    }
                                    is SearchItem.Repository -> {
                                        RepositoryItem(item) { repositoryName ->
                                            handleRepositoryClick(repositoryName)
                                        }
                                    }

                                    else -> {Text("Unsupported item type")}
                                }
                            }
                        }
                    }
                }
            }
        }

        val coroutineScope = rememberCoroutineScope()
        if (scrollState.firstVisibleItemIndex > 0) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp, bottom = 56.dp)
                    .align(Alignment.BottomEnd)
            ) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            scrollState.animateScrollToItem(0)
                        }
                    },
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowUpward,
                        contentDescription = "Scroll to top"
                    )
                }
            }
        }
    }
}
