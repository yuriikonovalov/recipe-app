//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[SearchRecipes](index.md)/[invoke](invoke.md)

# invoke

[androidJvm]\
abstract operator fun [invoke](invoke.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt;

Searches for recipes that are illegible for the given [query](invoke.md) and returns results in form of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) with data type [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md).

#### Return

a Flow of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) with data type [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| query | a query to search by. |
| pageSize | a size of lists that will be emitted. |
