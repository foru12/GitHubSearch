package com.example.searchgithubprofile

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.searchgithubprofile.model.RepositoryData
import com.example.searchgithubprofile.network.GithubService

class RepositoryPagingSource(
    private val service: GithubService,
    private val query: String
) : PagingSource<Int, RepositoryData>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryData> {
        return try {
            val page = params.key ?: 1
            val response = service.searchRepositories(query, page, params.loadSize)
            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.items.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositoryData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}