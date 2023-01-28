//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database](../index.md)/[RecipeLocalDataSourceImpl](index.md)

# RecipeLocalDataSourceImpl

[androidJvm]\
class [RecipeLocalDataSourceImpl](index.md)@Injectconstructor(dao: [RecipeDao](../../com.yuriikonovalov.recipeapp.framework.data.local.database.dao/-recipe-dao/index.md), mapper: [MapperDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-mapper-db/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;) : [RecipeLocalDataSource](../../com.yuriikonovalov.recipeapp.data.local/-recipe-local-data-source/index.md)

Implementation of [RecipeLocalDataSource](../../com.yuriikonovalov.recipeapp.data.local/-recipe-local-data-source/index.md).

## Constructors

| | |
|---|---|
| [RecipeLocalDataSourceImpl](-recipe-local-data-source-impl.md) | [androidJvm]<br>@Inject<br>fun [RecipeLocalDataSourceImpl](-recipe-local-data-source-impl.md)(dao: [RecipeDao](../../com.yuriikonovalov.recipeapp.framework.data.local.database.dao/-recipe-dao/index.md), mapper: [MapperDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-mapper-db/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [deleteCacheRecipes](delete-cache-recipes.md) | [androidJvm]<br>open suspend override fun [deleteCacheRecipes](delete-cache-recipes.md)() |
| [deleteNeedlessRecipes](delete-needless-recipes.md) | [androidJvm]<br>open suspend override fun [deleteNeedlessRecipes](delete-needless-recipes.md)() |
| [deleteRecipeById](delete-recipe-by-id.md) | [androidJvm]<br>open suspend override fun [deleteRecipeById](delete-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [getCacheRecipes](get-cache-recipes.md) | [androidJvm]<br>open override fun [getCacheRecipes](get-cache-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt; |
| [getRecipeById](get-recipe-by-id.md) | [androidJvm]<br>open suspend override fun [getRecipeById](get-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)? |
| [getSavedRecipes](get-saved-recipes.md) | [androidJvm]<br>open override fun [getSavedRecipes](get-saved-recipes.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;&gt; |
| [insertRecipe](insert-recipe.md) | [androidJvm]<br>open suspend override fun [insertRecipe](insert-recipe.md)(recipe: [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)) |
| [insertRecipes](insert-recipes.md) | [androidJvm]<br>open suspend override fun [insertRecipes](insert-recipes.md)(recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt;) |
| [observeRecipeById](observe-recipe-by-id.md) | [androidJvm]<br>open override fun [observeRecipeById](observe-recipe-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt; |
| [updateRecipeSavedFlag](update-recipe-saved-flag.md) | [androidJvm]<br>open suspend override fun [updateRecipeSavedFlag](update-recipe-saved-flag.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
