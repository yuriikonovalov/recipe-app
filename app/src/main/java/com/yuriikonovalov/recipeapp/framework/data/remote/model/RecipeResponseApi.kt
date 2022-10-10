package com.yuriikonovalov.recipeapp.framework.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeResponseApi(
    @Json(name = "recipes")
    val recipes: List<RecipeApi>,
)