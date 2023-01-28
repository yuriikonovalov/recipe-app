package com.yuriikonovalov.recipeapp.presentation.home

import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi

/**
 * This class holds state of the home screen.
 *
 * @property recipes a list of [RandomRecipeUi].
 * @property loading a flag that shows if data is loading or not.
 * @property empty a flag that shows if there's no data to show.
 */
data class HomeState(
    val recipes: List<RandomRecipeUi> = emptyList(),
    val loading: Boolean = false,
    val empty: Boolean = false
) {
    val emptyPlaceholderVisible get() = empty && !loading
    val loadingPlaceholderVisible get() = loading && empty

    fun updateRecipes(recipes: List<RandomRecipeUi>): HomeState {
        return copy(recipes = recipes, loading = false, empty = false)
    }

    fun updateLoading(loading: Boolean): HomeState {
        return copy(loading = loading)
    }

    fun updateEmpty(empty: Boolean): HomeState {
        return copy(empty = empty)
    }
}
