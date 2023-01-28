//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.service](../index.md)/[RecipeService](index.md)/[getRecipeInformation](get-recipe-information.md)

# getRecipeInformation

[androidJvm]\

@GET(value = &quot;/recipes/{id}/information&quot;)

abstract suspend fun [getRecipeInformation](get-recipe-information.md)(@Path(value = &quot;id&quot;)id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [RecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md)
