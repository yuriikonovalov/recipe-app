package com.yuriikonovalov.recipeapp.framework.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeApi(
    @Json(name = "dishTypes")
    val dishTypes: List<String>? = null,
    @Json(name = "extendedIngredients")
    val extendedIngredient: List<ExtendedIngredientApi>? = null,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "instructions")
    val instructions: String? = null,
    @Json(name = "readyInMinutes")
    val readyInMinutes: Int? = null,
    @Json(name = "servings")
    val servings: Int? = null,
    @Json(name = "sourceUrl")
    val sourceUrl: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "vegetarian")
    val vegetarian: Boolean? = null,
)