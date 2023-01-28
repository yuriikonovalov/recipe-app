//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[GetRecipeDetails](index.md)

# GetRecipeDetails

[androidJvm]\
interface [GetRecipeDetails](index.md)

Defines a use case of getting recipe details by id.

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>abstract suspend operator fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;<br>Creates a Flow that emits [Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) with data of type [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) if the recipe was found for the given [id](invoke.md), otherwise - [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md). |

## Inheritors

| Name |
|---|
| [GetRecipeDetailsImpl](../-get-recipe-details-impl/index.md) |
