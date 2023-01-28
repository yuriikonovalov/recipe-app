package com.yuriikonovalov.recipeapp.application

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow

/**
 * An interface that contains all of the methods related to the [Recipe] entity.
 */
interface RecipeRepository {
    /**
     * Loads a recipe from a local data source for the given [id].
     * @param id id to find a recipe for.
     * @return a [Recipe] with the corresponding [id] or null.
     */
    suspend fun getRecipe(id: Int): Recipe?

    /**
     * Creates a flow that emits [Recipe] for the given [id].
     * @param id id to observe a recipe by.
     * @return a [Flow] that emits [Recipe]
     */
    fun observeRecipe(id: Int): Flow<Recipe>

    /**
     * Saves [Recipe] to database.
     * @param recipe a recipe to be saved.
     */
    suspend fun saveRecipe(recipe: Recipe)

    /**
     * Updates value of the [Recipe.saved] property of the recipe with the given [id]
     * to the given [saved] value.
     *
     * @param id id of the recipe to be updated.
     * @param saved new value.
     */
    suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean)

    /**
     * Deletes a recipe for the given [id].
     *
     * @param id id of the recipe to be deleted.
     */
    suspend fun deleteRecipe(id: Int)

    /**
     * Loads a [Recipe] for the given [id] from a remote data source.
     *
     * @param id id of the recipe to be loaded.
     * @return a [Recipe] with the corresponding [id].
     */
    suspend fun getRemoteRecipe(id: Int): Recipe

    /**
     * Deletes recipes that are neither saved or cached.
     */
    suspend fun deleteNeedlessRecipes()

    /**
     * Creates a [Flow] that emits lists of random [Recipe].
     *
     * @return a [Flow] that emits lists of random [Recipe].
     */
    fun getRandomRecipes(): Flow<List<Recipe>>

    /**
     * Returns the latest date of caching as [Flow] that emits [String] values.
     *
     * @return a [Flow] that emits [String] values.
     */
    fun getLastCacheDate(): Flow<String>

    /**
     * Creates a [Flow] that emits lists of saved [Recipe].
     *
     * @return a [Flow] that emits lists of saved [Recipe].
     */
    fun getSavedRecipes(): Flow<List<Recipe>>

    /**
     * Creates a [Flow] that emits [PagingData] of [SearchRecipe]. The emitted values depend on
     * the given [query] and [pageSize].
     *
     * @param query a query that is used for searching.
     * @param pageSize a size of list by which search results will be emitting.
     *
     * @return a [Flow] that emits [PagingData] of type [SearchRecipe].
     */
    fun searchRecipes(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>>

    /**
     * Updates random recipes with a given [number] of new random recipes and sets [date] as the latest date of caching.
     */
    suspend fun refreshRandomRecipeCache(number: Int, date: String)
}