package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.resource.Resource
import javax.inject.Inject

class SaveRecipeUseCase @Inject constructor(private val repository: RecipeRepository) {
    suspend operator fun invoke(id: Int): Resource<Int> {
        return try {
            // True if the recipe is already in DB.
            val update = repository.getRecipe(id) != null
            if (update) {
                repository.updateRecipeSavedFlag(id = id, saved = true)
            } else {
                // Load the recipe from remote source and save it in local source.
                val recipe = repository.getRemoteRecipe(id)
                    .copy(saved = true)
                repository.saveRecipe(recipe)
            }
            Resource.success(id)
        } catch (e: Exception) {
            Resource.failure(e)
        }
    }
}