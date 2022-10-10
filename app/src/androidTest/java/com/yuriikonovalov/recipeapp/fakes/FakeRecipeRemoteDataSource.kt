package com.yuriikonovalov.recipeapp.fakes

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import kotlinx.coroutines.delay
import java.io.IOException
import javax.inject.Inject

class FakeRecipeRemoteDataSource @Inject constructor() : RecipeRemoteDataSource {
    var recipe: Recipe = recipe()
    var randomRecipes: List<Recipe> = randomRecipes(20)
    var searchRecipes: List<SearchRecipe> = emptyList()
    var delay: Long? = null
    private var shouldThrowException: Boolean = false
    fun shouldThrowException(should: Boolean) {
        shouldThrowException = should
    }

    override suspend fun getRandomRecipes(number: Int): List<Recipe> {
        delay?.let {
            delay(it)
        }
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
        // Simulate data loading.
        delay?.let {
            delay(it)
        }
        if (shouldThrowException) {
            throw IOException()
        }
        return SearchRecipeResponse(
            number = number,
            offset = offset,
            recipes = searchRecipes,
            totalRecipes = searchRecipes.size
        )
    }
}