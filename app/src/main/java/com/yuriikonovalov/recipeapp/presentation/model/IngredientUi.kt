package com.yuriikonovalov.recipeapp.presentation.model

/**
 * This class is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Ingredient].
 * @property image a URL of the image of an ingredient.
 * @property measureUs amount of an ingredient for [com.yuriikonovalov.recipeapp.application.entities.MeasureSystem.Us].
 * @property measureMetric amount of an ingredient for [com.yuriikonovalov.recipeapp.application.entities.MeasureSystem.Metric].
 */
data class IngredientUi(
    val id: Int,
    val name: String,
    val image: String,
    val measureUs: String,
    val measureMetric: String,
)
