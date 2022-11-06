package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import javax.inject.Inject

class DeleteNeedlessRecipesImpl @Inject constructor(
    private val repository: RecipeRepository
) : DeleteNeedlessRecipes {
    override suspend operator fun invoke() = repository.deleteNeedlessRecipes()
}