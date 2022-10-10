package com.yuriikonovalov.recipeapp.presentation.recipedetails

import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi

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

