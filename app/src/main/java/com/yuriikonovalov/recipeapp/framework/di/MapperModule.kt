package com.yuriikonovalov.recipeapp.framework.di

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipeResponse
import com.yuriikonovalov.recipeapp.framework.data.local.database.mapper.*
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.IngredientDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation.AggregateRecipeDb
import com.yuriikonovalov.recipeapp.framework.data.remote.mapper.*
import com.yuriikonovalov.recipeapp.framework.data.remote.model.ExtendedIngredientApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.RecipeApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeResponseApi
import com.yuriikonovalov.recipeapp.framework.ui.mapper.IngredientMapperUi
import com.yuriikonovalov.recipeapp.framework.ui.mapper.RandomRecipeMapperUi
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.framework.ui.mapper.RecipeMapperUi
import com.yuriikonovalov.recipeapp.presentation.model.IngredientUi
import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    // API Mappers
    @Binds
    abstract fun bindIngredientMapperApi(impl: IngredientMapperApi): MapperApi<ExtendedIngredientApi, Ingredient>

    @Binds
    abstract fun bindRecipeMapperApi(impl: RecipeMapperApi): MapperApi<RecipeApi, Recipe>

    @Binds
    abstract fun bindSearchRecipeMapperApi(impl: SearchRecipeMapperApi): MapperApi<SearchRecipeApi, SearchRecipe>

    @Binds
    abstract fun bindSearchRecipeResponseMapperApi(impl: SearchRecipeResponseMapperApi): MapperApi<SearchRecipeResponseApi, SearchRecipeResponse>

    // DB Mappers
    @Binds
    abstract fun bindIngredientDbMapper(impl: IngredientDbMapper): MapperDb<Ingredient, IngredientDb>

    @Binds
    abstract fun bindAggregateRecipeDbMapper(impl: AggregateRecipeDbMapper): MapperDb<Recipe, AggregateRecipeDb>

    // UI Mappers
    @Binds
    abstract fun bindRecipeMapperUi(impl: RecipeMapperUi): MapperUi<Recipe, RecipeUi>

    @Binds
    abstract fun bindIngredientMapperUi(impl: IngredientMapperUi): MapperUi<Ingredient, IngredientUi>

    @Binds
    abstract fun bindRandomRecipeMapperUi(impl: RandomRecipeMapperUi): MapperUi<Recipe, RandomRecipeUi>

}