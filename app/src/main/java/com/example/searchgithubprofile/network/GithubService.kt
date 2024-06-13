package com.example.searchgithubprofile.network

import com.example.searchgithubprofile.model.file.FileItem
import com.example.searchgithubprofile.model.repo.ProfileData
import com.example.searchgithubprofile.model.repo.SearchDataRepoResponse
import com.example.searchgithubprofile.model.users.SearchDataUsersResponse

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.encodedPath
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

class GithubService(private val client: HttpClient) {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    suspend fun fetch(request: HttpRequestBuilder): HttpResponse {
        return client.request(request)
    }


    suspend fun searchInfo(query: String, page: Int, pageSize: Int): Pair<SearchDataRepoResponse, SearchDataUsersResponse> {
        return coroutineScope {
            val repositoriesDeferred = async { searchRepositories(query, page, pageSize) }
            val usersDeferred = async { searchUsers(query, page, pageSize) }

            val repositoriesResponse = repositoriesDeferred.await()
            val usersResponse = usersDeferred.await()

            repositoriesResponse to usersResponse
        }
    }

    private suspend fun searchRepositories(query: String, page: Int, pageSize: Int): SearchDataRepoResponse {
        val request = HttpRequestBuilder().apply {
            url {
                encodedPath = "search/repositories"
                parameters.append("q", query)
                parameters.append("page", page.toString())
                parameters.append("per_page", pageSize.toString())
            }
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }




    private suspend fun searchUsers(query: String, page: Int, pageSize: Int): SearchDataUsersResponse {
        val request = HttpRequestBuilder().apply {
            url {
                encodedPath = "search/users"
                parameters.append("q", query)
                parameters.append("page", page.toString())
                parameters.append("per_page", pageSize.toString())
            }
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }

    suspend fun getUserDetails(username: String): ProfileData {
        val request = HttpRequestBuilder().apply {
            url {
                encodedPath = "users/$username"
            }
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }

    suspend fun getRepositoryContents(owner: String, repo: String): List<FileItem> {
        val request = HttpRequestBuilder().apply {
            url {
                encodedPath = "repos/$owner/$repo/contents"
            }
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }

    suspend fun getLanguages(url: String): Map<String, Int> {
        val request = HttpRequestBuilder().apply {
            url(url)
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }

    suspend fun getAdditionalFiles(url: String): List<FileItem> {
        val request = HttpRequestBuilder().apply {
            url(url)
        }
        return fetch(request).let { response ->
            val responseBody = response.body<String>()
            json.decodeFromString(responseBody)
        }
    }
}

