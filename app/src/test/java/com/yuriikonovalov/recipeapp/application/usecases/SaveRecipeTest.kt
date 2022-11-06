package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.*
import com.yuriikonovalov.recipeapp.fake.repository.initRepository
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class SaveRecipeTest {

    @Test
    fun `if a recipe is not in cache - should get it from remote and set a save flag as true and return Resource_Success with its id`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val repository = initRepository(localRecipes = emptyList(), remoteRecipe = expected)
            val sut = SaveRecipeImpl(repository)

            // WHEN
            val actual = sut(expected.id)

            // THEN
            assertThat(actual).isInstanceOf(Resource.Success::class.java)
            assertThat((actual as Resource.Success).data).isEqualTo(expected.id)
        }

    @Test
    fun `if recipe is in cache - should set a save flag as true and return Resource_Success with its id`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val repository = initRepository(localRecipes = listOf(expected))
            val sut = SaveRecipeImpl(repository)

            // WHEN
            val actual = sut(expected.id)

            // THEN
            assertThat(actual).isInstanceOf(Resource.Success::class.java)
            assertThat((actual as Resource.Success).data).isEqualTo(expected.id)
        }

    @Test
    fun `if recipe is not in cache and getRemote throw an exception- return Resource_Failure`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val repository = initRepository(localRecipes = emptyList(), getRemoteRecipeThrow = true)
            val sut = SaveRecipeImpl(repository)

            // WHEN
            val actual = sut(expected.id)

            // THEN
            assertThat(actual).isInstanceOf(Resource.Failure::class.java)
        }
}