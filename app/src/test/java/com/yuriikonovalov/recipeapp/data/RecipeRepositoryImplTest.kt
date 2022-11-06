package com.yuriikonovalov.recipeapp.data

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.fake.datasource.FakePreferenceDataStore
import com.yuriikonovalov.recipeapp.fake.datasource.FakeRecipeLocalDataSource
import com.yuriikonovalov.recipeapp.fake.datasource.FakeRecipeRemoteDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeRepositoryImplTest {
    private lateinit var sut: RecipeRepository

    @Before
    fun setup() {
        val localDataSource = FakeRecipeLocalDataSource()
        val remoteDataSource = FakeRecipeRemoteDataSource()
        val preferenceDataSource = FakePreferenceDataStore()
        sut = RecipeRepositoryImpl(localDataSource, remoteDataSource, preferenceDataSource)
    }

    @Test
    fun `if randomRecipes call returns an empty list - should not update`() = runTest {
        // BEFORE
        val date = "12 Oct 2022"
        val expectedSizeOfRandomRecipes = sut.getRandomRecipes().first().size

        // WHEN
        // Passing 0 makes 'getRandomRecipes' return an empty list.
        sut.refreshRandomRecipeCache(0, date)

        // THEN
        val actual = sut.getLastCacheDate().first()
        assertThat(actual).isNotEqualTo(date)

        val actualSizeOfRandomRecipes = sut.getRandomRecipes().first().size
        assertThat(actualSizeOfRandomRecipes).isEqualTo(expectedSizeOfRandomRecipes)
    }

    @Test
    fun `if randomRecipes call returns a not empty list - should update`() = runTest {
        // BEFORE
        val expectedDate = "12 Oct 2022"
        val expectedNumberOfRecipes = 10

        // WHEN
        sut.refreshRandomRecipeCache(expectedNumberOfRecipes, expectedDate)

        // THEN
        val actualDate = sut.getLastCacheDate().first()
        assertThat(actualDate).isEqualTo(expectedDate)

        val actualSizeOfRandomRecipes = sut.getRandomRecipes().first().size
        assertThat(actualSizeOfRandomRecipes).isEqualTo(expectedNumberOfRecipes)
    }

    @Test
    fun `if updating is successful - recipes should have a saved flag as true`() = runTest {
        // BEFORE
        val expectedDate = "12 Oct 2022"
        val expectedNumberOfRecipes = 3

        // WHEN
        sut.refreshRandomRecipeCache(expectedNumberOfRecipes, expectedDate)

        // THEN
        val actualFlags = sut.getRandomRecipes().first().map { it.cache }
        assertThat(actualFlags).doesNotContain(false)
    }
}