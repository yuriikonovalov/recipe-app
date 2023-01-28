//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote](../index.md)/[RecipeRemoteDataSourceImpl](index.md)

# RecipeRemoteDataSourceImpl

[androidJvm]\
class [RecipeRemoteDataSourceImpl](index.md)@Injectconstructor(service: [RecipeService](../../com.yuriikonovalov.recipeapp.framework.data.remote.service/-recipe-service/index.md), recipeMapper: [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[RecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md), [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;, searchRecipeResponseMapper: [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[SearchRecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md), [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)&gt;) : [RecipeRemoteDataSource](../../com.yuriikonovalov.recipeapp.data.remote/-recipe-remote-data-source/index.md)

Implementation of [RecipeRemoteDataSource](../../com.yuriikonovalov.recipeapp.data.remote/-recipe-remote-data-source/index.md).

## Constructors

| | |
|---|---|
| [RecipeRemoteDataSourceImpl](-recipe-remote-data-source-impl.md) | [androidJvm]<br>@Inject<br>fun [RecipeRemoteDataSourceImpl](-recipe-remote-data-source-impl.md)(service: [RecipeService](../../com.yuriikonovalov.recipeapp.framework.data.remote.service/-recipe-service/index.md), recipeMapper: [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[RecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md), [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;, searchRecipeResponseMapper: [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[SearchRecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md), [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [getRandomRecipes](get-random-recipes.md) | [androidJvm]<br>open suspend override fun [getRandomRecipes](get-random-recipes.md)(number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;<br>Loads a [number](get-random-recipes.md) of new random recipes from a remote data source. |
| [getRecipeDetails](get-recipe-details.md) | [androidJvm]<br>open suspend override fun [getRecipeDetails](get-recipe-details.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)<br>Loads recipe details by the given id. |
| [searchRecipes](search-recipes.md) | [androidJvm]<br>open suspend override fun [searchRecipes](search-recipes.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)<br>Searches for recipes by the given [query](search-recipes.md), [offset](search-recipes.md) and [number](search-recipes.md). |
