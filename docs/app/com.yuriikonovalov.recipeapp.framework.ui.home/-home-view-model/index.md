//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

[androidJvm]\
class [HomeViewModel](index.md)@Injectconstructor(getRandomRecipes: [GetRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-random-recipes/index.md), updateRandomRecipes: [UpdateRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-update-random-recipes/index.md), mapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt;, idlingResource: [EspressoIdlingResource](../../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the home screen.

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [androidJvm]<br>@Inject<br>fun [HomeViewModel](-home-view-model.md)(getRandomRecipes: [GetRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-random-recipes/index.md), updateRandomRecipes: [UpdateRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-update-random-recipes/index.md), mapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt;, idlingResource: [EspressoIdlingResource](../../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [onRecipeClick](on-recipe-click.md) | [androidJvm]<br>fun [onRecipeClick](on-recipe-click.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Triggers [eventFlow](event-flow.md) to emit a [HomeEvent.OpenRecipeDetails](../../com.yuriikonovalov.recipeapp.presentation.home/-home-event/-open-recipe-details/index.md) event. |
| [onSearchButtonClick](on-search-button-click.md) | [androidJvm]<br>fun [onSearchButtonClick](on-search-button-click.md)()<br>Triggers [eventFlow](event-flow.md) to emit a [HomeEvent.GoToSearchFragment](../../com.yuriikonovalov.recipeapp.presentation.home/-home-event/-go-to-search-fragment/index.md) event. |
| [refreshRecipes](refresh-recipes.md) | [androidJvm]<br>fun [refreshRecipes](refresh-recipes.md)()<br>Refreshes a list of random recipes. |

## Properties

| Name | Summary |
|---|---|
| [eventConsumer](event-consumer.md) | [androidJvm]<br>val [eventConsumer](event-consumer.md): () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>A function that sets [eventFlow](event-flow.md)'s value to null. |
| [eventFlow](event-flow.md) | [androidJvm]<br>val [eventFlow](event-flow.md): StateFlow&lt;[HomeEvent](../../com.yuriikonovalov.recipeapp.presentation.home/-home-event/index.md)?&gt; |
| [stateFlow](state-flow.md) | [androidJvm]<br>val [stateFlow](state-flow.md): StateFlow&lt;[HomeState](../../com.yuriikonovalov.recipeapp.presentation.home/-home-state/index.md)&gt; |
