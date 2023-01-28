package com.yuriikonovalov.recipeapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.data.remote.SearchRecipePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of [RecipeRepository].
 * @property localDataSource a local data source.
 * @property remoteDataSource a remote date source.
 * @property preferenceDataStore a preference data store that provides access to app preferences.
 */
class RecipeRepositoryImpl @Inject constructor(
    private val localDataSource: RecipeLocalDataSource,
    private val remoteDataSource: RecipeRemoteDataSource,
    private val preferenceDataStore: PreferenceDataStore
) : RecipeRepository {

    override fun getRandomRecipes(): Flow<List<Recipe>> {
        return localDataSource.getCacheRecipes()
    }

    override suspend fun refreshRandomRecipeCache(number: Int, date: String) {
        // Get new random recipes form service.
        val newRandomRecipes = remoteDataSource.getRandomRecipes(number)
        if (newRandomRecipes.isNotEmpty()) {
            val newCache = newRandomRecipes.map {
                it.copy(cache = true)
            }
            // Clear old random recipes from DB and insert new ones.
            localDataSource.deleteCacheRecipes()
            localDataSource.insertRecipes(newCache)
            // Update last cache date.
            preferenceDataStore.updateLastCacheDate(date)
        }
    }

    override fun getLastCacheDate(): Flow<String> {
        return preferenceDataStore.getLastCacheDate()
    }

    override suspend fun getRecipe(id: Int): Recipe? {
        return localDataSource.getRecipeById(id)
    }

    override fun observeRecipe(id: Int): Flow<Recipe> {
        return localDataSource.observeRecipeById(id)
    }

    override suspend fun saveRecipe(recipe: Recipe) {
        localDataSource.insertRecipe(recipe)
    }

    override suspend fun deleteRecipe(id: Int) {
        localDataSource.deleteRecipeById(id)
    }

    override suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean) {
        localDataSource.updateRecipeSavedFlag(id, saved)
    }

    override fun getSavedRecipes(): Flow<List<Recipe>> {
        return localDataSource.getSavedRecipes()
    }

    override fun searchRecipes(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>> {
        return Pager(
            PagingConfig(pageSize)
        ) {
            SearchRecipePagingSource(remoteDataSource, query)
        }.flow
    }

    override suspend fun getRemoteRecipe(id: Int): Recipe {
        return remoteDataSource.getRecipeDetails(id)
    }

    override suspend fun deleteNeedlessRecipes() {
        localDataSource.deleteNeedlessRecipes()
    }
}