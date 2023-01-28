//[app](../../index.md)/[com.yuriikonovalov.recipeapp.presentation.savedrecipes](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes related to the saved recipes feature of the presentation layer of the application.

## Types

| Name | Summary |
|---|---|
| [SavedRecipeDetailsEvent](-saved-recipe-details-event/index.md) | [androidJvm]<br>sealed class [SavedRecipeDetailsEvent](-saved-recipe-details-event/index.md)<br>This class represents events related to the saved recipe details feature. |
| [SavedRecipesEvent](-saved-recipes-event/index.md) | [androidJvm]<br>sealed class [SavedRecipesEvent](-saved-recipes-event/index.md)<br>This class represents events related to the saved recipes feature. |
| [SavedRecipesState](-saved-recipes-state/index.md) | [androidJvm]<br>data class [SavedRecipesState](-saved-recipes-state/index.md)(val recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; = emptyList(), val selectedRecipe: [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, val measureSystem: [MeasureSystem](../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, val saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val initialSelectionDone: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val windowSizeClass: [WindowSizeClass](../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md) = WindowSizeClass.COMPACT, val paneOpen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>This class holds state of the saved recipes screen. |
