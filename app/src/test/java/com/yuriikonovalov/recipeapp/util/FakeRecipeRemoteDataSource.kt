package com.yuriikonovalov.recipeapp.util

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource

class FakeRecipeRemoteDataSource : RecipeRemoteDataSource {
    var recipe: Recipe = recipe()
    var randomRecipes: List<Recipe> = randomRecipes(20)
    var searchRecipes: List<SearchRecipe> = emptyList()
    private var shouldThrowException: Boolean = false
    fun shouldThrowException(should: Boolean) {
        shouldThrowException = should
    }

    override suspend fun getRandomRecipes(number: Int): List<Recipe> {
        if (shouldThrowException) {
            throw Exception()
        }
        return randomRecipes.takeLast(number)
    }

    override suspend fun getRecipeDetails(id: Int): Recipe {
        if (shouldThrowException) {
            throw Exception()
        }
        return recipe
    }

    override suspend fun searchRecipes(
        query: String,
        offset: Int,
        number: Int
    ): SearchRecipeResponse {
        return SearchRecipeResponse(
            number = number,
            offset = offset,
            recipes = searchRecipes,
            totalRecipes = searchRecipes.size
        )
    }
}