package com.yuriikonovalov.recipeapp.framework.di

import com.yuriikonovalov.recipeapp.application.usecases.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindDeleteNeedlessRecipes(impl: DeleteNeedlessRecipesImpl): DeleteNeedlessRecipes

    @Binds
    abstract fun bindGetRandomRecipes(impl: GetRandomRecipesImpl): GetRandomRecipes

    @Binds
    abstract fun bindGetRecipeDetails(impl: GetRecipeDetailsImpl): GetRecipeDetails

    @Binds
    abstract fun bindGetSavedRecipes(impl: GetSavedRecipesImpl): GetSavedRecipes

    @Binds
    abstract fun bindSaveRecipe(impl: SaveRecipeImpl): SaveRecipe

    @Binds
    abstract fun bindSearchRecipes(impl: SearchRecipesImpl): SearchRecipes

    @Binds
    abstract fun bindUnsaveRecipe(impl: UnsaveRecipeImpl): UnsaveRecipe

    @Binds
    abstract fun bindUpdateRandomRecipes(impl: UpdateRandomRecipesImpl): UpdateRandomRecipes
}