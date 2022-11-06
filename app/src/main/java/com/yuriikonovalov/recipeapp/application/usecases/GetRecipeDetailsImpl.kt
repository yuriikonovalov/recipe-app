package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRecipeDetailsImpl @Inject constructor(
    private val repository: RecipeRepository
) : GetRecipeDetails {
    override suspend operator fun invoke(id: Int): Flow<Resource<Recipe>> {
        return try {
            val remote = repository.getRecipe(id) == null
            if (remote) {
                repository.getRemoteRecipe(id).also {
                    repository.saveRecipe(it)
                }
            }
            repository.observeRecipe(id).map { Resource.success(it) }
        } catch (e: Exception) {
            flowOf(Resource.failure(e))
        }
    }
}

