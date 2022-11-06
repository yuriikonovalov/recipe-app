package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.GetSavedRecipes
import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipe
import com.yuriikonovalov.recipeapp.fake.mapper.FakeRecipeMapperUi
import com.yuriikonovalov.recipeapp.fake.usecase.FakeGetSavedRecipes
import com.yuriikonovalov.recipeapp.fake.usecase.FakeUnsaveRecipe
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesEvent
import com.yuriikonovalov.recipeapp.util.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SavedRecipesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private fun initSUT(
        getSavedRecipes: GetSavedRecipes = FakeGetSavedRecipes(),
        unsaveRecipe: UnsaveRecipe = FakeUnsaveRecipe()
    ) = SavedRecipesViewModel(getSavedRecipes, unsaveRecipe, FakeRecipeMapperUi)


    @Test
    fun `if click the back button when windowSize is Expanded - event value should be NavigateUp`() {
        // BEFORE
        val sut = initSUT()
        val expected = SavedRecipesEvent.NavigateUp
        sut.onUpdateWindowSizeClass(WindowSizeClass.EXPANDED)

        // WHEN
        sut.onClickBackButton()

        // THEN
        val actual = sut.eventFlow.value
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if click the back button when windowSize is not Expanded and pane is not open - event value should be NavigateUp`() {
        // BEFORE
        val sut = initSUT()
        val expected = SavedRecipesEvent.NavigateUp
        sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)

        // WHEN
        sut.onClickBackButton()

        // THEN
        val actual = sut.eventFlow.value
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if click the back button when windowSize is not Expanded and pane is open - event value should be CloseDetailsPane`() {
        // BEFORE
        val sut = initSUT()
        val expected = SavedRecipesEvent.CloseDetailsPane
        sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)
        sut.onUpdatePaneState(true)

        // WHEN
        sut.onClickBackButton()

        // THEN
        val actual = sut.eventFlow.value
        assertThat(actual).isEqualTo(expected)
    }


    @Test
    fun `if click a save button on the last item - event value should CloseDetailsPane`() =
        runTest {
            // BEFORE
            val recipe = recipe(saved = true)
            val sut = initSUT(getSavedRecipes = FakeGetSavedRecipes(listOf(recipe)))
            val expected = SavedRecipesEvent.CloseDetailsPane
            sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)
            sut.onSelectRecipe(recipe.recipeUi())

            // WHEN
            sut.onSaveButtonClick()
            advanceUntilIdle()

            // THEN
            val actual = sut.eventFlow.value
            assertThat(actual).isEqualTo(expected)
        }
}