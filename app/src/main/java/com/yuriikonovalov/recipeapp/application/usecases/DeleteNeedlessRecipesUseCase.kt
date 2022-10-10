package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import javax.inject.Inject

class DeleteNeedlessRecipesUseCase @Inject constructor(private val repository: RecipeRepository) {
    suspend operator fun invoke() = repository.deleteNeedlessRecipes()
}