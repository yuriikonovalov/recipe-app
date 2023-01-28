package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Defines a use case of getting recipe details by id.
 */
interface GetRecipeDetails {
    /**
     * Creates a [Flow] that emits [Resource.Success] with data of type [Recipe] if the recipe was found
     * for the given [id], otherwise - [Resource.Failure].
     *
     * @param id id of the recipe to be emitted.
     */
    suspend operator fun invoke(id: Int): Flow<Resource<Recipe>>
}