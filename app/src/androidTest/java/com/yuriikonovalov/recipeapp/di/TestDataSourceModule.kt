package com.yuriikonovalov.recipeapp.di

import com.yuriikonovalov.recipeapp.data.local.DateProvider
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.fakes.FakePreferenceDataStore
import com.yuriikonovalov.recipeapp.framework.data.local.DateProviderImpl
import com.yuriikonovalov.recipeapp.framework.data.local.database.RecipeLocalDataSourceImpl
import com.yuriikonovalov.recipeapp.framework.data.remote.RecipeRemoteDataSourceImpl
import com.yuriikonovalov.recipeapp.framework.di.DataSourceModule
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataSourceModule::class]
)
abstract class TestDataSourceModule {
    @Binds
    @Singleton
    abstract fun binDateProvider(impl: DateProviderImpl): DateProvider

    @Binds
    @Singleton
    abstract fun bindRecipeRemoteDataSource(impl: RecipeRemoteDataSourceImpl): RecipeRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindRecipeLocalDataSource(impl: RecipeLocalDataSourceImpl): RecipeLocalDataSource

    // Essentially, only this binding is changed.
    @Binds
    @Singleton
    abstract fun bindPreferenceDataStore(impl: FakePreferenceDataStore): PreferenceDataStore
}