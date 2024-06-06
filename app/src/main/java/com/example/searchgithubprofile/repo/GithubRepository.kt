package com.example.searchgithubprofile.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.searchgithubprofile.network.GithubService
import com.example.searchgithubprofile.RepositoryPagingSource
import com.example.searchgithubprofile.model.ProfileData
import com.example.searchgithubprofile.model.RepositoryData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepository @Inject constructor(private val service: GithubService) {
    fun getSearchResults(query: String): Flow<PagingData<RepositoryData>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { RepositoryPagingSource(service, query) }
        ).flow
    }

    suspend fun getUserDetails(username: String): ProfileData {
        return service.getUserDetails(username)
    }
    suspend fun getLanguages(url: String): Map<String, Int> {
        return service.getLanguages(url)
    }
}