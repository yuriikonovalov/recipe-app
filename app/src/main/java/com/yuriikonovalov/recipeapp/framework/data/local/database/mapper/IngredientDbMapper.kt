package com.yuriikonovalov.recipeapp.framework.data.local.database.mapper

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Measure
import com.yuriikonovalov.recipeapp.framework.data.local.database.model.IngredientDb
import javax.inject.Inject

class IngredientDbMapper @Inject constructor() : MapperDb<Ingredient, IngredientDb> {
    override fun mapToDomain(db: IngredientDb): Ingredient {
        return Ingredient(
            id = db.id,
            name = db.name,
            image = db.image,
            measureUs = db.measureUs(),
            measureMetric = db.measureMetric()
        )
    }

    private fun IngredientDb.measureUs(): Measure {
        return Measure(
            amount = amountUs,
            unitShort = unitShortUs,
            unitLong = unitLongUs
        )
    }

    private fun IngredientDb.measureMetric(): Measure {
        return Measure(
            amount = amountMetric,
            unitShort = unitShortMetric,
            unitLong = unitLongMetric
        )
    }

    override fun mapFromDomain(domain: Ingredient): IngredientDb {
        throw NotImplementedError()
    }

    override fun mapToDomain(dbList: List<IngredientDb>): List<Ingredient> {
        return dbList.map(::mapToDomain)
    }
}