//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[SaveRecipeImpl](index.md)

# SaveRecipeImpl

[androidJvm]\
class [SaveRecipeImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) : [SaveRecipe](../-save-recipe/index.md)

## Constructors

| | |
|---|---|
| [SaveRecipeImpl](-save-recipe-impl.md) | [androidJvm]<br>@Inject<br>fun [SaveRecipeImpl](-save-recipe-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open suspend operator override fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Sets true as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/saved.md) of the recipe for the given [id](invoke.md). |
