package com.example.searchgithubprofile.network

import com.example.searchgithubprofile.model.ProfileData
import com.example.searchgithubprofile.model.SearchDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubService {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): SearchDataResponse

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): ProfileData


    @GET
    suspend fun getLanguages(@Url url: String): Map<String, Int>
}