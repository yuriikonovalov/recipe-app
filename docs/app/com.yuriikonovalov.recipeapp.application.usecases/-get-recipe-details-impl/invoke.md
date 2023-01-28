//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[GetRecipeDetailsImpl](index.md)/[invoke](invoke.md)

# invoke

[androidJvm]\
open suspend operator override fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;

Creates a Flow that emits [Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) with data of type [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) if the recipe was found for the given [id](invoke.md), otherwise - [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| id | id of the recipe to be emitted. |
