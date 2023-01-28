//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.search](../index.md)/[SearchViewModel](index.md)

# SearchViewModel

[androidJvm]\
class [SearchViewModel](index.md)@Injectconstructor(searchRecipes: [SearchRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-search-recipes/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the search screen.

## Constructors

| | |
|---|---|
| [SearchViewModel](-search-view-model.md) | [androidJvm]<br>@Inject<br>fun [SearchViewModel](-search-view-model.md)(searchRecipes: [SearchRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-search-recipes/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [onInputQuery](on-input-query.md) | [androidJvm]<br>fun [onInputQuery](on-input-query.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Changes current state by updating a query. |
| [onPerformSearch](on-perform-search.md) | [androidJvm]<br>fun [onPerformSearch](on-perform-search.md)()<br>Triggers search logic if the query is not blank, otherwise - triggers [eventFlow](event-flow.md) to emit a [SearchEvent.IncorrectQueryToast](../../com.yuriikonovalov.recipeapp.presentation.search/-search-event/-incorrect-query-toast/index.md) event. |
| [onSearchRecipeClick](on-search-recipe-click.md) | [androidJvm]<br>fun [onSearchRecipeClick](on-search-recipe-click.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [updateCombinedLoadState](update-combined-load-state.md) | [androidJvm]<br>fun [updateCombinedLoadState](update-combined-load-state.md)(combinedLoadState: [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html), itemCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [eventConsumer](event-consumer.md) | [androidJvm]<br>val [eventConsumer](event-consumer.md): () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>A function that sets [eventFlow](event-flow.md)'s value to null. |
| [eventFlow](event-flow.md) | [androidJvm]<br>val [eventFlow](event-flow.md): StateFlow&lt;[SearchEvent](../../com.yuriikonovalov.recipeapp.presentation.search/-search-event/index.md)?&gt; |
| [pagingData](paging-data.md) | [androidJvm]<br>val [pagingData](paging-data.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt; |
| [stateFlow](state-flow.md) | [androidJvm]<br>val [stateFlow](state-flow.md): StateFlow&lt;[SearchState](../../com.yuriikonovalov.recipeapp.presentation.search/-search-state/index.md)&gt; |
