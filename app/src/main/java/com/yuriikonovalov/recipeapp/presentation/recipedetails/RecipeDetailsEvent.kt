package com.yuriikonovalov.recipeapp.presentation.recipedetails

sealed class RecipeDetailsEvent {
    data class OpenSourcePage(val sourceUrl: String) : RecipeDetailsEvent()
}