//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.model](../index.md)/[RecipeUi](index.md)

# RecipeUi

[androidJvm]\
data class [RecipeUi](index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val servings: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val ingredients: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientUi](../-ingredient-ui/index.md)&gt;, val instructions: [Spanned](https://developer.android.com/reference/kotlin/android/text/Spanned.html)?, val mealTypes: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

This is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md).

## Constructors

| | |
|---|---|
| [RecipeUi](-recipe-ui.md) | [androidJvm]<br>fun [RecipeUi](-recipe-ui.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), servings: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, ingredients: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientUi](../-ingredient-ui/index.md)&gt;, instructions: [Spanned](https://developer.android.com/reference/kotlin/android/text/Spanned.html)?, mealTypes: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>id of the recipe. |
| [image](image.md) | [androidJvm]<br>val [image](image.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>a URL of the image of the recipe. |
| [ingredients](ingredients.md) | [androidJvm]<br>val [ingredients](ingredients.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientUi](../-ingredient-ui/index.md)&gt;<br>a list of the ingredients of the recipe. |
| [instructions](instructions.md) | [androidJvm]<br>val [instructions](instructions.md): [Spanned](https://developer.android.com/reference/kotlin/android/text/Spanned.html)?<br>instructions required to cook a dish. |
| [mealTypes](meal-types.md) | [androidJvm]<br>val [mealTypes](meal-types.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [saved](saved.md) | [androidJvm]<br>val [saved](saved.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>a flag to show if the recipe is saved to favorites or not. |
| [servings](servings.md) | [androidJvm]<br>val [servings](servings.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>a number of servings of the recipe. |
| [sourceUrl](source-url.md) | [androidJvm]<br>val [sourceUrl](source-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>a URL of the recipe. |
| [time](time.md) | [androidJvm]<br>val [time](time.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>amount of time in minutes needed for the recipe. |
| [title](title.md) | [androidJvm]<br>val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [vegetarian](vegetarian.md) | [androidJvm]<br>val [vegetarian](vegetarian.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>a flag to denote if the recipe is vegetarian or not. |

## Extensions

| Name | Summary |
|---|---|
| [ingredientsVisible](../ingredients-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[ingredientsVisible](../ingredients-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [instructionsVisible](../instructions-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[instructionsVisible](../instructions-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mealTypeVisible](../meal-type-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[mealTypeVisible](../meal-type-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [measureSpinnerVisible](../measure-spinner-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[measureSpinnerVisible](../measure-spinner-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [servingsVisible](../servings-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[servingsVisible](../servings-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sourceButtonVisible](../source-button-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[sourceButtonVisible](../source-button-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [timeVisible](../time-visible.md) | [androidJvm]<br>val [RecipeUi](index.md).[timeVisible](../time-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
