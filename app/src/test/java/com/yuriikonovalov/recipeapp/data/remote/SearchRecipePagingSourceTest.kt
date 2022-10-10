package com.yuriikonovalov.recipeapp.data.remote

import androidx.paging.PagingSource.LoadParams.Refresh
import androidx.paging.PagingSource.LoadResult
import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.util.searchRecipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchRecipePagingSourceTest {
    private lateinit var sut: SearchRecipePagingSource

    @Mock
    lateinit var remoteDataSource: RecipeRemoteDataSource

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        sut = SearchRecipePagingSource(remoteDataSource, "pizza")
    }

    @Test
    fun loadReturnsResultPage() = runTest {
        // BEFORE
        val response = SearchRecipeResponse(1, 0, listOf(searchRecipe()), 1)
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenReturn(response)

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
    fun loadReturnsResultErrorWhenIOExceptionThrown() = runTest {
        // BEFORE
        val throwable = IOException()
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenThrow(throwable)

        // WHEN
        val actual = sut.load(
            Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        // THEN
        val expected = LoadResult.Error<Int, SearchRecipe>(throwable)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun loadReturnsResultErrorWhenHttpExceptionThrown() = runTest {
        // BEFORE
        val throwable = HttpException(Response.success(null))
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenThrow(throwable)

        // WHEN
        val actual = sut.load(
            Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        // THEN
        val expected = LoadResult.Error<Int, SearchRecipe>(throwable)
        assertThat(actual).isEqualTo(expected)
    }

    @Test(expected = java.lang.RuntimeException::class)
    fun propagateExceptionOtherThanHttpOrIO() = runTest {
        // BEFORE
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenThrow(java.lang.RuntimeException())

        // WHEN
        sut.load(Refresh(key = null, loadSize = 1, placeholdersEnabled = false))
    }


    @Test(expected = java.lang.NullPointerException::class)
    fun propagateNullPointerExceptionWhenApiCallReturnsNull() = runTest {
        // BEFORE
        whenever(remoteDataSource.searchRecipes(anyString(), anyInt(), anyInt()))
            .thenReturn(null)

        // WHEN
        sut.load(Refresh(key = null, loadSize = 1, placeholdersEnabled = false))
    }
}