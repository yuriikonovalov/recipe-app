package com.yuriikonovalov.recipeapp.fake.mapper

import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.framework.ui.mapper.IngredientMapperUi
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi

object FakeRecipeMapperUi : MapperUi<Recipe, RecipeUi> {
    private val ingredientMapper = IngredientMapperUi()
    override fun mapToUi(domain: Recipe): RecipeUi {
        return RecipeUi(
            id = domain.id,
            image = domain.image,
            title = domain.title ?: "",
            servings = domain.servings?.toString(),
            time = domain.readyInMinutes?.toString(),
            ingredients = domain.ingredients.map(ingredientMapper::mapToUi),
            instructions = null,
            mealTypes = domain.mealTypes.toString(),
            sourceUrl = null,
            vegetarian = domain.vegetarian ?: false,
            saved = domain.saved
        )
    }
}