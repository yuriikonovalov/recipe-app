//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.recipedetails](../index.md)/[RecipeDetailsViewModel](index.md)

# RecipeDetailsViewModel

[androidJvm]\
class [RecipeDetailsViewModel](index.md)@AssistedInjectconstructor(@AssistedrecipeId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saveRecipe: [SaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-save-recipe/index.md), unsaveRecipe: [UnsaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), getRecipeDetails: [GetRecipeDetails](../../com.yuriikonovalov.recipeapp.application.usecases/-get-recipe-details/index.md), recipeMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;, espressoIdlingResource: [EspressoIdlingResource](../../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the recipe details screen.

## Constructors

| | |
|---|---|
| [RecipeDetailsViewModel](-recipe-details-view-model.md) | [androidJvm]<br>@AssistedInject<br>fun [RecipeDetailsViewModel](-recipe-details-view-model.md)(@AssistedrecipeId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saveRecipe: [SaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-save-recipe/index.md), unsaveRecipe: [UnsaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), getRecipeDetails: [GetRecipeDetails](../../com.yuriikonovalov.recipeapp.application.usecases/-get-recipe-details/index.md), recipeMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;, espressoIdlingResource: [EspressoIdlingResource](../../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [Factory](-factory/index.md) | [androidJvm]<br>@AssistedFactory<br>interface [Factory](-factory/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onRetryButtonClick](on-retry-button-click.md) | [androidJvm]<br>fun [onRetryButtonClick](on-retry-button-click.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Updates state by setting the error flag to false and starts loading data. |
| [onSaveButtonClick](on-save-button-click.md) | [androidJvm]<br>fun [onSaveButtonClick](on-save-button-click.md)()<br>Saves the recipe to favorites. |
| [onSelectMeasureSystem](on-select-measure-system.md) | [androidJvm]<br>fun [onSelectMeasureSystem](on-select-measure-system.md)(position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Changes [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) for displaying and redraws views that depend on it. |
| [onSourceButtonClick](on-source-button-click.md) | [androidJvm]<br>fun [onSourceButtonClick](on-source-button-click.md)()<br>Triggers [eventFlow](event-flow.md) to emit a [RecipeDetailsEvent.OpenSourcePage](../../com.yuriikonovalov.recipeapp.presentation.recipedetails/-recipe-details-event/-open-source-page/index.md) event. |

## Properties

| Name | Summary |
|---|---|
| [eventConsumer](event-consumer.md) | [androidJvm]<br>val [eventConsumer](event-consumer.md): () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>A function that sets [eventFlow](event-flow.md)'s value to null. |
| [eventFlow](event-flow.md) | [androidJvm]<br>val [eventFlow](event-flow.md): StateFlow&lt;[RecipeDetailsEvent](../../com.yuriikonovalov.recipeapp.presentation.recipedetails/-recipe-details-event/index.md)?&gt; |
| [stateFlow](state-flow.md) | [androidJvm]<br>val [stateFlow](state-flow.md): StateFlow&lt;[RecipeDetailsState](../../com.yuriikonovalov.recipeapp.presentation.recipedetails/-recipe-details-state/index.md)&gt; |
