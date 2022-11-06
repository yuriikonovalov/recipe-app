package com.yuriikonovalov.recipeapp.fake.repository

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.util.recipe
import com.yuriikonovalov.recipeapp.util.recipes
import kotlinx.coroutines.flow.*
import kotlin.concurrent.fixedRateTimer

class FakeRecipeRepository(
    initialLocalRecipes: List<Recipe> = recipes(5),
    private val remoteRecipe: Recipe = recipe(),
    private val lastCacheDate: String = "22.11.2022",
    private val randomRecipes: List<Recipe> = recipes(5),
    private val getRemoteRecipeThrow: Boolean = false,
    private val refreshRandomRecipeCacheThrow: Boolean = false
) : RecipeRepository {
    private var localRecipes: MutableList<Recipe> = initialLocalRecipes.toMutableList()
    private val localRecipesFlow = MutableStateFlow<List<Recipe>>(localRecipes)
    private val dateFlow = MutableStateFlow<String>(lastCacheDate)

    override suspend fun getRecipe(id: Int): Recipe? {
        return localRecipes.find { it.id == id }
    }

    override fun observeRecipe(id: Int): Flow<Recipe> {
        return localRecipesFlow.map {
            it.find { it.id == id }!!
        }.onEach { println("observeRecipe: $it") }
    }

    override suspend fun saveRecipe(recipe: Recipe) {
        if (!localRecipes.contains(recipe)) {
            localRecipes.add(recipe)
            localRecipesFlow.emit(localRecipes)
        }
    }

    override suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean) {
        val index = localRecipes.indexOf(localRecipes.find { it.id == id })
        localRecipes[index] = localRecipes[index].copy(saved = saved)
        localRecipesFlow.emit(localRecipes)
    }

    override suspend fun deleteRecipe(id: Int) {
        localRecipes.removeIf { it.id == id }
        localRecipesFlow.emit(localRecipes)
    }

    override suspend fun getRemoteRecipe(id: Int): Recipe {
        if (getRemoteRecipeThrow) {
            throw RuntimeException("Error happened")
        }
        return remoteRecipe.copy(id = id)
    }

    override suspend fun deleteNeedlessRecipes() {
        localRecipes.removeIf { !it.saved && !it.cache }
        localRecipesFlow.emit(localRecipes)
    }

    override fun getRandomRecipes(): Flow<List<Recipe>> {
        return localRecipesFlow.map {
            it.filter { it.saved }
        }
    }

    override fun getLastCacheDate(): Flow<String> {
        return dateFlow
    }

    override fun getSavedRecipes(): Flow<List<Recipe>> {
        return localRecipesFlow.map {
            it.filter { it.saved }
        }
    }

    override fun searchRecipes(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>> {
        return flowOf(PagingData.empty())
    }

    override suspend fun refreshRandomRecipeCache(number: Int, date: String) {
        if (refreshRandomRecipeCacheThrow) {
            throw RuntimeException("Error happened.")
        }
        // Get new random recipes form service.
        if (randomRecipes.isNotEmpty()) {
            val newCache = randomRecipes.map {
                it.copy(cache = true)
            }
            // Clear old random recipes from DB and insert new ones.
            localRecipes.removeIf { it.cache && !it.saved }
            localRecipes.addAll(newCache)
            // Update last cache date.
            dateFlow.emit(date)
        }
    }
}


fun initRepository(
    localRecipes: List<Recipe> = recipes(5),
    remoteRecipe: Recipe = recipe(),
    lastCacheDate: String = "22.11.2022",
    randomRecipes: List<Recipe> = recipes(5),
    getRemoteRecipeThrow: Boolean = false,
    refreshRandomRecipeCacheThrow: Boolean = false,
) = FakeRecipeRepository(
    localRecipes,
    remoteRecipe,
    lastCacheDate,
    randomRecipes,
    getRemoteRecipeThrow,
    refreshRandomRecipeCacheThrow
)