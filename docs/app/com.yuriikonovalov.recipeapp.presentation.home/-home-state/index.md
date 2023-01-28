//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.home](../index.md)/[HomeState](index.md)

# HomeState

[androidJvm]\
data class [HomeState](index.md)(val recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt; = emptyList(), val loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val empty: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

This class holds state of the home screen.

## Constructors

| | |
|---|---|
| [HomeState](-home-state.md) | [androidJvm]<br>fun [HomeState](-home-state.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt; = emptyList(), loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, empty: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Functions

| Name | Summary |
|---|---|
| [updateEmpty](update-empty.md) | [androidJvm]<br>fun [updateEmpty](update-empty.md)(empty: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [HomeState](index.md) |
| [updateLoading](update-loading.md) | [androidJvm]<br>fun [updateLoading](update-loading.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [HomeState](index.md) |
| [updateRecipes](update-recipes.md) | [androidJvm]<br>fun [updateRecipes](update-recipes.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt;): [HomeState](index.md) |

## Properties

| Name | Summary |
|---|---|
| [empty](empty.md) | [androidJvm]<br>val [empty](empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>a flag that shows if there's no data to show. |
| [emptyPlaceholderVisible](empty-placeholder-visible.md) | [androidJvm]<br>val [emptyPlaceholderVisible](empty-placeholder-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>a flag that shows if data is loading or not. |
| [loadingPlaceholderVisible](loading-placeholder-visible.md) | [androidJvm]<br>val [loadingPlaceholderVisible](loading-placeholder-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [recipes](recipes.md) | [androidJvm]<br>val [recipes](recipes.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt;<br>a list of [RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md). |
