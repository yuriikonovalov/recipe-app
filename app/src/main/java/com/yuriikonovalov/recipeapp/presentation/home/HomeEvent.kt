package com.yuriikonovalov.recipeapp.presentation.home

sealed class HomeEvent {
    data class OpenRecipeDetails(val id: Int) : HomeEvent()
    object GoToSearchFragment : HomeEvent()
}