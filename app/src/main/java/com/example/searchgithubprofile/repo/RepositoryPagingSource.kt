package com.example.searchgithubprofile.repo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.searchgithubprofile.model.SearchItem
import com.example.searchgithubprofile.model.repo.RepositoryData
import com.example.searchgithubprofile.network.GithubService
import io.ktor.utils.io.errors.IOException

class RepositoryPagingSource(
    private val service: GithubService,
    private val query: String
) : PagingSource<Int, SearchItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchItem> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val (repositoriesResponse, usersResponse) = service.searchInfo(query, page, pageSize)

            val repositoryItems = repositoriesResponse.items.map { repository ->
                SearchItem.Repository(
                    name = repository.name,
                    description = repository.description,
                    forksCount = repository.forksCount.toString(),
                    owner = repository.ownerData?.login.toString()
                )
            }

            val userItems = usersResponse.items.map { user ->
                SearchItem.User(
                    login = user.login,
                    avatarUrl = user.avatarUrl,
                    score = user.score,
                    htmlUrl = user.htmlUrl
                )
            }

            val combinedList = repositoryItems + userItems
            val sortedList = combinedList.sortedBy {
                when (it) {
                    is SearchItem.User -> it.login
                    is SearchItem.Repository -> it.name
                }
            }

            LoadResult.Page(
                data = sortedList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (sortedList.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SearchItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}