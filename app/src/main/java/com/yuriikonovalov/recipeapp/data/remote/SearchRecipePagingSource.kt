package com.yuriikonovalov.recipeapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import retrofit2.HttpException
import java.io.IOException

/**
 * Implementation of [PagingSource] for [SearchRecipe].
 * @property remoteSource a remote data source.
 * @property query a query to search by.
 */
class SearchRecipePagingSource(
    private val remoteSource: RecipeRemoteDataSource,
    private val query: String
) : PagingSource<Int, SearchRecipe>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchRecipe> {
        return try {
            val position = params.key ?: 0
            val pageSize = params.loadSize.coerceAtMost(MAX_LIMIT)
            val response = remoteSource.searchRecipes(query, position, pageSize)
            val nextKey = if (response.recipes.isEmpty() || response.offset >= MAX_OFFSET) {
                null
            } else {
                (response.offset + response.number).coerceAtMost(MAX_OFFSET)
            }
            LoadResult.Page(
                data = response.recipes,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, SearchRecipe>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(state.config.pageSize)
            ?: page.nextKey?.minus(state.config.pageSize)
    }

    private companion object {
        /**
         * The max offset the server can handle.
         */
        const val MAX_OFFSET = 900

        /**
         * The max limit the server can handle.
         */
        const val MAX_LIMIT = 100
    }
}