package com.yuriikonovalov.recipeapp.framework.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.cachedIn
import com.yuriikonovalov.recipeapp.application.usecases.SearchRecipesUseCase
import com.yuriikonovalov.recipeapp.presentation.search.SearchEvent
import com.yuriikonovalov.recipeapp.presentation.search.SearchState
import com.yuriikonovalov.recipeapp.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipes: SearchRecipesUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _stateFlow = MutableStateFlow(SearchState())
    val stateFlow = _stateFlow.asStateFlow()
    private val currentState get() = stateFlow.value
    private val _eventFlow = MutableStateFlow<SearchEvent?>(null)
    val eventFlow get() = _eventFlow.asStateFlow()
    val eventConsumer = { _eventFlow.value = null }


    private val searches = MutableSharedFlow<String>()

    @OptIn(ExperimentalCoroutinesApi::class)
    val pagingData = searches
        .flatMapLatest { query -> searchRecipes(query) }
        .cachedIn(viewModelScope)

    fun onInputQuery(query: String) {
        _stateFlow.update { it.updateQuery(query.trim()) }
    }

    fun onPerformSearch() {
        if (currentState.query.isBlank()) {
            _eventFlow.value = SearchEvent.IncorrectQueryToast
        } else {
            viewModelScope.launch(dispatcherProvider.main) { searches.emit(currentState.query) }
        }
    }

    fun onSearchRecipeClick(id: Int) {
        _eventFlow.value = SearchEvent.OpenRecipeDetails(id)
    }

    fun updateCombinedLoadState(combinedLoadState: CombinedLoadStates, itemCount: Int) {
        _stateFlow.update { it.updateCombinedLoadStates(combinedLoadState, itemCount) }
    }
}