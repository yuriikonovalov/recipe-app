//[app](../../index.md)/[com.yuriikonovalov.recipeapp.presentation.recipedetails](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes related to the recipe details feature of the presentation layer of the application.

## Types

| Name | Summary |
|---|---|
| [RecipeDetailsEvent](-recipe-details-event/index.md) | [androidJvm]<br>sealed class [RecipeDetailsEvent](-recipe-details-event/index.md)<br>This class represents events related to the recipe details feature. |
| [RecipeDetailsState](-recipe-details-state/index.md) | [androidJvm]<br>data class [RecipeDetailsState](-recipe-details-state/index.md)(val recipe: [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, val measureSystem: [MeasureSystem](../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, val loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>This class holds state of the recipe details screen. |
