//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.remote](../index.md)/[RecipeRemoteDataSource](index.md)/[getRandomRecipes](get-random-recipes.md)

# getRandomRecipes

[androidJvm]\
abstract suspend fun [getRandomRecipes](get-random-recipes.md)(number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;

Loads a [number](get-random-recipes.md) of new random recipes from a remote data source.

#### Return

a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| number | a number of recipes to be loaded. |
