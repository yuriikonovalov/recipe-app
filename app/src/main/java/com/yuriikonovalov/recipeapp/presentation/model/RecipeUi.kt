package com.yuriikonovalov.recipeapp.presentation.model

import android.text.Spanned

/**
 * This is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Recipe].
 *
 * @property id id of the recipe.
 * @property image a URL of the image of the recipe.
 * @property servings a number of servings of the recipe.
 * @property time amount of time in minutes needed for the recipe.
 * @property ingredients a list of the ingredients of the recipe.
 * @property instructions instructions required to cook a dish.
 * @property sourceUrl a URL of the recipe.
 * @property vegetarian a flag to denote if the recipe is vegetarian or not.
 * @property saved a flag to show if the recipe is saved to favorites or not.
 */
data class RecipeUi(
    val id: Int,
    val image: String?,
    val title: String,
    val servings: String?,
    val time: String?,
    val ingredients: List<IngredientUi>,
    val instructions: Spanned?,
    val mealTypes: String,
    val sourceUrl: String?,
    val vegetarian: Boolean,
    val saved: Boolean
)

val RecipeUi.mealTypeVisible get() = this.mealTypes.isNotBlank()
val RecipeUi.servingsVisible get() = this.servings.isNullOrBlank().not()
val RecipeUi.timeVisible get() = this.time.isNullOrBlank().not()
val RecipeUi.ingredientsVisible get() = this.ingredients.isNotEmpty()
val RecipeUi.measureSpinnerVisible get() = this.ingredients.isNotEmpty()
val RecipeUi.instructionsVisible get() = this.instructions.isNullOrBlank().not()
val RecipeUi.sourceButtonVisible get() = this.sourceUrl.isNullOrBlank().not()
