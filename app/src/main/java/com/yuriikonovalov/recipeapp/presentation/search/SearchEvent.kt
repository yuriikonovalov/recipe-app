package com.yuriikonovalov.recipeapp.presentation.search

/**
 * This sealed class represents events related to the search feature.
 */
sealed class SearchEvent {
    /**
     * Represents an event of opening a recipe details screen.
     *
     * @constructor Creates an instance of [OpenRecipeDetails] using the given [id].
     * @property id an id of the recipe details of which should be displayed.
     */
    data class OpenRecipeDetails(val id: Int) : SearchEvent()

    /**
     * Represents an event of showing a toast when a query is not correct.
     */
    object IncorrectQueryToast : SearchEvent()
}
