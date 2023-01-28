//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.application](../index.md)/[RecipeRepository](index.md)

# RecipeRepository

[androidJvm]\
interface [RecipeRepository](index.md)

An interface that contains all of the methods related to the [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) entity.

## Functions

| Name | Summary |
|---|---|
| [deleteNeedlessRecipes](delete-needless-recipes.md) | [androidJvm]<br>abstract suspend fun [deleteNeedlessRecipes](delete-needless-recipes.md)()<br>Deletes recipes that are neither saved or cached. |
| [deleteRecipe](delete-recipe.md) | [androidJvm]<br>abstract suspend fun [deleteRecipe](delete-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Deletes a recipe for the given [id](delete-recipe.md). |
| [getLastCacheDate](get-last-cache-date.md) | [androidJvm]<br>abstract fun [getLastCacheDate](get-last-cache-date.md)(): Flow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Returns the latest date of caching as Flow that emits [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) values. |
| [getRandomRecipes](get-random-recipes.md) | [androidJvm]<br>abstract fun [getRandomRecipes](get-random-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;<br>Creates a Flow that emits lists of random [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md). |
| [getRecipe](get-recipe.md) | [androidJvm]<br>abstract suspend fun [getRecipe](get-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)?<br>Loads a recipe from a local data source for the given [id](get-recipe.md). |
| [getRemoteRecipe](get-remote-recipe.md) | [androidJvm]<br>abstract suspend fun [getRemoteRecipe](get-remote-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)<br>Loads a [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) for the given [id](get-remote-recipe.md) from a remote data source. |
| [getSavedRecipes](get-saved-recipes.md) | [androidJvm]<br>abstract fun [getSavedRecipes](get-saved-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt;<br>Creates a Flow that emits lists of saved [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md). |
| [observeRecipe](observe-recipe.md) | [androidJvm]<br>abstract fun [observeRecipe](observe-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;<br>Creates a flow that emits [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) for the given [id](observe-recipe.md). |
| [refreshRandomRecipeCache](refresh-random-recipe-cache.md) | [androidJvm]<br>abstract suspend fun [refreshRandomRecipeCache](refresh-random-recipe-cache.md)(number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Updates random recipes with a given [number](refresh-random-recipe-cache.md) of new random recipes and sets [date](refresh-random-recipe-cache.md) as the latest date of caching. |
| [saveRecipe](save-recipe.md) | [androidJvm]<br>abstract suspend fun [saveRecipe](save-recipe.md)(recipe: [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md))<br>Saves [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md) to database. |
| [searchRecipes](search-recipes.md) | [androidJvm]<br>abstract fun [searchRecipes](search-recipes.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;&gt;<br>Creates a Flow that emits [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) of [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md). The emitted values depend on the given [query](search-recipes.md) and [pageSize](search-recipes.md). |
| [updateRecipeSavedFlag](update-recipe-saved-flag.md) | [androidJvm]<br>abstract suspend fun [updateRecipeSavedFlag](update-recipe-saved-flag.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Updates value of the [Recipe.saved](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/saved.md) property of the recipe with the given [id](update-recipe-saved-flag.md) to the given [saved](update-recipe-saved-flag.md) value. |

## Inheritors

| Name |
|---|
| [RecipeRepositoryImpl](../../com.yuriikonovalov.recipeapp.data/-recipe-repository-impl/index.md) |
