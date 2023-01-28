//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.service](../index.md)/[RecipeService](index.md)/[getRandomRecipes](get-random-recipes.md)

# getRandomRecipes

[androidJvm]\

@GET(value = &quot;/recipes/random&quot;)

abstract suspend fun [getRandomRecipes](get-random-recipes.md)(@Query(value = &quot;number&quot;)number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-response-api/index.md)
