package com.yuriikonovalov.recipeapp.framework.ui.mapper

import android.content.Context
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.IngredientUi
import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * This is a UI mapper between [RandomRecipeUi] and [Recipe].
 */
class RandomRecipeMapperUi @Inject constructor(
    @ApplicationContext private val context: Context
) : MapperUi<Recipe, RandomRecipeUi> {
    override fun mapToUi(domain: Recipe): RandomRecipeUi {
        return RandomRecipeUi(
            id = domain.id,
            title = domain.title ?: "",
            time = domain.readyInMinutes?.toTimeUi(context) ?: "",
            ingredients = domain.ingredients.size.toIngredientsUi(context),
            image = domain.image
        )
    }

    private fun Int.toTimeUi(context: Context): String {
        return context.getString(R.string.min, this)
    }

    private fun Int.toIngredientsUi(context: Context): String {
        return context.resources.getQuantityString(R.plurals.plural_ingredients, this, this)
    }
}