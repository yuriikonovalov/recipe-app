package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipe
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError

class FakeUnsaveRecipe(
    private val isSuccess: Boolean = true
) : UnsaveRecipe {
    override suspend fun invoke(id: Int): Resource<Unit> {
        return if (isSuccess) {
            Resource.Success(Unit)
        } else {
            Resource.Failure(ResourceError.Unknown)
        }
    }
}