package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.usecases.GetRecipeDetails
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetRecipeDetails(
    private val recipe: Recipe = recipe(),
    private val isSuccess: Boolean = true
) : GetRecipeDetails {
    override suspend fun invoke(id: Int): Flow<Resource<Recipe>> {
        return if (isSuccess) {
            flowOf(Resource.Success(recipe.copy(id = id)))
        } else {
            flowOf(Resource.Failure(ResourceError.NotFound))
        }
    }
}