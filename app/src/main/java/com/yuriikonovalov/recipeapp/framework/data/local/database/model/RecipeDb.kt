package com.yuriikonovalov.recipeapp.framework.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yuriikonovalov.recipeapp.application.entities.MealType


@Entity(tableName = "recipes")
data class RecipeDb(
    @PrimaryKey
    val id: Int,
    val title: String?,
    @ColumnInfo(name = "meal_types")
    val mealTypes: List<MealType>,
    val instructions: String?,
    @ColumnInfo(name = "ready_in_minutes")
    val readyInMinutes: Int?,
    val servings: Int?,
    val image: String?,
    @ColumnInfo(name = "source_url")
    val sourceUrl: String?,
    val vegetarian: Boolean?,
    val cache: Boolean,
    val saved: Boolean
)