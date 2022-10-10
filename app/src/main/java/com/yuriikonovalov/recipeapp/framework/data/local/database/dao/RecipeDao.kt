package com.yuriikonovalov.recipeapp.framework.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.IngredientDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.RecipeDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation.AggregateRecipeDb
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert
    suspend fun insertRecipe(recipe: RecipeDb)

    @Insert
    suspend fun insertRecipes(recipes: List<RecipeDb>)

    @Insert
    suspend fun insertIngredients(ingredients: List<IngredientDb>)

    @Query("UPDATE recipes SET saved = :saved WHERE id = :id")
    suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean)

    @Query("DELETE FROM recipes WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM recipes WHERE cache = 1 AND saved = 0")
    suspend fun deleteAllCache()


    @Query("DELETE FROM recipes WHERE cache = 0 AND saved = 0")
    suspend fun deleteNeedlessRecipes() // neither cache nor saved.

    @Transaction
    @Query("SELECT * FROM recipes WHERE cache = 1")
    fun getCacheRecipes(): Flow<List<AggregateRecipeDb>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE saved = 1")
    fun getSavedRecipes(): Flow<List<AggregateRecipeDb>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE id = :id")
    suspend fun getRecipe(id: Int): AggregateRecipeDb?

    @Transaction
    @Query("SELECT * FROM recipes WHERE id = :id")
    fun observeRecipe(id: Int): Flow<AggregateRecipeDb?>
}