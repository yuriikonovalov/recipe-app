package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetSavedRecipes
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError
import com.yuriikonovalov.recipeapp.util.recipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetSavedRecipes(
    private val recipes: List<Recipe> = recipes(5)
) : GetSavedRecipes {
    override fun invoke(): Flow<Resource<List<Recipe>>> {
        return if (recipes.isEmpty()) {
            flowOf(Resource.Failure(ResourceError.NotFound))
        } else {
            flowOf(Resource.Success(recipes))
        }
    }
}