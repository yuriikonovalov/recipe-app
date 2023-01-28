package com.yuriikonovalov.recipeapp.data.remote

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import retrofit2.HttpException
import java.io.IOException

/**
 * Defines the interface for a class that will provide access to a remote data source.
 */
interface RecipeRemoteDataSource {
    /**
     * Loads a [number] of new random recipes from a remote data source.
     *
     * @param number a number of recipes to be loaded.
     * @return a [List] of [Recipe].
     */
    suspend fun getRandomRecipes(number: Int): List<Recipe>

    /**
     * Loads recipe details by the given id.
     *
     * @param id id of the recipe to be loaded.
     * @return [Recipe].
     */
    suspend fun getRecipeDetails(id: Int): Recipe

    /**
     * Searches for recipes by the given [query], [offset] and [number].
     *
     * @param query a query to search by.
     * @param offset an offset of applied to a result list.
     * @param number a number of recipes to be loaded.
     * @return [SearchRecipeResponse]
     * @throws HttpException
     * @throws IOException
     */
    @Throws(HttpException::class, IOException::class)
    suspend fun searchRecipes(query: String, offset: Int, number: Int): SearchRecipeResponse
}