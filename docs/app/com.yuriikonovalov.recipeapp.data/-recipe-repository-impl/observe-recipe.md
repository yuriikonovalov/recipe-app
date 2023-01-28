//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data](../index.md)/[RecipeRepositoryImpl](index.md)/[observeRecipe](observe-recipe.md)

# observeRecipe

[androidJvm]\
open override fun [observeRecipe](observe-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;

Creates a flow that emits [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) for the given [id](observe-recipe.md).

#### Return

a Flow that emits [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)

#### Parameters

androidJvm

| | |
|---|---|
| id | id to observe a recipe by. |
