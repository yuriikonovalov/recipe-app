package com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.IngredientDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.RecipeDb

data class AggregateRecipeDb(
    @Embedded
    val recipeDb: RecipeDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipe_id"
    )
    val ingredients: List<IngredientDb>,
)
