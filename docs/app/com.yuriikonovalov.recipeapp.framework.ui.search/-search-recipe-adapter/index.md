//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.search](../index.md)/[SearchRecipeAdapter](index.md)

# SearchRecipeAdapter

[androidJvm]\
class [SearchRecipeAdapter](index.md)(onItemClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [PagingDataAdapter](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md), [SearchRecipeAdapter.SearchRecipeViewHolder](-search-recipe-view-holder/index.md)&gt; 

A custom implementation of [PagingDataAdapter](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter.html) for displaying a list of search results.

## Constructors

| | |
|---|---|
| [SearchRecipeAdapter](-search-recipe-adapter.md) | [androidJvm]<br>fun [SearchRecipeAdapter](-search-recipe-adapter.md)(onItemClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [SearchRecipeViewHolder](-search-recipe-view-holder/index.md) | [androidJvm]<br>class [SearchRecipeViewHolder](-search-recipe-view-holder/index.md) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html) |

## Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | [androidJvm]<br>open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [SearchRecipeAdapter.SearchRecipeViewHolder](-search-recipe-view-holder/index.md), position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onCreateViewHolder](on-create-view-holder.md) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeAdapter.SearchRecipeViewHolder](-search-recipe-view-holder/index.md) |
