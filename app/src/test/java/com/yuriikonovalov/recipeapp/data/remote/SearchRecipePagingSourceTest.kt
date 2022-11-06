package com.yuriikonovalov.recipeapp.data.remote

import androidx.paging.PagingSource.LoadParams.Refresh
import androidx.paging.PagingSource.LoadResult
import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.util.searchRecipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

@ExperimentalCoroutinesApi
class SearchRecipePagingSourceTest {
    private val remoteDataSource: RecipeRemoteDataSource = mock()

    @Test
    fun `if load - return ResultPage`() = runTest {
        // BEFORE
        val response = SearchRecipeResponse(1, 0, listOf(searchRecipe()), 1)
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenReturn(response)
        val sut = SearchRecipePagingSource(remoteDataSource, "pizza")
        // WHEN
        val actual = sut.load(
            Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        // THEN
        val expected = LoadResult.Page(
            data = response.recipes,
            prevKey = null,
            nextKey = 1
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if load and IOException is thrown- returns ResultError`() = runTest {
        // BEFORE
        val throwable = IOException()
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenThrow(throwable)
        val sut = SearchRecipePagingSource(remoteDataSource, "pizza")

        // WHEN
        val actual = sut.load(
            Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        // THEN
        val expected = LoadResult.Error<Int, SearchRecipe>(throwable)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if load and HttpException is thrown - returns ResultError`() = runTest {
        // BEFORE
        val throwable = HttpException(Response.success(null))
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenThrow(throwable)
        val sut = SearchRecipePagingSource(remoteDataSource, "pizza")

        // WHEN
        val actual = sut.load(
            Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        // THEN
        val expected = LoadResult.Error<Int, SearchRecipe>(throwable)
        assertThat(actual).isEqualTo(expected)
    }

    @Test(expected = java.lang.RuntimeException::class)
    fun `if load and an exception is neither HttpException nor IOException = should propagate the exception`() =
        runTest {
            // BEFORE
            whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
                .thenThrow(java.lang.RuntimeException())
            val sut = SearchRecipePagingSource(remoteDataSource, "pizza")

            // WHEN
            sut.load(Refresh(key = null, loadSize = 1, placeholdersEnabled = false))
        }


    @Test(expected = java.lang.NullPointerException::class)
    fun `if api call returns null - should propagate NullPointerException`() = runTest {
        // BEFORE
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenReturn(null)
        val sut = SearchRecipePagingSource(remoteDataSource, "pizza")

        // WHEN
        sut.load(Refresh(key = null, loadSize = 1, placeholdersEnabled = false))
    }
}