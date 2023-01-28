//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.remote](../index.md)/[RecipeRemoteDataSource](index.md)

# RecipeRemoteDataSource

[androidJvm]\
interface [RecipeRemoteDataSource](index.md)

Defines the interface for a class that will provide access to a remote data source.

## Functions

| Name | Summary |
|---|---|
| [getRandomRecipes](get-random-recipes.md) | [androidJvm]<br>abstract suspend fun [getRandomRecipes](get-random-recipes.md)(number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;<br>Loads a [number](get-random-recipes.md) of new random recipes from a remote data source. |
| [getRecipeDetails](get-recipe-details.md) | [androidJvm]<br>abstract suspend fun [getRecipeDetails](get-recipe-details.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)<br>Loads recipe details by the given id. |
| [searchRecipes](search-recipes.md) | [androidJvm]<br>abstract suspend fun [searchRecipes](search-recipes.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)<br>Searches for recipes by the given [query](search-recipes.md), [offset](search-recipes.md) and [number](search-recipes.md). |

## Inheritors

| Name |
|---|
| [RecipeRemoteDataSourceImpl](../../com.yuriikonovalov.recipeapp.framework.data.remote/-recipe-remote-data-source-impl/index.md) |
