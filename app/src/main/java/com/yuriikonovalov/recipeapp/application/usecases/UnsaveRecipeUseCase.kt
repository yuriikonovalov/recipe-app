package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.resource.Resource
import javax.inject.Inject

class UnsaveRecipeUseCase @Inject constructor(private val repository: RecipeRepository) {
    suspend operator fun invoke(id: Int): Resource<Unit> {
        return try {
            val recipe = repository.getRecipe(id)!!
            if (recipe.cache) {
                // just set 'saved' to 'false' if the recipe used as cache.
                repository.updateRecipeSavedFlag(id = recipe.id, saved = false)
            } else {
                repository.deleteRecipe(id)
            }
            Resource.success(Unit)
        } catch (e: Exception) {
            Resource.failure(e)
        }
    }
}