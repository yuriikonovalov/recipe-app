//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.recipedetails](../index.md)/[RecipeDetailsState](index.md)

# RecipeDetailsState

[androidJvm]\
data class [RecipeDetailsState](index.md)(val recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, val measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, val loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

This class holds state of the recipe details screen.

## Constructors

| | |
|---|---|
| [RecipeDetailsState](-recipe-details-state.md) | [androidJvm]<br>fun [RecipeDetailsState](-recipe-details-state.md)(recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Functions

| Name | Summary |
|---|---|
| [updateError](update-error.md) | [androidJvm]<br>fun [updateError](update-error.md)(error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [RecipeDetailsState](index.md) |
| [updateLoading](update-loading.md) | [androidJvm]<br>fun [updateLoading](update-loading.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [RecipeDetailsState](index.md) |
| [updateMeasureSystem](update-measure-system.md) | [androidJvm]<br>fun [updateMeasureSystem](update-measure-system.md)(measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md)): [RecipeDetailsState](index.md) |
| [updateRecipe](update-recipe.md) | [androidJvm]<br>fun [updateRecipe](update-recipe.md)(recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)): [RecipeDetailsState](index.md) |

## Properties

| Name | Summary |
|---|---|
| [contentVisible](content-visible.md) | [androidJvm]<br>val [contentVisible](content-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [error](error.md) | [androidJvm]<br>val [error](error.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>a flag to show that there's been an error during loading. |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>a flag to show if data is loading or not. |
| [measureSystem](measure-system.md) | [androidJvm]<br>val [measureSystem](measure-system.md): [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md)<br>a [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) that is used for displaying ingredients amounts. |
| [recipe](recipe.md) | [androidJvm]<br>val [recipe](recipe.md): [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null<br>a recipe details of which are shown. |
