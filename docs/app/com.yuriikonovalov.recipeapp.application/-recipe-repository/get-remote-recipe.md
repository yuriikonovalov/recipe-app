//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application](../index.md)/[RecipeRepository](index.md)/[getRemoteRecipe](get-remote-recipe.md)

# getRemoteRecipe

[androidJvm]\
abstract suspend fun [getRemoteRecipe](get-remote-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)

Loads a [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) for the given [id](get-remote-recipe.md) from a remote data source.

#### Return

a [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) with the corresponding [id](get-remote-recipe.md).

#### Parameters

androidJvm

| | |
|---|---|
| id | id of the recipe to be loaded. |
