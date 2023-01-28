package com.yuriikonovalov.recipeapp.data.local

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import kotlinx.coroutines.flow.Flow

/**
 * Defines the interface for a class that will provide access to a local data source.
 */
interface RecipeLocalDataSource {
    suspend fun insertRecipe(recipe: Recipe)
    suspend fun insertRecipes(recipes: List<Recipe>)
    suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean)
    suspend fun deleteCacheRecipes()
    suspend fun deleteRecipeById(id: Int)
    suspend fun getRecipeById(id: Int): Recipe?
    suspend fun deleteNeedlessRecipes()
    fun getCacheRecipes(): Flow<List<Recipe>>
    fun getSavedRecipes(): Flow<List<Recipe>>
    fun observeRecipeById(id: Int): Flow<Recipe>
}