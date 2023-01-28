//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[UnsaveRecipeImpl](index.md)

# UnsaveRecipeImpl

[androidJvm]\
class [UnsaveRecipeImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) : [UnsaveRecipe](../-unsave-recipe/index.md)

## Constructors

| | |
|---|---|
| [UnsaveRecipeImpl](-unsave-recipe-impl.md) | [androidJvm]<br>@Inject<br>fun [UnsaveRecipeImpl](-unsave-recipe-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open suspend operator override fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Sets false as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/saved.md) of the recipe for the given [id](invoke.md). |
