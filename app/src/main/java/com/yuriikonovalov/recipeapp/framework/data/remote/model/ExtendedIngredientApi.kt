package com.yuriikonovalov.recipeapp.framework.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExtendedIngredientApi(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "measures")
    val measures: MeasureApi? = null,
)