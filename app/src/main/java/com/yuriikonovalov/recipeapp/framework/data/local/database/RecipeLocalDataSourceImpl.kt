package com.yuriikonovalov.recipeapp.framework.data.local.database

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.framework.data.local.database.dao.RecipeDao
import com.yuriikonovalov.recipeapp.framework.data.local.database.mapper.MapperDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation.AggregateRecipeDb
import com.yuriikonovalov.recipeapp.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeLocalDataSourceImpl @Inject constructor(
    private val dao: RecipeDao,
    private val mapper: MapperDb<Recipe, AggregateRecipeDb>,
    private val dispatcherProvide: DispatcherProvider,
) : RecipeLocalDataSource {
    override suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean) {
        withContext(dispatcherProvide.io) {
            dao.updateRecipeSavedFlag(id, saved)
        }
    }

    override suspend fun insertRecipe(recipe: Recipe) {
        withContext(dispatcherProvide.io) {
            val aggregateRecipeDb = mapper.mapFromDomain(recipe)
            dao.insertRecipe(aggregateRecipeDb.recipeDb)
            dao.insertIngredients(aggregateRecipeDb.ingredients)
        }
    }

    override suspend fun insertRecipes(recipes: List<Recipe>) {
        withContext(dispatcherProvide.io) {
            val aggregateRecipesDb = recipes.map(mapper::mapFromDomain)
            val recipesDb = aggregateRecipesDb.map { it.recipeDb }
            val ingredientsDb = aggregateRecipesDb.flatMap { it.ingredients }
            dao.insertRecipes(recipesDb)
            dao.insertIngredients(ingredientsDb)
        }
    }

    override suspend fun getRecipeById(id: Int): Recipe? {
        return withContext(dispatcherProvide.io) {
            dao.getRecipe(id)?.let(mapper::mapToDomain)
        }
    }

    override suspend fun deleteNeedlessRecipes() {
        withContext(dispatcherProvide.io) {
            dao.deleteNeedlessRecipes()
        }
    }

    override suspend fun deleteCacheRecipes() {
        withContext(dispatcherProvide.io) {
            dao.deleteAllCache()
        }
    }

    override suspend fun deleteRecipeById(id: Int) {
        withContext(dispatcherProvide.io) {
            dao.delete(id)
        }
    }

    override fun getCacheRecipes(): Flow<List<Recipe>> {
        return dao.getCacheRecipes()
            .map(mapper::mapToDomain)
            .flowOn(dispatcherProvide.io)
    }

    override fun getSavedRecipes(): Flow<List<Recipe>> {
        return dao.getSavedRecipes()
            .map(mapper::mapToDomain)
            .flowOn(dispatcherProvide.io)
    }

    override fun observeRecipeById(id: Int): Flow<Recipe> {
        return dao.observeRecipe(id)
            .filterNotNull()
            .map(mapper::mapToDomain)
            .flowOn(dispatcherProvide.io)
    }
}