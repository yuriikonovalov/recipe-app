package com.yuriikonovalov.recipeapp.framework.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchRecipeResponseApi(
    @Json(name = "number")
    val number: Int? = null,
    @Json(name = "offset")
    val offset: Int? = null,
    @Json(name = "results")
    val recipes: List<SearchRecipeApi>? = null,
    @Json(name = "totalResults")
    val totalResults: Int? = null
)