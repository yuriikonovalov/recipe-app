//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.savedrecipes](../index.md)/[SavedRecipesViewModel](index.md)

# SavedRecipesViewModel

[androidJvm]\
class [SavedRecipesViewModel](index.md)@Injectconstructor(getSavedRecipes: [GetSavedRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-saved-recipes/index.md), unsaveRecipe: [UnsaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), recipeMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the saved recipes screen.

## Constructors

| | |
|---|---|
| [SavedRecipesViewModel](-saved-recipes-view-model.md) | [androidJvm]<br>@Inject<br>fun [SavedRecipesViewModel](-saved-recipes-view-model.md)(getSavedRecipes: [GetSavedRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-saved-recipes/index.md), unsaveRecipe: [UnsaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), recipeMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [onClickBackButton](on-click-back-button.md) | [androidJvm]<br>fun [onClickBackButton](on-click-back-button.md)()<br>Triggers [eventFlow](event-flow.md) to emit a [SavedRecipesEvent.CloseDetailsPane](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-event/-close-details-pane/index.md) or [SavedRecipesEvent.OpenDetailsPane](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-event/-open-details-pane/index.md) based on the current state. |
| [onClickNavigateUpButton](on-click-navigate-up-button.md) | [androidJvm]<br>fun [onClickNavigateUpButton](on-click-navigate-up-button.md)()<br>Triggers [eventFlow](event-flow.md) to emit a [SavedRecipesEvent.CloseDetailsPane](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-event/-close-details-pane/index.md) or [SavedRecipesEvent.OpenDetailsPane](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-event/-open-details-pane/index.md) based on the current state. |
| [onSaveButtonClick](on-save-button-click.md) | [androidJvm]<br>fun [onSaveButtonClick](on-save-button-click.md)()<br>Performs removing the recipe from the favorites. |
| [onSelectMeasureSystem](on-select-measure-system.md) | [androidJvm]<br>fun [onSelectMeasureSystem](on-select-measure-system.md)(position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSelectRecipe](on-select-recipe.md) | [androidJvm]<br>fun [onSelectRecipe](on-select-recipe.md)(recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)) |
| [onSourceButtonClick](on-source-button-click.md) | [androidJvm]<br>fun [onSourceButtonClick](on-source-button-click.md)() |
| [onUpdatePaneState](on-update-pane-state.md) | [androidJvm]<br>fun [onUpdatePaneState](on-update-pane-state.md)(open: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Updates the [SavedRecipesState.paneOpen](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-state/pane-open.md) property with the given [open](on-update-pane-state.md) value. |
| [onUpdateWindowSizeClass](on-update-window-size-class.md) | [androidJvm]<br>fun [onUpdateWindowSizeClass](on-update-window-size-class.md)(widthWindowSizeClass: [WindowSizeClass](../../com.yuriikonovalov.recipeapp.util/-window-size-class/index.md))<br>Updates the [SavedRecipesState.windowSizeClass](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-state/window-size-class.md) property with the given [widthWindowSizeClass](on-update-window-size-class.md) value. |

## Properties

| Name | Summary |
|---|---|
| [detailsEventConsumer](details-event-consumer.md) | [androidJvm]<br>val [detailsEventConsumer](details-event-consumer.md): () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>A function that sets _detailsEventFlow's value to null. |
| [detailsEventFlow](details-event-flow.md) | [androidJvm]<br>val [detailsEventFlow](details-event-flow.md): StateFlow&lt;[SavedRecipeDetailsEvent](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipe-details-event/index.md)?&gt; |
| [eventConsumer](event-consumer.md) | [androidJvm]<br>val [eventConsumer](event-consumer.md): () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>A function that sets _eventFlow's value to null. |
| [eventFlow](event-flow.md) | [androidJvm]<br>val [eventFlow](event-flow.md): StateFlow&lt;[SavedRecipesEvent](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-event/index.md)?&gt; |
| [stateFlow](state-flow.md) | [androidJvm]<br>val [stateFlow](state-flow.md): StateFlow&lt;[SavedRecipesState](../../com.yuriikonovalov.recipeapp.presentation.savedrecipes/-saved-recipes-state/index.md)&gt; |
