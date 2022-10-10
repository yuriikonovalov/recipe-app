package com.yuriikonovalov.recipeapp.presentation.model

data class RandomRecipeUi(
    val id: Int,
    val title: String,
    val time: String,
    val ingredients: String,
    val image: String?,
)