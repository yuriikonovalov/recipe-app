package com.yuriikonovalov.recipeapp.di

import android.content.Context
import androidx.room.Room
import com.yuriikonovalov.recipeapp.framework.data.local.database.AppDatabase
import com.yuriikonovalov.recipeapp.framework.data.local.database.dao.RecipeDao
import com.yuriikonovalov.recipeapp.framework.di.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestDatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .build()
    }

    @Provides
    fun provideRecipeDao(database: AppDatabase): RecipeDao = database.recipeDao()
}