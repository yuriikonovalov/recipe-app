package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSavedRecipesImpl @Inject constructor(
    private val repository: RecipeRepository
) : GetSavedRecipes {
    override operator fun invoke(): Flow<Resource<List<Recipe>>> {
        return repository.getSavedRecipes()
            .map { recipes ->
                if (recipes.isEmpty()) {
                    Resource.failure(ResourceError.NotFound)
                } else {
                    Resource.success(recipes)
                }
            }
    }
}