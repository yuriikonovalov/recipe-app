package com.yuriikonovalov.recipeapp.application.usecases

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow

interface SearchRecipes {
    operator fun invoke(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>>
}