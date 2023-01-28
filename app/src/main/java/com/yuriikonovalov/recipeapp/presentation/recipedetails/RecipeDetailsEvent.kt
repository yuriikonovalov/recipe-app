package com.yuriikonovalov.recipeapp.presentation.recipedetails

/**
 * This class represents events related to the recipe details feature.
 */
sealed class RecipeDetailsEvent {
    /**
     * Represents an event of opening a webview for the given [sourceUrl].
     *
     * @constructor Creates an instance of [OpenSourcePage] with the given [sourceUrl]
     * @property sourceUrl a url that should be loaded.
     */
    data class OpenSourcePage(val sourceUrl: String) : RecipeDetailsEvent()
}