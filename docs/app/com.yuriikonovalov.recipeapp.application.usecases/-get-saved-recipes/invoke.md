//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[GetSavedRecipes](index.md)/[invoke](invoke.md)

# invoke

[androidJvm]\
abstract operator fun [invoke](invoke.md)(): Flow&lt;[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;&gt;

Creates a Flow that emits [Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) if there's at least 1 saved recipe, otherwise - [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md).

#### Return

a Flow that emits [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md).
