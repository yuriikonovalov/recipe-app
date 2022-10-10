package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Measure
import com.yuriikonovalov.recipeapp.framework.data.remote.model.ExtendedIngredientApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.MeasureApi
import javax.inject.Inject

class IngredientMapperApi @Inject constructor() : MapperApi<ExtendedIngredientApi, Ingredient> {
    override fun mapToDomain(api: ExtendedIngredientApi): Ingredient {
        return Ingredient(
            id = api.id,
            name = api.name,
            image = composeImageUrl(api.image),
            measureUs = api.measures?.us?.toDomain(),
            measureMetric = api.measures?.metric?.toDomain()
        )
    }

    private fun MeasureApi.MeasureCompoundApi.toDomain(): Measure {
        return Measure(
            amount = this.amount,
            unitLong = this.unitLong,
            unitShort = this.unitShort
        )
    }

    private fun composeImageUrl(image: String?): String? {
        return image?.let {
            "https://spoonacular.com/cdn/ingredients_100x100/$it"
        }
    }
}

