package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.fake.repository.initRepository
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class UnsaveRecipeTest {

    @Test
    fun `if unsave a recipe - should return Resource_Success`() = runTest {
        // BEFORE
        val expected = recipe()
        val sut = UnsaveRecipeImpl(initRepository(localRecipes = listOf(expected)))

        // WHEN
        val actual = sut(expected.id)

        // THEN
        assertThat(actual).isInstanceOf(Resource.Success::class.java)
    }


    @Test
    fun `if unsave a recipe and an exception is thrown- should return Resource_Failure`() =
        runTest {
            // BEFORE
            val expected = recipe()
            val sut = UnsaveRecipeImpl(initRepository(localRecipes = emptyList()))

            // WHEN
            val actual = sut(expected.id)

            // THEN
            assertThat(actual).isInstanceOf(Resource.Failure::class.java)
        }
}