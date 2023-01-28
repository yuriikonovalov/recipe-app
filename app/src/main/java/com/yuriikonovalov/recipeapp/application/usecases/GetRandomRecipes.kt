package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Defines a use case of getting random recipes.
 */
interface GetRandomRecipes {
    /**
     * @return a [Flow] that emits [Resource.Success] if there's at least 1 recipe,
     * otherwise - [Resource.Failure].
     */
    operator fun invoke(): Flow<Resource<List<Recipe>>>
}