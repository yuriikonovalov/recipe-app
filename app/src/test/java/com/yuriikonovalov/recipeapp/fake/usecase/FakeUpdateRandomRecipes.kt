package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.application.usecases.UpdateRandomRecipes
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.resource.ResourceError

class FakeUpdateRandomRecipes(
    private val isSuccess: Boolean = true
) : UpdateRandomRecipes {
    override suspend fun invoke(size: Int, forced: Boolean): Resource<Unit> {
        return if (isSuccess) {
            Resource.Success(Unit)
        } else {
            Resource.Failure(ResourceError.RemoteService)
        }
    }
}