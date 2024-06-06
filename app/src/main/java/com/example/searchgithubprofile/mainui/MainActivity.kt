package com.example.searchgithubprofile.mainui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.compose.rememberImagePainter
import com.example.searchgithubprofile.MyApp
import com.example.searchgithubprofile.R
import com.example.searchgithubprofile.mainui.theme.SearchGitHubProfileTheme
import com.example.searchgithubprofile.model.RepositoryData
import com.example.searchgithubprofile.navigation.BottomNavItem
import com.example.searchgithubprofile.repo.GithubRepository
import com.example.searchgithubprofile.viewmodel.DateUtil.formatDateTime
import com.example.searchgithubprofile.viewmodel.SearchViewModel
import com.example.searchgithubprofile.viewmodel.SwipeRefreshState
import com.example.searchgithubprofile.viewmodel.UserDetailsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        NavGraph(navController = navController)
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Search,
        BottomNavItem.About
    )

    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "search",
        modifier = modifier
    ) {
        composable("search") {
            SearchScreen(

                navigateToUserDetails = { username ->
                    navController.navigate("userDetails/$username")
                },

                )
        }
        composable("about") {
            AboutScreen()
        }
        composable("userDetails/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            if (username != null) {
                UserDetailsScreen(username)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navigateToUserDetails: (String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val repositories = viewModel.searchResults.collectAsLazyPagingItems()
    val scrollState = rememberLazyListState()
    var isImageVisible by remember { mutableStateOf(true) }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.onQueryChanged(it.text)
            },
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            state = scrollState // Состояние прокрутки
        ) {
            items(repositories.itemCount) { index ->
                val repository = repositories.get(index)
                if (repository != null) {
                    RepositoryItem(repository, { username ->
                        navigateToUserDetails(username)
                    }, viewModel)
                }
            }
        }


    }


    Box(modifier = Modifier.fillMaxSize()) {

        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut(),

            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .offset(y = (-100).dp)
                .align(Alignment.BottomEnd)
                .clickable(onClick = {

                })

        ) {
            Image(
                painter = painterResource(id = R.drawable.top_arrow_ic),
                contentDescription = "Your custom image",
                modifier = Modifier
                    .graphicsLayer(rotationZ = -90f)
                    .size(50.dp)


            )
        }

        LaunchedEffect(scrollState) {
            scrollState.scrollToItem(0)
        }


    }

}


@Composable
fun SwipeRefreshCompose() {
    var refreshing by remember { mutableStateOf(false) }
    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(500)
            refreshing = false
        }
    }
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = { refreshing = true },
    ) {


        //todo
    }
}


@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("About this App", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text("This app demonstrates the use of Jetpack Compose, Paging 3, Retrofit, Hilt, Coil, and other modern Android development tools.")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    username: String,
    viewModel: UserDetailsViewModel = hiltViewModel()
) {
    val user by viewModel.userDetails.collectAsState()

    LaunchedEffect(username) {
        viewModel.setUsername(username)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Details") }
            )
        }
    ) {
        user.let { user ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                /*  AsyncImage(
                      model = user.avatarUrl,
                      contentDescription = null,
                      modifier = Modifier
                          .size(100.dp)
                          .align(Alignment.CenterHorizontally)
                  )*/
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    user.login,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    user.bio ?: "No bio available",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Followers: ${user.followers}", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("Following: ${user.following}", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                user.blog?.let { blog ->
                    if (blog.isNotEmpty()) {
                        Text(
                            "Website: $blog",
                            color = Color.Blue,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                user.blog?.let {
                    if (it.isNotEmpty()) {
                        Text(
                            "Twitter: @$it",
                            color = Color.Blue,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RepositoryItem(
    repository: RepositoryData,
    onClick: (String) -> Unit,
    viewModel: SearchViewModel
) {
    val languages by viewModel.languagesMap.collectAsState()
    val repositoryLanguages = languages[repository.id.toString()]


    val languagesText =
        repositoryLanguages?.entries?.joinToString(separator = "\n") { "${it.key}: ${it.value}" }
            ?: "Loading..."
    var isLanguagesVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                repository?.name?.let { login ->
                    onClick(login)
                } ?: run {
                    Log.d("GOIEWN", "GGEWG")
                }
            },

        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)


            ) {
                Image(
                    painter = if (repository != null && repository.ownerData != null && repository.ownerData.avatarUrl != null) {
                        rememberImagePainter(

                            data = repository.ownerData.avatarUrl,
                            builder = {
                                placeholder(R.drawable.place_holder_im)
                                kotlin.error(R.drawable.user)
                            }
                        )
                    } else {
                        painterResource(id = R.drawable.user)
                    },
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(repository.name, fontWeight = FontWeight.Bold)
                    repository.description?.let { Text(it) }
                    Text("Stars: ${repository.stars}")
                    Text("Updated: ${formatDateTime(repository.updatedAt)}")
                    Button(onClick = {
                        isLanguagesVisible = !isLanguagesVisible
                        if (repositoryLanguages == null) {
                            viewModel.fetchLanguages(repository.id.toString(), repository.languages)
                        }
                    }) {
                        Text(if (isLanguagesVisible) "Hide Languages" else "Show Languages")
                    }

                    if (isLanguagesVisible) {
                        Text(languagesText) // Отображение языков в Text
                    }
                }
            }
        }
    }
}









