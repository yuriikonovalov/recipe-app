package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.MealType
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.framework.data.remote.model.ExtendedIngredientApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.RecipeApi
import javax.inject.Inject

class RecipeMapperApi @Inject constructor(
    private val ingredientMapperApi: MapperApi<ExtendedIngredientApi, Ingredient>,
) : MapperApi<RecipeApi, Recipe> {
    override fun mapToDomain(api: RecipeApi): Recipe {
        return Recipe(
            id = api.id,
            title = api.title,
            mealTypes = mapMealType(api.dishTypes),
            ingredients = mapIngredients(api.extendedIngredient),
            instructions = api.instructions,
            readyInMinutes = api.readyInMinutes,
            servings = api.servings,
            image = api.image,
            sourceUrl = api.sourceUrl,
            vegetarian = api.vegetarian,
            cache = false,
            saved = false
        )
    }

    private fun mapIngredients(ingredients: List<ExtendedIngredientApi>?): List<Ingredient> {
        return ingredients?.map { ingredientMapperApi.mapToDomain(it) } ?: emptyList()
    }

    private fun mapMealType(dishTypes: List<String>?): List<MealType> {
        val list = dishTypes?.map { stringType ->
            when (stringType) {
                in "main course", "main dish" -> MealType.MAIN_COURSE
                "side dish" -> MealType.SIDE_DISH
                "dessert" -> MealType.DESSERT
                "appetizer" -> MealType.APPETIZER
                "salad" -> MealType.SALAD
                "bread" -> MealType.BREAD
                "breakfast" -> MealType.BREAKFAST
                "soup" -> MealType.SOUP
                "beverage" -> MealType.BEVERAGE
                "sauce" -> MealType.SAUCE
                "marinade" -> MealType.MARINADE
                "fingerfood" -> MealType.FINGERFOOD
                "snack" -> MealType.SNACK
                "drink" -> MealType.DRINK
                "lunch" -> MealType.LUNCH
                "dinner" -> MealType.DINNER
                else -> MealType.OTHER
            }
        } ?: emptyList()
        // map to set to get rid of duplicates
        return list
            .toSet()
            .toList()
    }
}