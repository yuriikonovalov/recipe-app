//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.search](../index.md)/[SearchRecipeLoadStateAdapter](index.md)

# SearchRecipeLoadStateAdapter

[androidJvm]\
class [SearchRecipeLoadStateAdapter](index.md)(onRetry: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [LoadStateAdapter](https://developer.android.com/reference/kotlin/androidx/paging/LoadStateAdapter.html)&lt;[SearchRecipeLoadStateAdapter.LoadStateViewHolder](-load-state-view-holder/index.md)&gt; 

A custom implementation of [LoadStateAdapter](https://developer.android.com/reference/kotlin/androidx/paging/LoadStateAdapter.html).

## Constructors

| | |
|---|---|
| [SearchRecipeLoadStateAdapter](-search-recipe-load-state-adapter.md) | [androidJvm]<br>fun [SearchRecipeLoadStateAdapter](-search-recipe-load-state-adapter.md)(onRetry: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [LoadStateViewHolder](-load-state-view-holder/index.md) | [androidJvm]<br>class [LoadStateViewHolder](-load-state-view-holder/index.md) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html) |

## Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | [androidJvm]<br>open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [SearchRecipeLoadStateAdapter.LoadStateViewHolder](-load-state-view-holder/index.md), loadState: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)) |
| [onCreateViewHolder](on-create-view-holder.md) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), loadState: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)): [SearchRecipeLoadStateAdapter.LoadStateViewHolder](-load-state-view-holder/index.md) |
