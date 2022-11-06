package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.Flow

interface GetSavedRecipes {
    operator fun invoke(): Flow<Resource<List<Recipe>>>
}