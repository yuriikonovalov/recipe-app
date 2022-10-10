package com.yuriikonovalov.recipeapp.application

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipe(id: Int): Recipe?
    fun observeRecipe(id: Int): Flow<Recipe>
    suspend fun saveRecipe(recipe: Recipe)
    suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean)
    suspend fun deleteRecipe(id: Int)
    suspend fun getRemoteRecipe(id: Int): Recipe
    suspend fun deleteNeedlessRecipes()
    fun getRandomRecipes(): Flow<List<Recipe>>
    fun getLastCacheDate(): Flow<String>
    fun getSavedRecipes(): Flow<List<Recipe>>
    fun searchRecipes(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>>
    suspend fun refreshRandomRecipeCache(number: Int, date: String)
}