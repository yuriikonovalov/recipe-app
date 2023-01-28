//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.savedrecipes](../index.md)/[RecipeAdapter](index.md)

# RecipeAdapter

[androidJvm]\
class [RecipeAdapter](index.md) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md), [RecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md)&gt; 

A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of recipes.

## Constructors

| | |
|---|---|
| [RecipeAdapter](-recipe-adapter.md) | [androidJvm]<br>fun [RecipeAdapter](-recipe-adapter.md)() |

## Types

| Name | Summary |
|---|---|
| [RecipeViewHolder](-recipe-view-holder/index.md) | [androidJvm]<br>class [RecipeViewHolder](-recipe-view-holder/index.md) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html) |

## Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | [androidJvm]<br>open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [RecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md), position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onCreateViewHolder](on-create-view-holder.md) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RecipeAdapter.RecipeViewHolder](-recipe-view-holder/index.md) |
| [selectCard](select-card.md) | [androidJvm]<br>fun [selectCard](select-card.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setOnRecipeClick](set-on-recipe-click.md) | [androidJvm]<br>fun [setOnRecipeClick](set-on-recipe-click.md)(onRecipeClick: (recipe: [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
