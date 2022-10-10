package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeApi
import javax.inject.Inject

class SearchRecipeMapperApi @Inject constructor() :
    MapperApi<SearchRecipeApi, SearchRecipe> {
    override fun mapToDomain(api: SearchRecipeApi): SearchRecipe {
        return SearchRecipe(
            id = api.id!!,
            title = api.title!!,
            image = api.composeImageUrl()
        )
    }

    private fun SearchRecipeApi.composeImageUrl(): String {
        return "https://spoonacular.com/recipeImages/$id-90x90.$imageType"
    }
}