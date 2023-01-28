//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.recipedetails](../index.md)/[IngredientAdapter](index.md)

# IngredientAdapter

[androidJvm]\
class [IngredientAdapter](index.md) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[IngredientUi](../../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md), [IngredientAdapter.IngredientViewHolder](-ingredient-view-holder/index.md)&gt; 

A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of ingredients.

## Constructors

| | |
|---|---|
| [IngredientAdapter](-ingredient-adapter.md) | [androidJvm]<br>fun [IngredientAdapter](-ingredient-adapter.md)() |

## Types

| Name | Summary |
|---|---|
| [IngredientViewHolder](-ingredient-view-holder/index.md) | [androidJvm]<br>class [IngredientViewHolder](-ingredient-view-holder/index.md) : [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html) |

## Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | [androidJvm]<br>open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [IngredientAdapter.IngredientViewHolder](-ingredient-view-holder/index.md), position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onCreateViewHolder](on-create-view-holder.md) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.md)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html), viewType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [IngredientAdapter.IngredientViewHolder](-ingredient-view-holder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [measureSystem](measure-system.md) | [androidJvm]<br>var [measureSystem](measure-system.md): [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md)<br>Keeps a type of [MeasureSystem](../../com.yuriikonovalov.recipeapp.application.entities/-measure-system/index.md) that is used for displaying. |
