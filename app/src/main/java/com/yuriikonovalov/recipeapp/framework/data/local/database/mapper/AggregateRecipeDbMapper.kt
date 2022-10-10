package com.yuriikonovalov.recipeapp.framework.data.local.database.mapper

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.IngredientDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.RecipeDb
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation.AggregateRecipeDb
import javax.inject.Inject

class AggregateRecipeDbMapper @Inject constructor(
    private val ingredientDbMapper: MapperDb<Ingredient, IngredientDb>,
) : MapperDb<Recipe, AggregateRecipeDb> {
    override fun mapToDomain(db: AggregateRecipeDb): Recipe {
        return Recipe(
            id = db.recipeDb.id,
            title = db.recipeDb.title,
            mealTypes = db.recipeDb.mealTypes,
            ingredients = db.ingredients(),
            instructions = db.recipeDb.instructions,
            readyInMinutes = db.recipeDb.readyInMinutes,
            servings = db.recipeDb.servings,
            image = db.recipeDb.image,
            sourceUrl = db.recipeDb.sourceUrl,
            vegetarian = db.recipeDb.vegetarian,
            cache = db.recipeDb.cache,
            saved = db.recipeDb.saved
        )
    }

    private fun AggregateRecipeDb.ingredients(): List<Ingredient> {
        return this.ingredients.map {
            ingredientDbMapper.mapToDomain(it)
        }
    }

    override fun mapFromDomain(domain: Recipe): AggregateRecipeDb {
        return AggregateRecipeDb(
            recipeDb = domain.cacheRecipeDb(),
            ingredients = domain.cacheIngredientsDb()
        )
    }

    private fun Recipe.cacheIngredientsDb(): List<IngredientDb> {
        return ingredients.map { it.ingredientDb(this.id) }
    }

    private fun Ingredient.ingredientDb(recipeId: Int): IngredientDb {
        return IngredientDb(
            id = 0,
            recipeId = recipeId,
            name = name,
            image = image,
            amountUs = measureUs?.amount,
            unitShortUs = measureUs?.unitShort,
            unitLongUs = measureUs?.unitLong,
            amountMetric = measureMetric?.amount,
            unitShortMetric = measureMetric?.unitShort,
            unitLongMetric = measureMetric?.unitLong
        )
    }

    private fun Recipe.cacheRecipeDb(): RecipeDb {
        return RecipeDb(
            id = id,
            title = title,
            mealTypes = mealTypes,
            instructions = instructions,
            readyInMinutes = readyInMinutes,
            servings = servings,
            image = image,
            sourceUrl = sourceUrl,
            vegetarian = vegetarian,
            cache = cache,
            saved = saved
        )
    }

    override fun mapToDomain(dbList: List<AggregateRecipeDb>): List<Recipe> {
        return dbList.map(::mapToDomain)
    }
}