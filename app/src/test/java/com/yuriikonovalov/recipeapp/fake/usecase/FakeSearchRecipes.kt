package com.yuriikonovalov.recipeapp.fake.usecase

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.usecases.SearchRecipes
import com.yuriikonovalov.recipeapp.util.searchRecipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSearchRecipes(
    private val searchRecipes: List<SearchRecipe> = searchRecipes(5)
) : SearchRecipes {
    override fun invoke(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>> {
        return flowOf(PagingData.from(searchRecipes))
    }
}