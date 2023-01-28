package com.yuriikonovalov.recipeapp.presentation.recipedetails

import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi

/**
 * This class holds state of the recipe details screen.
 *
 * @property recipe a recipe details of which are shown.
 * @property measureSystem a [MeasureSystem] that is used for displaying ingredients amounts.
 * @property loading a flag to show if data is loading or not.
 * @property error a flag to show that there's been an error during loading.
 */
data class RecipeDetailsState(
    val recipe: RecipeUi? = null,
    val measureSystem: MeasureSystem = MeasureSystem.Metric,
    val loading: Boolean = true,
    val error: Boolean = false
) {
    val contentVisible get() = !error && !loading
    fun updateRecipe(recipe: RecipeUi): RecipeDetailsState {
        return copy(recipe = recipe)
    }

    fun updateMeasureSystem(measureSystem: MeasureSystem): RecipeDetailsState {
        return copy(measureSystem = measureSystem)
    }

    fun updateError(error: Boolean): RecipeDetailsState {
        return copy(error = error)
    }

    fun updateLoading(loading: Boolean): RecipeDetailsState {
        return copy(loading = loading)
    }
}

