package com.yuriikonovalov.recipeapp.framework.data.remote

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.framework.data.remote.mapper.MapperApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.RecipeApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeResponseApi
import com.yuriikonovalov.recipeapp.framework.data.remote.service.RecipeService
import com.yuriikonovalov.recipeapp.resource.mapRemoteToDomainException
import com.yuriikonovalov.recipeapp.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RecipeRemoteDataSourceImpl @Inject constructor(
    private val service: RecipeService,
    private val recipeMapper: MapperApi<RecipeApi, Recipe>,
    private val searchRecipeResponseMapper: MapperApi<SearchRecipeResponseApi, SearchRecipeResponse>,
    private val dispatcherProvider: DispatcherProvider
) : RecipeRemoteDataSource {
    override suspend fun getRandomRecipes(number: Int): List<Recipe> {
        return withContext(dispatcherProvider.io) {
            try {
                service.getRandomRecipes(number)
                    .recipes
                    .map(recipeMapper::mapToDomain)
            } catch (e: Exception) {
                throw mapRemoteToDomainException(e)
            }
        }
    }

    override suspend fun getRecipeDetails(id: Int): Recipe {
        return withContext(dispatcherProvider.io) {
            try {
                service.getRecipeInformation(id).let {
                    recipeMapper.mapToDomain(it)
                }
            } catch (e: Exception) {
                throw mapRemoteToDomainException(e)
            }
        }
    }

    override suspend fun searchRecipes(
        query: String,
        offset: Int,
        number: Int
    ): SearchRecipeResponse {
        return withContext(dispatcherProvider.io) {
            service.searchRecipes(query, offset, number).let {
                searchRecipeResponseMapper.mapToDomain(it)
            }
        }
    }
}