//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.service](../index.md)/[RecipeService](index.md)/[searchRecipes](search-recipes.md)

# searchRecipes

[androidJvm]\

@GET(value = &quot;/recipes/complexSearch&quot;)

abstract suspend fun [searchRecipes](search-recipes.md)(@Query(value = &quot;query&quot;)query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;offset&quot;)offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;number&quot;)number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchRecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md)
