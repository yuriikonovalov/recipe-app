package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetSavedRecipes
import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipe
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipeDetailsEvent
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesEvent
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesState
import com.yuriikonovalov.recipeapp.resource.onFailure
import com.yuriikonovalov.recipeapp.resource.onSuccess
import com.yuriikonovalov.recipeapp.util.WindowSizeClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the saved recipes screen.
 */
@HiltViewModel
class SavedRecipesViewModel @Inject constructor(
    private val getSavedRecipes: GetSavedRecipes,
    private val unsaveRecipe: UnsaveRecipe,
    private val recipeMapper: MapperUi<Recipe, RecipeUi>
) : ViewModel() {
    private val initialState = SavedRecipesState()
    private val _stateFlow = MutableStateFlow(initialState)
    private val currentState get() = stateFlow.value
    val stateFlow get() = _stateFlow.asStateFlow()

    private val _eventFlow = MutableStateFlow<SavedRecipesEvent?>(null)
    val eventFlow get() = _eventFlow.asStateFlow()
    private val _detailsEventFlow = MutableStateFlow<SavedRecipeDetailsEvent?>(null)
    val detailsEventFlow get() = _detailsEventFlow.asStateFlow()

    init {
        viewModelScope.launch {
            getSavedRecipes().collect { resource ->
                resource.onSuccess { recipes ->
                    val recipesUi = recipes.map(recipeMapper::mapToUi)
                    _stateFlow.update { it.updateRecipes(recipesUi) }
                    currentState.recipes.firstOrNull()?.let { recipe ->
                        if (currentState.initialSelectionDone.not() && currentState.windowSizeClass == WindowSizeClass.EXPANDED) {
                            // first open in expanded mode - tab
                            _stateFlow.update { it.updateInitialSelectionDone(true) }
                            _stateFlow.update { it.updateSelectedRecipe(recipe) }
                        }
                    }
                }
                resource.onFailure {
                    _stateFlow.update { it.updateRecipes(emptyList()) }
                }
            }
        }
    }

    /**
     * A function that sets [_detailsEventFlow]'s value to null.
     */
    val detailsEventConsumer = { _detailsEventFlow.value = null }

    /**
     * A function that sets [_eventFlow]'s value to null.
     */
    val eventConsumer = { _eventFlow.value = null }

    private fun closePaneOrNavigateUp(): SavedRecipesEvent {
        val paneSliding = currentState.windowSizeClass != WindowSizeClass.EXPANDED
        return if (paneSliding && currentState.paneOpen) {
            SavedRecipesEvent.CloseDetailsPane
        } else {
            SavedRecipesEvent.NavigateUp
        }
    }

    /**
     * Triggers [eventFlow] to emit a [SavedRecipesEvent.CloseDetailsPane]
     * or [SavedRecipesEvent.OpenDetailsPane] based on the current state.
     */
    fun onClickBackButton() {
        _eventFlow.value = closePaneOrNavigateUp()
    }

    /**
     * Triggers [eventFlow] to emit a [SavedRecipesEvent.CloseDetailsPane]
     * or [SavedRecipesEvent.OpenDetailsPane] based on the current state.
     */
    fun onClickNavigateUpButton() {
        _eventFlow.value = closePaneOrNavigateUp()
    }

    /**
     * Updates the [SavedRecipesState.paneOpen] property with the given [open] value.
     */
    fun onUpdatePaneState(open: Boolean) {
        _stateFlow.update { it.updatePaneOpen(open) }
    }

    /**
     * Updates the [SavedRecipesState.windowSizeClass] property with the given [widthWindowSizeClass] value.
     */
    fun onUpdateWindowSizeClass(widthWindowSizeClass: WindowSizeClass) {
        _stateFlow.update { it.updateWindowSizeClass(widthWindowSizeClass) }
    }

    /**
     * Performs removing the recipe from the favorites.
     */
    fun onSaveButtonClick() {
        viewModelScope.launch {
            // No need for checking for null as this method can only be invoked when a recipe is selected.
            val id = currentState.selectedRecipe!!.id
            unsaveRecipe(id)
            postUnsaveAction()
        }
    }

    private fun postUnsaveAction() {
        val paneFixed = currentState.windowSizeClass == WindowSizeClass.EXPANDED
        val hasRecipesLeft = currentState.recipes.isNotEmpty()
        val newRecipe = currentState.recipes.firstOrNull()
        when {
            // Canonical layout - 'List View'
            paneFixed && hasRecipesLeft -> {
                onSelectRecipe(newRecipe!!)
            }
            paneFixed.not() -> {
                _eventFlow.value = SavedRecipesEvent.CloseDetailsPane
            }
        }
    }

    fun onSourceButtonClick() {
        // Invoked only if there's a source page url.
        _detailsEventFlow.value =
            SavedRecipeDetailsEvent.OpenSourcePage(currentState.selectedRecipe!!.sourceUrl!!)
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

    fun onSelectRecipe(recipe: RecipeUi) {
        _stateFlow.update { it.updateSelectedRecipe(recipe) }
        _eventFlow.value = SavedRecipesEvent.OpenDetailsPane
    }
}