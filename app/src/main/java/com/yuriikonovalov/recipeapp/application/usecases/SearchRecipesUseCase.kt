package com.yuriikonovalov.recipeapp.application.usecases

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipesUseCase @Inject constructor(private val repository: RecipeRepository) {
    operator fun invoke(
        query: String, pageSize: Int = DEFAULT_PAGE_SIZE
    ): Flow<PagingData<SearchRecipe>> {
        return repository.searchRecipes(query, pageSize.coerceAtLeast(1))
    }

    private companion object {
        const val DEFAULT_PAGE_SIZE = 15
    }
}