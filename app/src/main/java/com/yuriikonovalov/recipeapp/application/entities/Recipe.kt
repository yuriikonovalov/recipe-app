package com.yuriikonovalov.recipeapp.application.entities


data class Recipe(
    val id: Int,
    val title: String?,
    val mealTypes: List<MealType>,
    val ingredients: List<Ingredient>,
    val instructions: String?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val image: String?,
    val sourceUrl: String?,
    val vegetarian: Boolean?,
    val cache: Boolean,
    val saved: Boolean
)