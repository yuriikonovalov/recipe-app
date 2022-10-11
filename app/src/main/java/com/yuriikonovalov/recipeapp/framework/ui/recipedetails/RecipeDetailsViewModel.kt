package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetRecipeDetailsUseCase
import com.yuriikonovalov.recipeapp.application.usecases.SaveRecipeUseCase
import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipeUseCase
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import com.yuriikonovalov.recipeapp.presentation.recipedetails.RecipeDetailsEvent
import com.yuriikonovalov.recipeapp.presentation.recipedetails.RecipeDetailsState
import com.yuriikonovalov.recipeapp.resource.onFailure
import com.yuriikonovalov.recipeapp.resource.onSuccess
import com.yuriikonovalov.recipeapp.util.DispatcherProvider
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeDetailsViewModel @AssistedInject constructor(
    @Assisted private val recipeId: Int,
    private val saveRecipe: SaveRecipeUseCase,
    private val unsaveRecipe: UnsaveRecipeUseCase,
    private val getRecipeDetails: GetRecipeDetailsUseCase,
    private val dispatcherProvider: DispatcherProvider,
    private val recipeMapper: MapperUi<Recipe, RecipeUi>,
    private val espressoIdlingResource: EspressoIdlingResource
) : ViewModel() {
    private val _stateFlow = MutableStateFlow(RecipeDetailsState())
    private val currentState get() = stateFlow.value
    private val _eventFlow = MutableStateFlow<RecipeDetailsEvent?>(null)
    val stateFlow get() = _stateFlow.asStateFlow()
    val eventFlow get() = _eventFlow.asStateFlow()
    val eventConsumer = { _eventFlow.value = null }

    init {
        loadRecipeDetails(recipeId)
    }

    fun onSaveButtonClick() {
        espressoIdlingResource.increment()
        viewModelScope.launch(dispatcherProvider.main) {
            // No need for checking for null as this method can only be invoked when a recipe is selected.
            val id = currentState.recipe!!.id
            if (currentState.recipe!!.saved) {
                unsaveRecipe(id)
            } else {
                saveRecipe(id)
            }
        }
    }

    fun onSourceButtonClick() {
        // Invoked only if there's a source page url.
        _eventFlow.value = RecipeDetailsEvent.OpenSourcePage(currentState.recipe!!.sourceUrl!!)
    }

    fun onSelectMeasureSystem(position: Int) {
        val measureSystem = when (position) {
            0 -> MeasureSystem.Metric
            1 -> MeasureSystem.Us
            else -> {
                throw IllegalArgumentException("Was expected only 2 items.")
            }
        }
        _stateFlow.update { it.updateMeasureSystem(measureSystem) }
    }

    fun loadRecipeDetails(id: Int) {
        espressoIdlingResource.increment()
        _stateFlow.update { it.updateLoading(true) }
        viewModelScope.launch(dispatcherProvider.main) {
            getRecipeDetails(id).collect { resource ->
                _stateFlow.update { it.updateLoading(false) }
                resource.onSuccess { recipe ->
                    val recipeUi = recipeMapper.mapToUi(recipe)
                    _stateFlow.update { it.updateError(false).updateRecipe(recipeUi) }
                }
                resource.onFailure {
                    _stateFlow.update { it.updateError(true) }
                }
                espressoIdlingResource.decrement()
            }
        }
    }

    fun onRetryButtonClick(id: Int) {
        _stateFlow.update { it.updateError(false) }
        loadRecipeDetails(id)
    }


    @AssistedFactory
    interface Factory {
        fun create(recipeId: Int): RecipeDetailsViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            recipeId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(recipeId) as T
            }
        }
    }
}