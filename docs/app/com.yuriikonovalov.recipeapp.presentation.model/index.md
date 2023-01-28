//[app](../../index.md)/[com.yuriikonovalov.recipeapp.presentation.model](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the presentation model classes (ui) of the application.

## Types

| Name | Summary |
|---|---|
| [IngredientUi](-ingredient-ui/index.md) | [androidJvm]<br>data class [IngredientUi](-ingredient-ui/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val measureUs: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val measureMetric: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>This class is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md). |
| [RandomRecipeUi](-random-recipe-ui/index.md) | [androidJvm]<br>data class [RandomRecipeUi](-random-recipe-ui/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val ingredients: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)<br>This class is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) optimized for displaying as a list item. |
| [RecipeUi](-recipe-ui/index.md) | [androidJvm]<br>data class [RecipeUi](-recipe-ui/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val servings: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val ingredients: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientUi](-ingredient-ui/index.md)&gt;, val instructions: [Spanned](https://developer.android.com/reference/kotlin/android/text/Spanned.html)?, val mealTypes: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>This is a UI model of [com.yuriikonovalov.recipeapp.application.entities.Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md). |

## Properties

| Name | Summary |
|---|---|
| [ingredientsVisible](ingredients-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[ingredientsVisible](ingredients-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [instructionsVisible](instructions-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[instructionsVisible](instructions-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mealTypeVisible](meal-type-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[mealTypeVisible](meal-type-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [measureSpinnerVisible](measure-spinner-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[measureSpinnerVisible](measure-spinner-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [servingsVisible](servings-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[servingsVisible](servings-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sourceButtonVisible](source-button-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[sourceButtonVisible](source-button-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [timeVisible](time-visible.md) | [androidJvm]<br>val [RecipeUi](-recipe-ui/index.md).[timeVisible](time-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
