package com.yuriikonovalov.recipeapp.presentation.model

import android.text.Spanned

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
