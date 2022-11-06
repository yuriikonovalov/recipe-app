package com.yuriikonovalov.recipeapp.application.usecases

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipesImpl @Inject constructor(
    private val repository: RecipeRepository
) : SearchRecipes {
    override operator fun invoke(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>> {
        return repository.searchRecipes(query, pageSize.coerceAtLeast(1))
    }
}