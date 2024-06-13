package com.example.searchgithubprofile.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.searchgithubprofile.model.SearchItem
import com.example.searchgithubprofile.model.file.FileItem
import com.example.searchgithubprofile.network.GithubService
import com.example.searchgithubprofile.model.repo.ProfileData
import com.example.searchgithubprofile.model.repo.RepositoryData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepository @Inject constructor(private val service: GithubService) {
    fun getSearchResults(query: String): Flow<PagingData<SearchItem>> {


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
    suspend fun getRepositoryDetalis(owner:String,repo:String): List<FileItem> {
        return service.getRepositoryContents(owner,repo)
    }

    suspend fun getAdditionalFiles(url: String): List<FileItem> {
        return service.getAdditionalFiles(url)
    }
}