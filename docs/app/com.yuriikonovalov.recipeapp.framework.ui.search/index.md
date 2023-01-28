//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.search](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes of the application related to search feature ui.

## Types

| Name | Summary |
|---|---|
| [SearchFragment](-search-fragment/index.md) | [androidJvm]<br>class [SearchFragment](-search-fragment/index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) |
| [SearchRecipeAdapter](-search-recipe-adapter/index.md) | [androidJvm]<br>class [SearchRecipeAdapter](-search-recipe-adapter/index.md)(onItemClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [PagingDataAdapter](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter.html)&lt;[SearchRecipe](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md), [SearchRecipeAdapter.SearchRecipeViewHolder](-search-recipe-adapter/-search-recipe-view-holder/index.md)&gt; <br>A custom implementation of [PagingDataAdapter](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter.html) for displaying a list of search results. |
| [SearchRecipeLoadStateAdapter](-search-recipe-load-state-adapter/index.md) | [androidJvm]<br>class [SearchRecipeLoadStateAdapter](-search-recipe-load-state-adapter/index.md)(onRetry: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [LoadStateAdapter](https://developer.android.com/reference/kotlin/androidx/paging/LoadStateAdapter.html)&lt;[SearchRecipeLoadStateAdapter.LoadStateViewHolder](-search-recipe-load-state-adapter/-load-state-view-holder/index.md)&gt; <br>A custom implementation of [LoadStateAdapter](https://developer.android.com/reference/kotlin/androidx/paging/LoadStateAdapter.html). |
| [SearchViewModel](-search-view-model/index.md) | [androidJvm]<br>class [SearchViewModel](-search-view-model/index.md)@Injectconstructor(searchRecipes: [SearchRecipes](../com.yuriikonovalov.recipeapp.application.usecases/-search-recipes/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the search screen. |
