package com.yuriikonovalov.recipeapp.util

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class FakeRecipeLocalDataSource(
    private val recipes: MutableList<Recipe> = mutableListOf()
) : RecipeLocalDataSource {
    private val recipeFlow = MutableStateFlow(recipes)
    private fun refreshRecipesFlow() {
        recipeFlow.value = recipes
    }

    override suspend fun insertRecipe(recipe: Recipe) {
        recipes.add(recipe)
        refreshRecipesFlow()
    }

    override suspend fun insertRecipes(recipes: List<Recipe>) {
        this.recipes.addAll(recipes)
        refreshRecipesFlow()
    }

    override suspend fun updateRecipeSavedFlag(id: Int, saved: Boolean) {
        val recipe = recipes.find { it.id == id }!!
        recipes.remove(recipe)
        recipes.add(recipe.copy(saved = saved))
        refreshRecipesFlow()
    }

    override suspend fun deleteCacheRecipes() {
        if (recipes.removeIf { it.cache && !it.saved }) {
            refreshRecipesFlow()
        }
    }

    override suspend fun deleteRecipeById(id: Int) {
        if (recipes.removeIf { it.id == id }) {
            refreshRecipesFlow()
        }
    }

    override suspend fun getRecipeById(id: Int): Recipe? {
        return recipes.find { it.id == id }
    }

    override suspend fun deleteNeedlessRecipes() {
        if (recipes.removeAll { !it.saved && !it.cache }) {
            refreshRecipesFlow()
        }
    }

    override fun getCacheRecipes(): Flow<List<Recipe>> {
        return recipeFlow.map {
            it.filter { recipe -> recipe.cache }
        }
    }

    override fun getSavedRecipes(): Flow<List<Recipe>> {
        return recipeFlow.map {
            it.filter { recipe -> recipe.saved }
        }
    }

    override fun observeRecipeById(id: Int): Flow<Recipe> {
        return recipeFlow.map {
            it.find { recipe -> recipe.id == id }
        }.filterNotNull()
    }
}