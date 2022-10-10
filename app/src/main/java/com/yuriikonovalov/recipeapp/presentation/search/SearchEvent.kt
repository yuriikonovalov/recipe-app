package com.yuriikonovalov.recipeapp.presentation.search

sealed class SearchEvent {
    data class OpenRecipeDetails(val id: Int) : SearchEvent()
    object IncorrectQueryToast : SearchEvent()
}
