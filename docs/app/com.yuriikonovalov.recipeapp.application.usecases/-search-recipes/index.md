//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[SearchRecipes](index.md)

# SearchRecipes

[androidJvm]\
interface [SearchRecipes](index.md)

Defines a use case of searching recipes by query and page size.

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>abstract operator fun [invoke](invoke.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt;<br>Searches for recipes that are illegible for the given [query](invoke.md) and returns results in form of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) with data type [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md). |

## Inheritors

| Name |
|---|
| [SearchRecipesImpl](../-search-recipes-impl/index.md) |
