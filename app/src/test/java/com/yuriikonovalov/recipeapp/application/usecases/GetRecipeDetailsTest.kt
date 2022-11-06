package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.fake.repository.initRepository
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GetRecipeDetailsTest {

    @Test
    fun `if a recipe is in cache - should return Resource_Success`() = runTest {
        // BEFORE
        val expected = recipe(cache = true)
        val repository = initRepository(localRecipes = listOf(expected))
        val sut = GetRecipeDetailsImpl(repository)

        // WHEN
        val actual = sut(expected.id).first()

        // THEN
        assertThat(actual).isInstanceOf(Resource.Success::class.java)
        assertThat((actual as Resource.Success).data).isEqualTo(expected)
    }

    @Test
    fun `if a recipe is not in cache  - should load the recipe from remote and save in cache, then return it`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val repository = initRepository(remoteRecipe = expected)
            val sut = GetRecipeDetailsImpl(repository)

            // WHEN
            val actual = sut(expected.id).first()

            // THEN
            assertThat(actual).isInstanceOf(Resource.Success::class.java)
            assertThat((actual as Resource.Success).data).isEqualTo(expected)
        }


    @Test
    fun `if a recipe is not in cache and an exception is thrown during remote loading  - should return Resource_Failure`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val repository = initRepository(localRecipes = emptyList(), getRemoteRecipeThrow = true)
            val sut = GetRecipeDetailsImpl(repository)

            // WHEN
            val actual = sut(expected.id).first()

            // THEN
            assertThat(actual).isInstanceOf(Resource.Failure::class.java)
        }
}