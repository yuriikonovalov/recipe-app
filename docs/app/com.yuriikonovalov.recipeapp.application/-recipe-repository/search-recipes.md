//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application](../index.md)/[RecipeRepository](index.md)/[searchRecipes](search-recipes.md)

# searchRecipes

[androidJvm]\
abstract fun [searchRecipes](search-recipes.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt;

Creates a Flow that emits [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) of [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md). The emitted values depend on the given [query](search-recipes.md) and [pageSize](search-recipes.md).

#### Return

a Flow that emits [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) of type [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| query | a query that is used for searching. |
| pageSize | a size of list by which search results will be emitting. |
