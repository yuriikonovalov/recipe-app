//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.service](../index.md)/[RecipeService](index.md)

# RecipeService

[androidJvm]\
interface [RecipeService](index.md)

Defines the interface of request to the server. It will be used by the Retrofit library to generate requests.

## Functions

| Name | Summary |
|---|---|
| [getRandomRecipes](get-random-recipes.md) | [androidJvm]<br>@GET(value = &quot;/recipes/random&quot;)<br>abstract suspend fun [getRandomRecipes](get-random-recipes.md)(@Query(value = &quot;number&quot;)number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-response-api/index.md) |
| [getRecipeInformation](get-recipe-information.md) | [androidJvm]<br>@GET(value = &quot;/recipes/{id}/information&quot;)<br>abstract suspend fun [getRecipeInformation](get-recipe-information.md)(@Path(value = &quot;id&quot;)id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md) |
| [searchRecipes](search-recipes.md) | [androidJvm]<br>@GET(value = &quot;/recipes/complexSearch&quot;)<br>abstract suspend fun [searchRecipes](search-recipes.md)(@Query(value = &quot;query&quot;)query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;offset&quot;)offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;number&quot;)number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md) |
