package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Defines a use case of getting saved recipes.
 */
interface GetSavedRecipes {
    /**
     * Creates a [Flow] that emits [Resource.Success] if there's at least 1 saved recipe,
     * otherwise - [Resource.Failure].
     *
     * @return a [Flow] that emits [Resource].
     */
    operator fun invoke(): Flow<Resource<List<Recipe>>>
}