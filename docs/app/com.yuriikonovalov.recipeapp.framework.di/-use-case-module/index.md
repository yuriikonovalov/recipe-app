//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.di](../index.md)/[UseCaseModule](index.md)

# UseCaseModule

[androidJvm]\
@Module

abstract class [UseCaseModule](index.md)

Orchestrates dependency inject for use cases.

## Constructors

| | |
|---|---|
| [UseCaseModule](-use-case-module.md) | [androidJvm]<br>fun [UseCaseModule](-use-case-module.md)() |

## Functions

| Name | Summary |
|---|---|
| [bindDeleteNeedlessRecipes](bind-delete-needless-recipes.md) | [androidJvm]<br>@Binds<br>abstract fun [bindDeleteNeedlessRecipes](bind-delete-needless-recipes.md)(impl: [DeleteNeedlessRecipesImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-delete-needless-recipes-impl/index.md)): [DeleteNeedlessRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-delete-needless-recipes/index.md) |
| [bindGetRandomRecipes](bind-get-random-recipes.md) | [androidJvm]<br>@Binds<br>abstract fun [bindGetRandomRecipes](bind-get-random-recipes.md)(impl: [GetRandomRecipesImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-get-random-recipes-impl/index.md)): [GetRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-random-recipes/index.md) |
| [bindGetRecipeDetails](bind-get-recipe-details.md) | [androidJvm]<br>@Binds<br>abstract fun [bindGetRecipeDetails](bind-get-recipe-details.md)(impl: [GetRecipeDetailsImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-get-recipe-details-impl/index.md)): [GetRecipeDetails](../../com.yuriikonovalov.recipeapp.application.usecases/-get-recipe-details/index.md) |
| [bindGetSavedRecipes](bind-get-saved-recipes.md) | [androidJvm]<br>@Binds<br>abstract fun [bindGetSavedRecipes](bind-get-saved-recipes.md)(impl: [GetSavedRecipesImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-get-saved-recipes-impl/index.md)): [GetSavedRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-get-saved-recipes/index.md) |
| [bindSaveRecipe](bind-save-recipe.md) | [androidJvm]<br>@Binds<br>abstract fun [bindSaveRecipe](bind-save-recipe.md)(impl: [SaveRecipeImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-save-recipe-impl/index.md)): [SaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-save-recipe/index.md) |
| [bindSearchRecipes](bind-search-recipes.md) | [androidJvm]<br>@Binds<br>abstract fun [bindSearchRecipes](bind-search-recipes.md)(impl: [SearchRecipesImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-search-recipes-impl/index.md)): [SearchRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-search-recipes/index.md) |
| [bindUnsaveRecipe](bind-unsave-recipe.md) | [androidJvm]<br>@Binds<br>abstract fun [bindUnsaveRecipe](bind-unsave-recipe.md)(impl: [UnsaveRecipeImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe-impl/index.md)): [UnsaveRecipe](../../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md) |
| [bindUpdateRandomRecipes](bind-update-random-recipes.md) | [androidJvm]<br>@Binds<br>abstract fun [bindUpdateRandomRecipes](bind-update-random-recipes.md)(impl: [UpdateRandomRecipesImpl](../../com.yuriikonovalov.recipeapp.application.usecases/-update-random-recipes-impl/index.md)): [UpdateRandomRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-update-random-recipes/index.md) |
