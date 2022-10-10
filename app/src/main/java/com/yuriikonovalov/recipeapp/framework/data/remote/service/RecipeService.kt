package com.yuriikonovalov.recipeapp.framework.data.remote.service

import com.yuriikonovalov.recipeapp.framework.data.remote.model.RecipeApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.RecipeResponseApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeResponseApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int
    ): RecipeResponseApi

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int
    ): RecipeApi

    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("offset") offset: Int,
        @Query("number") number: Int
    ): SearchRecipeResponseApi
}