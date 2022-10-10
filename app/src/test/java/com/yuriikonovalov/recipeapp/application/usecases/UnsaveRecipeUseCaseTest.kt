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
class UnsaveRecipeUseCaseTest : BaseUseCaseTest() {
    private lateinit var sut: UnsaveRecipeUseCase

    @Before
    fun setup() {
        super.setupBase()
        sut = UnsaveRecipeUseCase(repository)
    }

    @Test
    fun unsaveWhenRecipeHasCacheFlagAsTrue_shouldSetSavedFlagAsFalse() = runTest {
        // BEFORE
        val expectedRecipe = recipe(cache = true, saved = true)
        localDataSource.insertRecipe(expectedRecipe)

        // WHEN
        sut(expectedRecipe.id)

        // THEN
        val actualRecipe = localDataSource.getRecipeById(expectedRecipe.id)
        assertThat(actualRecipe).isNotNull()
        assertThat(actualRecipe!!.id).isEqualTo(expectedRecipe.id)
        assertThat(actualRecipe.saved).isFalse()
    }


    @Test
    fun unsaveWhenRecipeHasCacheFlagAsFalse_shouldDeleteRecipe() = runTest {
        // BEFORE
        val expectedRecipe = recipe(cache = false, saved = true)
        localDataSource.insertRecipe(expectedRecipe)

        // WHEN
        sut(expectedRecipe.id)

        // THEN
        val actualRecipe = localDataSource.getRecipeById(expectedRecipe.id)
        assertThat(actualRecipe).isNull()
    }
}