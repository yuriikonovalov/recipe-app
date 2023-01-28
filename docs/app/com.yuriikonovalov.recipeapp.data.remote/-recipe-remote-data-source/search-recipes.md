//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.remote](../index.md)/[RecipeRemoteDataSource](index.md)/[searchRecipes](search-recipes.md)

# searchRecipes

[androidJvm]\
abstract suspend fun [searchRecipes](search-recipes.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)

Searches for recipes by the given [query](search-recipes.md), [offset](search-recipes.md) and [number](search-recipes.md).

#### Return

[SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)

#### Parameters

androidJvm

| | |
|---|---|
| query | a query to search by. |
| offset | an offset of applied to a result list. |
| number | a number of recipes to be loaded. |

#### Throws

| |
|---|
| HttpException |
| [IOException](https://developer.android.com/reference/kotlin/java/io/IOException.html) |
