package com.yuriikonovalov.recipeapp.presentation.savedrecipes

sealed class SavedRecipeDetailsEvent {
    data class OpenSourcePage(val url: String) : SavedRecipeDetailsEvent()
}

sealed class SavedRecipesEvent {
    object OpenDetailsPane : SavedRecipesEvent()
    object CloseDetailsPane : SavedRecipesEvent()
    object NavigateUp : SavedRecipesEvent()
}
