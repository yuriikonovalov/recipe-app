//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[GetSavedRecipesImpl](index.md)

# GetSavedRecipesImpl

[androidJvm]\
class [GetSavedRecipesImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) : [GetSavedRecipes](../-get-saved-recipes/index.md)

## Constructors

| | |
|---|---|
| [GetSavedRecipesImpl](-get-saved-recipes-impl.md) | [androidJvm]<br>@Inject<br>fun [GetSavedRecipesImpl](-get-saved-recipes-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open operator override fun [invoke](invoke.md)(): Flow&lt;[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;&gt;<br>Creates a Flow that emits [Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) if there's at least 1 saved recipe, otherwise - [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md). |
