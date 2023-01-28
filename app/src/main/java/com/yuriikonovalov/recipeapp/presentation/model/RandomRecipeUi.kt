package com.yuriikonovalov.recipeapp.presentation.model

/**
 * This class is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Recipe]
 * optimized for displaying as a list item.
 * @property time amount of time in minutes needed for this recipe.
 * @property ingredients a number of ingredients in the recipe.
 * @property image a URL of the image of this recipe.
 */
data class RandomRecipeUi(
    val id: Int,
    val title: String,
    val time: String,
    val ingredients: String,
    val image: String?,
)