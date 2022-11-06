package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetRandomRecipes
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError
import com.yuriikonovalov.recipeapp.util.recipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetRandomRecipes(
    private val recipes: List<Recipe> = recipes(5),
    private val isSuccess: Boolean = true
) : GetRandomRecipes {
    override fun invoke(): Flow<Resource<List<Recipe>>> {
        return if (isSuccess) {
            flowOf(Resource.Success(recipes))
        } else {
            flowOf(Resource.Failure(ResourceError.NotFound))
        }
    }

}