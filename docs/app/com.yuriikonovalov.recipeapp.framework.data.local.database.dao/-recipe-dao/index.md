//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.dao](../index.md)/[RecipeDao](index.md)

# RecipeDao

[androidJvm]\
interface [RecipeDao](index.md)

Defines the DAO interface for [RecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-recipe-db/index.md) which will be used by the Room library.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [deleteAllCache](delete-all-cache.md) | [androidJvm]<br>abstract suspend fun [deleteAllCache](delete-all-cache.md)() |
| [deleteNeedlessRecipes](delete-needless-recipes.md) | [androidJvm]<br>abstract suspend fun [deleteNeedlessRecipes](delete-needless-recipes.md)() |
| [getCacheRecipes](get-cache-recipes.md) | [androidJvm]<br>abstract fun [getCacheRecipes](get-cache-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;&gt; |
| [getRecipe](get-recipe.md) | [androidJvm]<br>abstract suspend fun [getRecipe](get-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)? |
| [getSavedRecipes](get-saved-recipes.md) | [androidJvm]<br>abstract fun [getSavedRecipes](get-saved-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;&gt; |
| [insertIngredients](insert-ingredients.md) | [androidJvm]<br>abstract suspend fun [insertIngredients](insert-ingredients.md)(ingredients: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;) |
| [insertRecipe](insert-recipe.md) | [androidJvm]<br>abstract suspend fun [insertRecipe](insert-recipe.md)(recipe: [RecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-recipe-db/index.md)) |
| [insertRecipes](insert-recipes.md) | [androidJvm]<br>abstract suspend fun [insertRecipes](insert-recipes.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-recipe-db/index.md)&gt;) |
| [observeRecipe](observe-recipe.md) | [androidJvm]<br>abstract fun [observeRecipe](observe-recipe.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)?&gt; |
| [updateRecipeSavedFlag](update-recipe-saved-flag.md) | [androidJvm]<br>abstract suspend fun [updateRecipeSavedFlag](update-recipe-saved-flag.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
