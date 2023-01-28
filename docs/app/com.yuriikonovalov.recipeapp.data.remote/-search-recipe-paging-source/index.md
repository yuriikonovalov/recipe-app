//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.remote](../index.md)/[SearchRecipePagingSource](index.md)

# SearchRecipePagingSource

[androidJvm]\
class [SearchRecipePagingSource](index.md)(remoteSource: [RecipeRemoteDataSource](../-recipe-remote-data-source/index.md), query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt; 

Implementation of [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) for [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md).

## Constructors

| | |
|---|---|
| [SearchRecipePagingSource](-search-recipe-paging-source.md) | [androidJvm]<br>fun [SearchRecipePagingSource](-search-recipe-paging-source.md)(remoteSource: [RecipeRemoteDataSource](../-recipe-remote-data-source/index.md), query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [getRefreshKey](get-refresh-key.md) | [androidJvm]<br>open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt; |
