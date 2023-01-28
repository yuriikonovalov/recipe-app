package com.yuriikonovalov.recipeapp.framework.di


import android.content.Context
import androidx.room.Room
import com.yuriikonovalov.recipeapp.framework.data.local.database.AppDatabase
import com.yuriikonovalov.recipeapp.framework.data.local.database.dao.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Orchestrates dependency inject for a database and DAOs.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "recipe_db"

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRecipeDao(database: AppDatabase): RecipeDao = database.recipeDao()
}