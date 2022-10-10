package com.yuriikonovalov.recipeapp.application.entities


data class Ingredient(
    val id: Int,
    val name: String?,
    val image: String?,
    val measureUs: Measure?,
    val measureMetric: Measure?,
)