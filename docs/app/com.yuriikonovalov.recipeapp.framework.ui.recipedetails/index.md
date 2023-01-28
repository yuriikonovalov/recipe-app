//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.recipedetails](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes of the application related to recipe details feature ui.

## Types

| Name | Summary |
|---|---|
| [IngredientAdapter](-ingredient-adapter/index.md) | [androidJvm]<br>class [IngredientAdapter](-ingredient-adapter/index.md) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[IngredientUi](../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md), [IngredientAdapter.IngredientViewHolder](-ingredient-adapter/-ingredient-view-holder/index.md)&gt; <br>A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of ingredients. |
| [RecipeDetailsFragment](-recipe-details-fragment/index.md) | [androidJvm]<br>class [RecipeDetailsFragment](-recipe-details-fragment/index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) |
| [RecipeDetailsViewModel](-recipe-details-view-model/index.md) | [androidJvm]<br>class [RecipeDetailsViewModel](-recipe-details-view-model/index.md)@AssistedInjectconstructor(@AssistedrecipeId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), saveRecipe: [SaveRecipe](../com.yuriikonovalov.recipeapp.application.usecases/-save-recipe/index.md), unsaveRecipe: [UnsaveRecipe](../com.yuriikonovalov.recipeapp.application.usecases/-unsave-recipe/index.md), getRecipeDetails: [GetRecipeDetails](../com.yuriikonovalov.recipeapp.application.usecases/-get-recipe-details/index.md), recipeMapper: [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt;, espressoIdlingResource: [EspressoIdlingResource](../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the recipe details screen. |
| [SourcePageDialog](-source-page-dialog/index.md) | [androidJvm]<br>class [SourcePageDialog](-source-page-dialog/index.md) : [DialogFragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/DialogFragment.html) |
