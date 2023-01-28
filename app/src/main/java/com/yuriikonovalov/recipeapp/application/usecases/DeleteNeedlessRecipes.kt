package com.yuriikonovalov.recipeapp.application.usecases

/**
 * Defines a use case of deleting needless recipes.
 */
interface DeleteNeedlessRecipes {
    suspend operator fun invoke()
}