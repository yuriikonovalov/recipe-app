package com.yuriikonovalov.recipeapp.util

import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.MealType
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import kotlin.random.Random

val ingredient: Ingredient
    get() {
        val id = System.currentTimeMillis().toInt()
        return Ingredient(
            id = id, name = "Ingredient$id", image = null, measureMetric = null, measureUs = null
        )
    }


fun ingredients(empty: Boolean = false): List<Ingredient> {
    val max = 15
    return if (empty) {
        emptyList()
    } else {
        List(Random.nextInt(1, max)) { ingredient }
    }
}

fun mealTypes(empty: Boolean = false): List<MealType> {
    return if (empty) {
        emptyList()
    } else {
        MealType.values().take(Random.nextInt(1, MealType.values().size))
    }
}

fun searchRecipe(nameSeed: String? = null): SearchRecipe {
    val id = System.nanoTime().toInt()
    val title = nameSeed?.let {
        if (Random.nextBoolean()) {
            "$it title $id"
        } else {
            "title$id"
        }
    } ?: "title$id"
    return SearchRecipe(
        id = id,
        title = title,
        image = ""
    )
}

fun recipe(cache: Boolean = false, saved: Boolean = false): Recipe {
    val id = System.nanoTime().toInt()
    return Recipe(
        id = id,
        title = "title$id",
        mealTypes = mealTypes(),
        ingredients = ingredients(),
        instructions = null,
        readyInMinutes = Random.nextInt(1, 200),
        servings = Random.nextInt(1, 10),
        image = null,
        sourceUrl = null,
        vegetarian = Random.nextBoolean(),
        cache = cache,
        saved = saved
    )
}

fun recipes(number: Int = 1, cache: Boolean = false, saved: Boolean = false) =
    List(number) { recipe(cache, saved) }

fun randomRecipes(number: Int = 1) = List(number) { recipe() }

fun Recipe.recipeUi(): RecipeUi {
    return RecipeUi(
        id = id,
        title = title ?: "title$id",
        mealTypes = "",
        ingredients = emptyList(),
        instructions = null,
        time = null,
        servings = null,
        image = null,
        sourceUrl = null,
        vegetarian = Random.nextBoolean(),
        saved = saved
    )
}