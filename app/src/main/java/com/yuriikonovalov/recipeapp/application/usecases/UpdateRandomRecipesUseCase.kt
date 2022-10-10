package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.data.local.DateProvider
import com.yuriikonovalov.recipeapp.resource.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateRandomRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository,
    private val dateProvider: DateProvider
) {
    suspend operator fun invoke(size: Int = MIN_SIZE, forced: Boolean = false): Resource<Unit> {
        return try {
            val today = dateProvider.today()
            val lastCacheDate = repository.getLastCacheDate().first()
            if (lastCacheDate != today || forced) {
                repository.refreshRandomRecipeCache(size.coerceAtLeast(MIN_SIZE), today)
            }
            Resource.success(Unit)
        } catch (e: Exception) {
            Resource.failure(e)
        }
    }

    private companion object {
        const val MIN_SIZE = 5
    }
}