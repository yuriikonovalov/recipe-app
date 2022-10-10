package com.yuriikonovalov.recipeapp.presentation.savedrecipes

import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import com.yuriikonovalov.recipeapp.util.WindowSizeClass

data class SavedRecipesState(
    val recipes: List<RecipeUi> = emptyList(),
    val selectedRecipe: RecipeUi? = null,
    val measureSystem: MeasureSystem = MeasureSystem.Metric,
    val saved: Boolean = true,
    val initialSelectionDone: Boolean = false,
    val windowSizeClass: WindowSizeClass = WindowSizeClass.COMPACT,
    val paneOpen: Boolean = false
) {
    val emptyList: Boolean get() = recipes.isEmpty()
    val selectedRecipeCard: Int?
        get() = if (windowSizeClass == WindowSizeClass.EXPANDED) selectedRecipe?.id else null

    fun updateSelectedRecipe(recipe: RecipeUi): SavedRecipesState {
        return copy(selectedRecipe = recipe)
    }

    fun updateRecipes(recipes: List<RecipeUi>): SavedRecipesState {
        return copy(recipes = recipes)
    }

    fun updateMeasureSystem(measureSystem: MeasureSystem): SavedRecipesState {
        return copy(measureSystem = measureSystem)
    }

    fun updateWindowSizeClass(windowSizeClass: WindowSizeClass): SavedRecipesState {
        return copy(windowSizeClass = windowSizeClass)
    }

    fun updateInitialSelectionDone(done: Boolean): SavedRecipesState {
        return copy(initialSelectionDone = done)
    }

    fun updatePaneOpen(open: Boolean): SavedRecipesState {
        return copy(paneOpen = open)
    }
}
