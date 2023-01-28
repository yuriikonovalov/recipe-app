//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.savedrecipes](../index.md)/[SavedRecipesState](index.md)

# SavedRecipesState

[androidJvm]\
data class [SavedRecipesState](index.md)(val recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; = emptyList(), val selectedRecipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, val measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, val saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val initialSelectionDone: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val windowSizeClass: [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md) = WindowSizeClass.COMPACT, val paneOpen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

This class holds state of the saved recipes screen.

## Constructors

| | |
|---|---|
| [SavedRecipesState](-saved-recipes-state.md) | [androidJvm]<br>fun [SavedRecipesState](-saved-recipes-state.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; = emptyList(), selectedRecipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null, measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) = MeasureSystem.Metric, saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, initialSelectionDone: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, windowSizeClass: [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md) = WindowSizeClass.COMPACT, paneOpen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Functions

| Name | Summary |
|---|---|
| [updateInitialSelectionDone](update-initial-selection-done.md) | [androidJvm]<br>fun [updateInitialSelectionDone](update-initial-selection-done.md)(done: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [SavedRecipesState](index.md) |
| [updateMeasureSystem](update-measure-system.md) | [androidJvm]<br>fun [updateMeasureSystem](update-measure-system.md)(measureSystem: [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md)): [SavedRecipesState](index.md) |
| [updatePaneOpen](update-pane-open.md) | [androidJvm]<br>fun [updatePaneOpen](update-pane-open.md)(open: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [SavedRecipesState](index.md) |
| [updateRecipes](update-recipes.md) | [androidJvm]<br>fun [updateRecipes](update-recipes.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;): [SavedRecipesState](index.md) |
| [updateSelectedRecipe](update-selected-recipe.md) | [androidJvm]<br>fun [updateSelectedRecipe](update-selected-recipe.md)(recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)): [SavedRecipesState](index.md) |
| [updateWindowSizeClass](update-window-size-class.md) | [androidJvm]<br>fun [updateWindowSizeClass](update-window-size-class.md)(windowSizeClass: [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md)): [SavedRecipesState](index.md) |

## Properties

| Name | Summary |
|---|---|
| [emptyList](empty-list.md) | [androidJvm]<br>val [emptyList](empty-list.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [initialSelectionDone](initial-selection-done.md) | [androidJvm]<br>val [initialSelectionDone](initial-selection-done.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [measureSystem](measure-system.md) | [androidJvm]<br>val [measureSystem](measure-system.md): [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md)<br>a [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) that is used for displaying ingredients amounts. |
| [paneOpen](pane-open.md) | [androidJvm]<br>val [paneOpen](pane-open.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>shows if the details pane is open or not. |
| [recipes](recipes.md) | [androidJvm]<br>val [recipes](recipes.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;<br>a list of all saved recipes. |
| [saved](saved.md) | [androidJvm]<br>val [saved](saved.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>a flag for denoting that a recipe is saved. |
| [selectedRecipe](selected-recipe.md) | [androidJvm]<br>val [selectedRecipe](selected-recipe.md): [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)? = null<br>a recipe that is shown in the details pane. |
| [selectedRecipeCard](selected-recipe-card.md) | [androidJvm]<br>val [selectedRecipeCard](selected-recipe-card.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |
| [windowSizeClass](window-size-class.md) | [androidJvm]<br>val [windowSizeClass](window-size-class.md): [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md)<br>an instance of [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md) that points to the current window size. |
