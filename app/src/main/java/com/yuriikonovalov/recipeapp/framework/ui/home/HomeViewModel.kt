package com.yuriikonovalov.recipeapp.framework.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetRandomRecipes
import com.yuriikonovalov.recipeapp.application.usecases.UpdateRandomRecipes
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.home.HomeEvent
import com.yuriikonovalov.recipeapp.presentation.home.HomeState
import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi
import com.yuriikonovalov.recipeapp.resource.ResourceError
import com.yuriikonovalov.recipeapp.resource.onFailure
import com.yuriikonovalov.recipeapp.resource.onSuccess
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the home screen.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomRecipes: GetRandomRecipes,
    private val updateRandomRecipes: UpdateRandomRecipes,
    private val mapper: MapperUi<Recipe, RandomRecipeUi>,
    private val idlingResource: EspressoIdlingResource
) : ViewModel() {
    private val _stateFlow = MutableStateFlow(HomeState())
    private val _eventFlow = MutableStateFlow<HomeEvent?>(null)
    private val numberOfRecipes = 5

    val stateFlow get() = _stateFlow.asStateFlow()
    val eventFlow = _eventFlow.asStateFlow()

    /**
     * A function that sets [eventFlow]'s value to null.
     */
    val eventConsumer = { _eventFlow.value = null }

    init {
        idlingResource.increment()
        // Update random recipes for today if not updated yet.
        _stateFlow.update { it.updateLoading(true) }
        viewModelScope.launch {
            updateRandomRecipes(numberOfRecipes, false).also {
                it.onSuccess {
                    _stateFlow.update { it.updateLoading(false) }
                }
                it.onFailure {
                    _stateFlow.update { it.updateLoading(false) }
                    // Errors - no connection
                }
            }
        }
        // Load random recipes from cache.
        viewModelScope.launch {
            getRandomRecipes().collect { resource ->
                resource.onSuccess { recipes ->
                    recipes.map(mapper::mapToUi).also { recipesUi ->
                        _stateFlow.update { it.updateRecipes(recipesUi) }
                    }
                }
                resource.onFailure { error ->
                    if (error is ResourceError.NotFound) {
                        _stateFlow.update { it.updateEmpty(true) }
                    }
                }
                idlingResource.decrement()
            }
        }
    }

    /**
     * Refreshes a list of random recipes.
     */
    fun refreshRecipes() {
        idlingResource.increment()
        _stateFlow.update { it.updateLoading(true) }
        viewModelScope.launch {
            updateRandomRecipes(numberOfRecipes, forced = true)
            _stateFlow.update { it.updateLoading(false) }
        }
    }

    /**
     * Triggers [eventFlow] to emit a [HomeEvent.OpenRecipeDetails] event.
     */
    fun onRecipeClick(id: Int) {
        _eventFlow.value = HomeEvent.OpenRecipeDetails(id)
    }

    /**
     * Triggers [eventFlow] to emit a [HomeEvent.GoToSearchFragment] event.
     */
    fun onSearchButtonClick() {
        _eventFlow.value = HomeEvent.GoToSearchFragment
    }
}