package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeResponseApi
import javax.inject.Inject

class SearchRecipeResponseMapperApi @Inject constructor(
    private val searchRecipeMapper: MapperApi<SearchRecipeApi, SearchRecipe>
) : MapperApi<SearchRecipeResponseApi, SearchRecipeResponse> {
    override fun mapToDomain(api: SearchRecipeResponseApi): SearchRecipeResponse {
        return SearchRecipeResponse(
            number = api.number ?: 0,
            offset = api.offset ?: 0,
            recipes = api.searchRecipes(),
            totalRecipes = api.totalResults ?: 0
        )
    }

    private fun SearchRecipeResponseApi.searchRecipes(): List<SearchRecipe> {
        return recipes?.map {
            searchRecipeMapper.mapToDomain(it)
        } ?: emptyList()
    }
}