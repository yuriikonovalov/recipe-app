package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GetRecipeDetailsUseCaseTest : BaseUseCaseTest() {
    private lateinit var sut: GetRecipeDetailsUseCase

    @Before
    fun setup() {
        super.setupBase()
        sut = GetRecipeDetailsUseCase(repository)
    }

    @Test
    fun recipeIsInCache_returnRecipe() = runTest {
        // BEFORE
        val expectedRecipe = recipe(cache = true)
        localDataSource.insertRecipe(expectedRecipe)

        // WHEN
        val resource = sut(expectedRecipe.id)

        // THEN
        val actualRecipe = (resource.first() as Resource.Success).data
        assertThat(actualRecipe).isEqualTo(expectedRecipe)
    }

    @Test
    fun recipeIsNotInCache_loadRecipeFromRemoteAndSaveInCacheThenReturnIt() = runTest {
        // BEFORE
        val expectedRecipe = recipe()
        remoteDataSourceAsFake.recipe = expectedRecipe
        // Make sure there's no recipe in local data source
        assertThat(localDataSource.getRecipeById(expectedRecipe.id)).isNull()

        // WHEN
        val resource = sut(expectedRecipe.id)

        // THEN
        assertThat(localDataSource.getRecipeById(expectedRecipe.id)).isEqualTo(expectedRecipe)
        val actualRecipe = (resource.first() as Resource.Success).data
        assertThat(actualRecipe).isEqualTo(expectedRecipe)
    }
}