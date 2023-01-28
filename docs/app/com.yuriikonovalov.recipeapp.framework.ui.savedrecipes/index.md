//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.savedrecipes](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes of the application related to saved recipes feature ui.

## Types

| Name | Summary |
|---|---|
| [RecipeAdapter](-recipe-adapter/index.md) | [androidJvm]<br>class [RecipeAdapter](-recipe-adapter/index.md) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md), [RecipeAdapter.RecipeViewHolder](-recipe-adapter/-recipe-view-holder/index.md)&gt; <br>A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of recipes. |
| [SavedRecipeDetailsFragment](-saved-recipe-details-fragment/index.md) | [androidJvm]<br>class [SavedRecipeDetailsFragment](-saved-recipe-details-fragment/index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) |
| [SavedRecipesFragment](-saved-recipes-fragment/index.md) | [androidJvm]<br>class [SavedRecipesFragment](-saved-recipes-fragment/index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) |
| [SavedRecipesViewModel](-saved-recipes-view-model/index.md) | [androidJvm]<br>class [SavedRecipesViewModel](-saved-recipes-view-model/index.md)@Injectconstructor(getSavedRecipes: [GetSavedRecipes](../com.yuriikonovalov.recipeapp.application.usecases/-get-saved-recipes/index.md), unsaveRecipe: [UnsaveRecipe](../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), recipeMapper: [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the saved recipes screen. |
