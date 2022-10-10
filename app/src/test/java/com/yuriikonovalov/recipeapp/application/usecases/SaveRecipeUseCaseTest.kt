package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class SaveRecipeUseCaseTest : BaseUseCaseTest() {

    private lateinit var sut: SaveRecipeUseCase

    @Before
    fun setup() {
        super.setupBase()
        sut = SaveRecipeUseCase(repository)
    }

    @Test
    fun recipeIsNotInCache_shouldGetFromRemoteAndSetSaveFlagAsTrue() = runTest {
        // BEFORE
        val expectedRecipe = recipe()
        remoteDataSourceAsFake.recipe = expectedRecipe

        // WHEN
        sut(expectedRecipe.id)

        // THEN
        // Get the recipe from local data source.
        val actualRecipe = localDataSource.getRecipeById(expectedRecipe.id)!!
        assertThat(actualRecipe.id).isEqualTo(expectedRecipe.id)
        assertThat(actualRecipe.saved).isTrue()
    }

    @Test
    fun recipeIsInCache_shouldSetSaveFlagAsTrue() = runTest {
        // BEFORE
        // A recipe is in cache but not saved.
        val expectedRecipe = recipe(cache = true, saved = false)
        localDataSource.insertRecipe(expectedRecipe)

        // WHEN
        sut(expectedRecipe.id)

        // THEN
        // Get the recipe from local data source.
        val actualRecipe = localDataSource.getRecipeById(expectedRecipe.id)!!
        assertThat(actualRecipe.id).isEqualTo(expectedRecipe.id)
        assertThat(actualRecipe.saved).isTrue()
    }
}