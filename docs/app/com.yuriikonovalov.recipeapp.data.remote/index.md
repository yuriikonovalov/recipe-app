//[app](../../index.md)/[com.yuriikonovalov.recipeapp.data.remote](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the remote data classes of the application.

## Types

| Name | Summary |
|---|---|
| [RecipeRemoteDataSource](-recipe-remote-data-source/index.md) | [androidJvm]<br>interface [RecipeRemoteDataSource](-recipe-remote-data-source/index.md)<br>Defines the interface for a class that will provide access to a remote data source. |
| [SearchRecipePagingSource](-search-recipe-paging-source/index.md) | [androidJvm]<br>class [SearchRecipePagingSource](-search-recipe-paging-source/index.md)(remoteSource: [RecipeRemoteDataSource](-recipe-remote-data-source/index.md), query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [SearchRecipe](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt; <br>Implementation of [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) for [SearchRecipe](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md). |
