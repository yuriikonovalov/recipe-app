package com.yuriikonovalov.recipeapp.data.remote

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import retrofit2.HttpException
import java.io.IOException

interface RecipeRemoteDataSource {
    suspend fun getRandomRecipes(number: Int): List<Recipe>
    suspend fun getRecipeDetails(id: Int): Recipe

    @Throws(HttpException::class, IOException::class)
    suspend fun searchRecipes(query: String, offset: Int, number: Int): SearchRecipeResponse
}