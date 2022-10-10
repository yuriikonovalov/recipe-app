package com.yuriikonovalov.recipeapp.application.entities

data class SearchRecipeResponse(
    val number: Int,
    val offset: Int,
    val recipes: List<SearchRecipe>,
    val totalRecipes: Int
)
