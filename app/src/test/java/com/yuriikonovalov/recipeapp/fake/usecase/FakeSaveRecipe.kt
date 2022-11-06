package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.usecases.SaveRecipe
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError

class FakeSaveRecipe(
    private val isSuccess: Boolean = true
) : SaveRecipe {
    override suspend fun invoke(id: Int): Resource<Int> {
        return if (isSuccess) {
            Resource.Success(id)
        } else {
            Resource.Failure(ResourceError.Unknown)
        }
    }
}