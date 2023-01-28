//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[GetRecipeDetailsImpl](index.md)

# GetRecipeDetailsImpl

[androidJvm]\
class [GetRecipeDetailsImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) : [GetRecipeDetails](../-get-recipe-details/index.md)

## Constructors

| | |
|---|---|
| [GetRecipeDetailsImpl](-get-recipe-details-impl.md) | [androidJvm]<br>@Inject<br>fun [GetRecipeDetailsImpl](-get-recipe-details-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open suspend operator override fun [invoke](invoke.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Resource](../../com.yuriikonovalov.recipeapp.resource/-resource/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;<br>Creates a Flow that emits [Resource.Success](../../com.yuriikonovalov.recipeapp.resource/-resource/-success/index.md) with data of type [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) if the recipe was found for the given [id](invoke.md), otherwise - [Resource.Failure](../../com.yuriikonovalov.recipeapp.resource/-resource/-failure/index.md). |
