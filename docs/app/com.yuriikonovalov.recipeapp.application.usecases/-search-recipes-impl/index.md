//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application.usecases](../index.md)/[SearchRecipesImpl](index.md)

# SearchRecipesImpl

[androidJvm]\
class [SearchRecipesImpl](index.md)@Injectconstructor(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) : [SearchRecipes](../-search-recipes/index.md)

## Constructors

| | |
|---|---|
| [SearchRecipesImpl](-search-recipes-impl.md) | [androidJvm]<br>@Inject<br>fun [SearchRecipesImpl](-search-recipes-impl.md)(repository: [RecipeRepository](../../com.yuriikonovalov.recipeapp.application/-recipe-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [androidJvm]<br>open operator override fun [invoke](invoke.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt;<br>Searches for recipes that are illegible for the given [query](invoke.md) and returns results in form of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) with data type [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md). |
