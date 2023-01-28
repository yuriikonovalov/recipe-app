package com.yuriikonovalov.recipeapp.presentation.home

/**
 * This class represents events related to the home feature.
 */
sealed class HomeEvent {
    /**
     * Represents an event of opening recipe details for the given [id].
     *
     * @param id id of a recipe to be shown.
     */
    data class OpenRecipeDetails(val id: Int) : HomeEvent()
    object GoToSearchFragment : HomeEvent()
}