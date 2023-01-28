//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[UpdateRandomRecipesImpl](index.md)/[invoke](invoke.md)

# invoke

[androidJvm]\
open suspend operator override fun [invoke](invoke.md)(size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), forced: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;

Loads a number([size](invoke.md)) of new random recipes and saves them to database.

#### Return

[Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) if updating is successful. [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md) if updating is unsuccessful.

#### Parameters

androidJvm

| | |
|---|---|
| size | a number of recipes to be updated. |
| forced | if true - comparing of the latest date of caching will be skipped, so updating may happen multiple times per day. |
