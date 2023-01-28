//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[UpdateRandomRecipes](index.md)

# UpdateRandomRecipes

[androidJvm]\
interface [UpdateRandomRecipes](index.md)

Defines a use case of updating random recipes.

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>abstract suspend operator fun [invoke](invoke.md)(size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), forced: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Loads a number([size](invoke.md)) of new random recipes and saves them to database. |

## Inheritors

| Name |
|---|
| [UpdateRandomRecipesImpl](../-update-random-recipes-impl/index.md) |
