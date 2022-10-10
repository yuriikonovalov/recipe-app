package com.yuriikonovalov.recipeapp.framework.data.local.database.model

import androidx.room.*


@Entity(tableName = "ingredients",
    foreignKeys = [
        ForeignKey(
            entity = RecipeDb::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("recipe_id")
    ])
data class IngredientDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "recipe_id")
    val recipeId: Int,
    val name: String?,
    val image: String?,
    @ColumnInfo(name = "amount_us")
    val amountUs: Double?,
    @ColumnInfo(name = "unit_long_s")
    val unitLongUs: String?,
    @ColumnInfo(name = "unit_short_us")
    val unitShortUs: String?,
    @ColumnInfo(name = "amount_metric")
    val amountMetric: Double?,
    @ColumnInfo(name = "unit_long_metric")
    val unitLongMetric: String?,
    @ColumnInfo(name = "unit_short_metric")
    val unitShortMetric: String?,
)
