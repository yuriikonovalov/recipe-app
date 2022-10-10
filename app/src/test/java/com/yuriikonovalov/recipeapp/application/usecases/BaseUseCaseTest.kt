package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.application.RecipeRepository
import com.yuriikonovalov.recipeapp.data.RecipeRepositoryImpl
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.util.FakePreferenceDataStore
import com.yuriikonovalov.recipeapp.util.FakeRecipeLocalDataSource
import com.yuriikonovalov.recipeapp.util.FakeRecipeRemoteDataSource


open class BaseUseCaseTest {
    protected lateinit var localDataSource: RecipeLocalDataSource
    protected lateinit var remoteDataSource: RecipeRemoteDataSource
    protected lateinit var preferenceDataSource: PreferenceDataStore
    protected lateinit var repository: RecipeRepository

    fun setupBase() {
        localDataSource = FakeRecipeLocalDataSource()
        remoteDataSource = FakeRecipeRemoteDataSource()
        preferenceDataSource = FakePreferenceDataStore()
        repository = RecipeRepositoryImpl(localDataSource, remoteDataSource, preferenceDataSource)
    }

    val localDataSourceAsFake get() = (localDataSource as FakeRecipeLocalDataSource)
    val remoteDataSourceAsFake get() = (remoteDataSource as FakeRecipeRemoteDataSource)
    val preferenceDataSourceAsFake get() = (preferenceDataSource as FakePreferenceDataStore)
}