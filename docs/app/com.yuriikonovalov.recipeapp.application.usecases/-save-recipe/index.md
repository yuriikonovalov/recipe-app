//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[SaveRecipe](index.md)

# SaveRecipe

[androidJvm]\
interface [SaveRecipe](index.md)

Defines a use case of saving a recipe by id.

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>abstract suspend operator fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Sets true as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/saved.md) of the recipe for the given [id](invoke.md). |

## Inheritors

| Name |
|---|
| [SaveRecipeImpl](../-save-recipe-impl/index.md) |
