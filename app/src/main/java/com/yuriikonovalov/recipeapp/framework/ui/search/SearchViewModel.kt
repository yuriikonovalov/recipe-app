package com.yuriikonovalov.recipeapp.framework.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.cachedIn
import com.yuriikonovalov.recipeapp.application.usecases.SearchRecipes
import com.yuriikonovalov.recipeapp.presentation.search.SearchEvent
import com.yuriikonovalov.recipeapp.presentation.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the search screen.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipes: SearchRecipes
) : ViewModel() {
    private val _stateFlow = MutableStateFlow(SearchState())
    private val _eventFlow = MutableStateFlow<SearchEvent?>(null)
    private val currentState get() = stateFlow.value
    val stateFlow = _stateFlow.asStateFlow()
    val eventFlow get() = _eventFlow.asStateFlow()

    /**
     * A function that sets [eventFlow]'s value to null.
     */
    val eventConsumer = { _eventFlow.value = null }

    private val pageSize = 15
    private val searches = MutableSharedFlow<String>()

    @OptIn(ExperimentalCoroutinesApi::class)
    val pagingData = searches
        .flatMapLatest { query -> searchRecipes(query, pageSize) }
        .cachedIn(viewModelScope)

    /**
     * Changes current state by updating a query.
     *
     * @param query a new query.
     */
    fun onInputQuery(query: String) {
        _stateFlow.update { it.updateQuery(query.trim()) }
    }

    /**
     * Triggers search logic if the query is not blank,
     * otherwise - triggers [eventFlow] to emit a [SearchEvent.IncorrectQueryToast] event.
     */
    fun onPerformSearch() {
        if (currentState.query.isBlank()) {
            _eventFlow.value = SearchEvent.IncorrectQueryToast
        } else {
            viewModelScope.launch { searches.emit(currentState.query) }
        }
    }

    fun onSearchRecipeClick(id: Int) {
        _eventFlow.value = SearchEvent.OpenRecipeDetails(id)
    }

    fun updateCombinedLoadState(combinedLoadState: CombinedLoadStates, itemCount: Int) {
        _stateFlow.update { it.updateCombinedLoadStates(combinedLoadState, itemCount) }
    }
}