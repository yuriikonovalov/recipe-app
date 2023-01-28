package com.yuriikonovalov.recipeapp.application.usecases

import androidx.paging.PagingData
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import kotlinx.coroutines.flow.Flow

/**
 * Defines a use case of searching recipes by query and page size.
 */
interface SearchRecipes {
    /**
     * Searches for recipes that are illegible for the given [query] and returns results in form of
     * [PagingData] with data type [SearchRecipe].
     *
     * @param query a query to search by.
     * @param pageSize a size of lists that will be emitted.
     * @return a [Flow] of [PagingData] with data type [SearchRecipe].
     */
    operator fun invoke(query: String, pageSize: Int): Flow<PagingData<SearchRecipe>>
}