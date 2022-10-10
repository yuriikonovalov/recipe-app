package com.yuriikonovalov.recipeapp.framework.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yuriikonovalov.recipeapp.framework.data.local.database.dao.RecipeDao
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.*
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.converter.MealTypeListConverter

@Database(
    entities = [
        RecipeDb::class,
        IngredientDb::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(MealTypeListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}