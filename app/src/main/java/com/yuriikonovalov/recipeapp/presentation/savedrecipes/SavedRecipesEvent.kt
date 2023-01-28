package com.yuriikonovalov.recipeapp.presentation.savedrecipes


/**
 * This class represents events related to the saved recipe details feature.
 */
sealed class SavedRecipeDetailsEvent {
    /**
     * Represents an event of opening a webview for the given [url].
     *
     * @constructor Creates an instance of [OpenSourcePage] with the given [url]
     * @property url a url that should be loaded.
     */
    data class OpenSourcePage(val url: String) : SavedRecipeDetailsEvent()
}

/**
 * This class represents events related to the saved recipes feature.
 */
sealed class SavedRecipesEvent {
    object OpenDetailsPane : SavedRecipesEvent()
    object CloseDetailsPane : SavedRecipesEvent()
    object NavigateUp : SavedRecipesEvent()
}
