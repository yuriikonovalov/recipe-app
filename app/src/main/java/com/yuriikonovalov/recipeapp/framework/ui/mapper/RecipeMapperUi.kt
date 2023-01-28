package com.yuriikonovalov.recipeapp.framework.ui.mapper

import android.content.Context
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.application.entities.Ingredient
import com.yuriikonovalov.recipeapp.application.entities.MealType
import com.yuriikonovalov.recipeapp.application.entities.Recipe
import com.yuriikonovalov.recipeapp.presentation.MapperUi
import com.yuriikonovalov.recipeapp.presentation.model.IngredientUi
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * This is a UI mapper between [RecipeUi] and [Recipe].
 */
class RecipeMapperUi @Inject constructor(
    @ApplicationContext private val context: Context,
    private val ingredientMapper: MapperUi<Ingredient, IngredientUi>,
) : MapperUi<Recipe, RecipeUi> {
    override fun mapToUi(domain: Recipe): RecipeUi {
        return RecipeUi(
            id = domain.id,
            image = domain.image,
            title = domain.title ?: "",
            servings = domain.servings?.toServingsUi(context),
            time = domain.readyInMinutes?.toTimeUi(context),
            ingredients = domain.ingredients.ingredientsUi(),
            instructions = domain.instructions.toInstructionsUi(),
            mealTypes = domain.mealTypes.toMealTypesUi(context),
            sourceUrl = domain.sourceUrl,
            vegetarian = domain.vegetarian ?: false,
            saved = domain.saved
        )
    }

    private fun String?.toInstructionsUi(): Spanned? {
        return this?.let { string ->
            HtmlCompat.fromHtml(
                string,
                HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH
            )
        }
    }

    private fun List<Ingredient>.ingredientsUi(): List<IngredientUi> {
        return map { ingredientMapper.mapToUi(it) }
    }

    private fun Int.toTimeUi(context: Context): String {
        return context.getString(R.string.min, this)
    }

    private fun Int.toServingsUi(context: Context): String {
        return context.resources.getQuantityString(R.plurals.plural_servings, this, this)
    }

    private fun List<MealType>.toMealTypesUi(context: Context): String {
        val list = this.map { it.toMealTypeUi(context) }
        return buildString {
            list.forEachIndexed { index, s ->
                append(s)
                if (index != list.lastIndex) {
                    append(", ")
                }
            }
        }
    }

    private fun MealType.toMealTypeUi(context: Context): String {
        return when (this) {
            MealType.MAIN_COURSE -> context.getString(R.string.main_course)
            MealType.MARINADE -> context.getString(R.string.marinade)
            MealType.SALAD -> context.getString(R.string.salad)
            MealType.SNACK -> context.getString(R.string.snack)
            MealType.SAUCE -> context.getString(R.string.sauce)
            MealType.SOUP -> context.getString(R.string.soup)
            MealType.BREAD -> context.getString(R.string.bread)
            MealType.FINGERFOOD -> context.getString(R.string.fingerfood)
            MealType.DESSERT -> context.getString(R.string.dessert)
            MealType.APPETIZER -> context.getString(R.string.appetizer)
            MealType.SIDE_DISH -> context.getString(R.string.side_dish)
            MealType.BREAKFAST -> context.getString(R.string.breakfast)
            MealType.BEVERAGE -> context.getString(R.string.beverage)
            MealType.DRINK -> context.getString(R.string.drink)
            MealType.OTHER -> context.getString(R.string.other)
            MealType.LUNCH -> context.getString(R.string.lunch)
            MealType.DINNER -> context.getString(R.string.dinner)
        }
    }
}