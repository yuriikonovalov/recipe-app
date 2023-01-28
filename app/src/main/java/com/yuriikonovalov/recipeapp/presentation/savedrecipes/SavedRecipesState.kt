package com.yuriikonovalov.recipeapp.presentation.savedrecipes

import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import com.yuriikonovalov.recipeapp.util.WindowSizeClass

/**
 * This class holds state of the saved recipes screen.
 *
 * @property recipes a list of all saved recipes.
 * @property selectedRecipe a recipe that is shown in the details pane.
 * @property measureSystem a [MeasureSystem] that is used for displaying ingredients amounts.
 * @property saved a flag for denoting that a recipe is saved.
 * @property windowSizeClass an instance of [WindowSizeClass] that points to the current window size.
 * @property paneOpen shows if the details pane is open or not.
 */
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
