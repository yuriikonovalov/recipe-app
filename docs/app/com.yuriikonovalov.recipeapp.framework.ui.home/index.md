//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.home](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes of the application related to home feature ui.

## Types

| Name | Summary |
|---|---|
| [HomeFragment](-home-fragment/index.md) | [androidJvm]<br>class [HomeFragment](-home-fragment/index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) |
| [HomeViewModel](-home-view-model/index.md) | [androidJvm]<br>class [HomeViewModel](-home-view-model/index.md)@Injectconstructor(getRandomRecipes: [GetRandomRecipes](../com.yuriikonovalov.recipeapp.application.usecases/-get-random-recipes/index.md), updateRandomRecipes: [UpdateRandomRecipes](../com.yuriikonovalov.recipeapp.application.usecases/-update-random-recipes/index.md), mapper: [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RandomRecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt;, idlingResource: [EspressoIdlingResource](../com.yuriikonovalov.recipeapp.util/-espresso-idling-resource/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the home screen. |
| [RandomRecipeAdapter](-random-recipe-adapter/index.md) | [androidJvm]<br>class [RandomRecipeAdapter](-random-recipe-adapter/index.md)(onRecipeClick: (id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html)&lt;[RandomRecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md), [RandomRecipeAdapter.RecipeViewHolder](-random-recipe-adapter/-recipe-view-holder/index.md)&gt; <br>A custom implementation of [ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter.html) for displaying a list of random recipes. |
