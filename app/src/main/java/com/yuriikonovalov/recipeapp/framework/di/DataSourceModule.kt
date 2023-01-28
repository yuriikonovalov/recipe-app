package com.yuriikonovalov.recipeapp.framework.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.yuriikonovalov.recipeapp.data.local.DateProvider
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.framework.data.local.DateProviderImpl
import com.yuriikonovalov.recipeapp.framework.data.local.database.RecipeLocalDataSourceImpl
import com.yuriikonovalov.recipeapp.framework.data.local.preferences.PREFERENCES_NAME
import com.yuriikonovalov.recipeapp.framework.data.local.preferences.PreferenceDataStoreImpl
import com.yuriikonovalov.recipeapp.framework.data.remote.RecipeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Orchestrates dependency inject for local, remote data sources and a preference data store.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun binDateProvider(impl: DateProviderImpl): DateProvider

    @Binds
    abstract fun bindRecipeRemoteDataSource(impl: RecipeRemoteDataSourceImpl): RecipeRemoteDataSource

    @Binds
    abstract fun bindRecipeLocalDataSource(impl: RecipeLocalDataSourceImpl): RecipeLocalDataSource

    @Binds
    abstract fun bindPreferenceDataStore(impl: PreferenceDataStoreImpl): PreferenceDataStore

    companion object {
        @Singleton
        @Provides
        fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
            return PreferenceDataStoreFactory.create(
                corruptionHandler = ReplaceFileCorruptionHandler { emptyPreferences() },
                scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
                produceFile = {
                    context.preferencesDataStoreFile(PREFERENCES_NAME)
                }
            )
        }
    }
}