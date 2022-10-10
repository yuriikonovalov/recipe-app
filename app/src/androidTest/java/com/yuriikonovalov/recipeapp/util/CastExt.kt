package com.yuriikonovalov.recipeapp.util

import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.fakes.FakePreferenceDataStore
import com.yuriikonovalov.recipeapp.fakes.FakeRecipeLocalDataSource
import com.yuriikonovalov.recipeapp.fakes.FakeRecipeRemoteDataSource

fun RecipeRemoteDataSource.asFake() = this as FakeRecipeRemoteDataSource
fun RecipeLocalDataSource.asFake() = this as FakeRecipeLocalDataSource
fun PreferenceDataStore.asFake() = this as FakePreferenceDataStore
