package com.yuriikonovalov.recipeapp.fake.mapper

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi

object FakeRandomRecipeMapperUi : MapperUi<Recipe, RandomRecipeUi> {
    override fun mapToUi(domain: Recipe): RandomRecipeUi {
        return RandomRecipeUi(
            id = domain.id,
            title = domain.title ?: "",
            time = domain.readyInMinutes?.toString() ?: "",
            ingredients = domain.ingredients.size.toString(),
            image = domain.image
        )
    }
}