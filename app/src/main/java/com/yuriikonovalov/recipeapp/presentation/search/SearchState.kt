package com.yuriikonovalov.recipeapp.presentation.search

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.LoadStates
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe

private fun defaultCombinedLoadStates() = CombinedLoadStates(
    refresh = LoadState.NotLoading(false),
    prepend = LoadState.NotLoading(false),
    append = LoadState.NotLoading(false),
    source = LoadStates(
        refresh = LoadState.NotLoading(false),
        prepend = LoadState.NotLoading(false),
        append = LoadState.NotLoading(false)
    ),
    mediator = null
)

/**
 * This class holds state of the search screen.
 *
 * @constructor Creates an instance of [SearchState].
 */
data class SearchState(
    val query: String = "",
    val combinedLoadStates: CombinedLoadStates = defaultCombinedLoadStates(),
    val resultItemCount: Int = 0
) {
    private val isSearchResultEmpty: Boolean
        get() = combinedLoadStates.refresh is LoadState.NotLoading && resultItemCount == 0
    val searchRecipeListVisible: Boolean
        get() = isSearchResultEmpty.not() && combinedLoadStates.source.refresh is LoadState.NotLoading
    val emptyViewVisible: Boolean
        get() = isSearchResultEmpty
    val errorViewVisible: Boolean
        get() = combinedLoadStates.source.refresh is LoadState.Error
    val loadingViewVisible: Boolean
        get() = combinedLoadStates.source.refresh is LoadState.Loading

    fun updateQuery(query: String): SearchState {
        return copy(query = query)
    }

    fun updateCombinedLoadStates(combinedLoadStates: CombinedLoadStates, count: Int): SearchState {
        return copy(combinedLoadStates = combinedLoadStates, resultItemCount = count)
    }
}