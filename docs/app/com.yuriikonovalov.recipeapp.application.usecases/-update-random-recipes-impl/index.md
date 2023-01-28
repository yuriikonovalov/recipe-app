//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[UpdateRandomRecipesImpl](index.md)

# UpdateRandomRecipesImpl

[androidJvm]\
class [UpdateRandomRecipesImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md), dateProvider: [DateProvider](../../com.yuriikonovalov.recipeapp.data.local/-date-provider/index.md)) : [UpdateRandomRecipes](../-update-random-recipes/index.md)

## Constructors

| | |
|---|---|
| [UpdateRandomRecipesImpl](-update-random-recipes-impl.md) | [androidJvm]<br>@Inject<br>fun [UpdateRandomRecipesImpl](-update-random-recipes-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md), dateProvider: [DateProvider](../../com.yuriikonovalov.recipeapp.data.local/-date-provider/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open suspend operator override fun [invoke](invoke.md)(size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), forced: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Loads a number([size](invoke.md)) of new random recipes and saves them to database. |
