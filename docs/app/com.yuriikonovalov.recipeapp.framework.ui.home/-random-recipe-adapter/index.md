//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.home](../index.md)/[RandomRecipeAdapter](index.md)

# RandomRecipeAdapter

[androidJvm]\
class [RandomRecipeAdapter](index.md)(onRecipeClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md), [RandomRecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md)&gt; 

A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of random recipes.

## Constructors

| | |
|---|---|
| [RandomRecipeAdapter](-random-recipe-adapter.md) | [androidJvm]<br>fun [RandomRecipeAdapter](-random-recipe-adapter.md)(onRecipeClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [RecipeViewHolder](-recipe-view-holder/index.md) | [androidJvm]<br>class [RecipeViewHolder](-recipe-view-holder/index.md) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html) |

## Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | [androidJvm]<br>open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [RandomRecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md), position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onCreateViewHolder](on-create-view-holder.md) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RandomRecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md) |
