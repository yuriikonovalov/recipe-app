package com.yuriikonovalov.recipeapp.framework.data.local.database

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.framework.data.local.database.dao.RecipeDao
import com.yuriikonovalov.recipeapp.framework.data.local.database.mapper.MapperDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation.AggregateRecipeDb
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of [RecipeLocalDataSource].
 *
 * @property dao a recipe data access object.
 * @property mapper a db mapper between [Recipe] and [AggregateRecipeDb].
 */
class RecipeLocalDataSourceImpl @Inject constructor(
    private val dao: RecipeDao,
    private val mapper: MapperDb<Recipe, AggregateRecipeDb>
) : RecipeLocalDataSource {
    override suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean) {
        dao.updateRecipeSavedFlag(id, saved)
    }

    override suspend fun insertRecipe(recipe: Recipe) {
        val aggregateRecipeDb = mapper.mapFromDomain(recipe)
        dao.insertRecipe(aggregateRecipeDb.recipeDb)
        dao.insertIngredients(aggregateRecipeDb.ingredients)
    }

    override suspend fun insertRecipes(recipes: List<Recipe>) {
        val aggregateRecipesDb = recipes.map(mapper::mapFromDomain)
        val recipesDb = aggregateRecipesDb.map { it.recipeDb }
        val ingredientsDb = aggregateRecipesDb.flatMap { it.ingredients }
        dao.insertRecipes(recipesDb)
        dao.insertIngredients(ingredientsDb)
    }

    override suspend fun getRecipeById(id: Int): Recipe? {
        return dao.getRecipe(id)?.let(mapper::mapToDomain)
    }

    override suspend fun deleteNeedlessRecipes() {
        dao.deleteNeedlessRecipes()
    }

    override suspend fun deleteCacheRecipes() {
        dao.deleteAllCache()
    }

    override suspend fun deleteRecipeById(id: Int) {
        dao.delete(id)
    }

    override fun getCacheRecipes(): Flow<List<Recipe>> {
        return dao.getCacheRecipes()
            .map(mapper::mapToDomain)
    }

    override fun getSavedRecipes(): Flow<List<Recipe>> {
        return dao.getSavedRecipes()
            .map(mapper::mapToDomain)
    }

    override fun observeRecipeById(id: Int): Flow<Recipe> {
        return dao.observeRecipe(id)
            .filterNotNull()
            .map(mapper::mapToDomain)
    }
}