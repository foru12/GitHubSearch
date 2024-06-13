package com.example.searchgithubprofile.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
            val context = LocalContext.current
            SearchScreen(
                handleUserClick = {
                    handleUserClick(context, it.htmlUrl.toString())
                },
                handleRepositoryClick = {
                    Log.d("Repository clicked", "${it.name}")
                    Log.d("Repository clicked", "${it.owner}")
                    navController.navigate("repositoryDetails/${it.owner}/${it.name}")
                },

            )
        }
        composable("about") {
            AboutScreen()
        }

        composable(
            route = "repositoryDetails/{owner}/{repositoryName}",
            arguments = listOf(
                navArgument("owner") { type = NavType.StringType },
                navArgument("repositoryName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner")
            val repositoryName = backStackEntry.arguments?.getString("repositoryName")
            if (owner != null && repositoryName != null) {
                RepositoryDetailsScreen(owner, repositoryName, {url ->
                    navController.navigate("webview/${Uri.encode(url)}")
                })
            } else {
                Text("Данные о репозитории отсутствуют")
            }
        }

        composable(
            route = "webview/{url}",
            arguments = listOf(
                navArgument("url") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")
            if (url != null) {
                WebViewScreen(url)
            } else {
                Text("Invalid URL")
            }
        }
    }
}

fun handleUserClick(context: Context ,htmlUrl: String) {
    Log.d("User clicked", "Original URL: $htmlUrl")

    val correctedUrl = if (!htmlUrl.startsWith("http://") && !htmlUrl.startsWith("https://")) {
        "https://$htmlUrl"
    } else {
        htmlUrl
    }

    Log.d("User clicked", "Corrected URL: $correctedUrl")

    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(correctedUrl)).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        val chooser = Intent.createChooser(intent, "Выберите браузер")
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(chooser)

    } catch (e: Exception) {
        Log.e("User clicked", "Error occurred while trying to open the URL: ${e.message}")
    }

}

