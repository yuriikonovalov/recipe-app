package com.yuriikonovalov.recipeapp.framework.ui.mapper

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Measure
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.IngredientUi
import com.yuriikonovalov.recipeapp.util.roundDecimals
import javax.inject.Inject

/**
 * This is a UI mapper between [IngredientUi] and [Ingredient].
 */
class IngredientMapperUi @Inject constructor() : MapperUi<Ingredient, IngredientUi> {
    override fun mapToUi(domain: Ingredient): IngredientUi {
        return IngredientUi(
            id = domain.id,
            name = domain.name ?: "",
            image = domain.image ?: "",
            measureUs = domain.measureUs?.measureUi() ?: "",
            measureMetric = domain.measureMetric?.measureUi() ?: ""
        )
    }

    private fun Measure.measureUi(): String {
        return "${formatAmountToUnit()} $unitLong"
    }

    private fun Measure.formatAmountToUnit(): String {
        return when (unitLong) {
            null -> amount?.toInt()?.toString() ?: ""
            else -> amount?.roundDecimals(2)?.toString() ?: ""
        }
    }
}