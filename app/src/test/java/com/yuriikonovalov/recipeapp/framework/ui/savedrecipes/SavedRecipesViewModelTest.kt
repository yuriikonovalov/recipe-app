package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.GetSavedRecipesUseCase
import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipeUseCase
import com.yuriikonovalov.recipeapp.framework.ui.BaseViewModelTest
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesEvent
import com.yuriikonovalov.recipeapp.util.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class SavedRecipesViewModelTest : BaseViewModelTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var sut: SavedRecipesViewModel

    @Before
    fun setup() {
        super.setupBase()
        sut = SavedRecipesViewModel(
            GetSavedRecipesUseCase(repository),
            UnsaveRecipeUseCase(repository),
            mainDispatcherRule.testDispatcherProvider,
            FakeRecipeMapperUi
        )
    }

    @Test
    fun onClickBackButtonWhenWindowSizeExpanded_shouldNavigateUp() {
        // BEFORE
        sut.onUpdateWindowSizeClass(WindowSizeClass.EXPANDED)

        // WHEN
        sut.onClickBackButton()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(SavedRecipesEvent.NavigateUp)
    }

    @Test
    fun onClickBackButtonWhenWindowSizeIsNotExpandedAndPaneNotOpen_shouldNavigateUp() {
        // BEFORE
        sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)

        // WHEN
        sut.onClickBackButton()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(SavedRecipesEvent.NavigateUp)
    }

    @Test
    fun onClickBackButtonWhenWindowSizeIsNotExpandedAndPaneIsOpen_shouldClosePane() {
        // BEFORE
        sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)
        sut.onUpdatePaneState(true)

        // WHEN
        sut.onClickBackButton()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(SavedRecipesEvent.CloseDetailsPane)
    }


    @Test
    fun onSaveButtonClickOnLastItem_shouldUnsaveRecipeAndClosePane() = runTest {
        // BEFORE
        val recipe = recipe(saved = true)
        localDataSource.insertRecipe(recipe)
        sut.onUpdateWindowSizeClass(WindowSizeClass.COMPACT)
        sut.onSelectRecipe(recipe.recipeUi())

        // WHEN
        sut.onSaveButtonClick()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(SavedRecipesEvent.CloseDetailsPane)
        assertThat(repository.getSavedRecipes().first()).isEmpty()
    }
}