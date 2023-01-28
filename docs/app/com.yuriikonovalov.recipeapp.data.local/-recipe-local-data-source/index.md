//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.local](../index.md)/[RecipeLocalDataSource](index.md)

# RecipeLocalDataSource

[androidJvm]\
interface [RecipeLocalDataSource](index.md)

Defines the interface for a class that will provide access to a local data source.

## Functions

| Name | Summary |
|---|---|
| [deleteCacheRecipes](delete-cache-recipes.md) | [androidJvm]<br>abstract suspend fun [deleteCacheRecipes](delete-cache-recipes.md)() |
| [deleteNeedlessRecipes](delete-needless-recipes.md) | [androidJvm]<br>abstract suspend fun [deleteNeedlessRecipes](delete-needless-recipes.md)() |
| [deleteRecipeById](delete-recipe-by-id.md) | [androidJvm]<br>abstract suspend fun [deleteRecipeById](delete-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [getCacheRecipes](get-cache-recipes.md) | [androidJvm]<br>abstract fun [getCacheRecipes](get-cache-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt; |
| [getRecipeById](get-recipe-by-id.md) | [androidJvm]<br>abstract suspend fun [getRecipeById](get-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)? |
| [getSavedRecipes](get-saved-recipes.md) | [androidJvm]<br>abstract fun [getSavedRecipes](get-saved-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt; |
| [insertRecipe](insert-recipe.md) | [androidJvm]<br>abstract suspend fun [insertRecipe](insert-recipe.md)(recipe: [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)) |
| [insertRecipes](insert-recipes.md) | [androidJvm]<br>abstract suspend fun [insertRecipes](insert-recipes.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;) |
| [observeRecipeById](observe-recipe-by-id.md) | [androidJvm]<br>abstract fun [observeRecipeById](observe-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt; |
| [updateRecipeSavedFlag](update-recipe-saved-flag.md) | [androidJvm]<br>abstract suspend fun [updateRecipeSavedFlag](update-recipe-saved-flag.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Inheritors

| Name |
|---|
| [RecipeLocalDataSourceImpl](../../com.yuriikonovalov.recipeapp.framework.data.local.database/-recipe-local-data-source-impl/index.md) |
