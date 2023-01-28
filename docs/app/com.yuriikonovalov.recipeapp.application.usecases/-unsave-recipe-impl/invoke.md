//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[UnsaveRecipeImpl](index.md)/[invoke](invoke.md)

# invoke

[androidJvm]\
open suspend operator override fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;

Sets false as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/saved.md) of the recipe for the given [id](invoke.md).

#### Return

[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md) with the id of the updated recipe.

#### Parameters

androidJvm

| | |
|---|---|
| id | id of the recipe to be updated. |
