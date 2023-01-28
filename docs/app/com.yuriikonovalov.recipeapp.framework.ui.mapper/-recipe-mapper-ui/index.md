//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.mapper](../index.md)/[RecipeMapperUi](index.md)

# RecipeMapperUi

[androidJvm]\
class [RecipeMapperUi](index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), ingredientMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientUi](../../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md)&gt;) : [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; 

This is a UI mapper between [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md) and [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md).

## Constructors

| | |
|---|---|
| [RecipeMapperUi](-recipe-mapper-ui.md) | [androidJvm]<br>@Inject<br>fun [RecipeMapperUi](-recipe-mapper-ui.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), ingredientMapper: [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientUi](../../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [mapToUi](map-to-ui.md) | [androidJvm]<br>open override fun [mapToUi](map-to-ui.md)(domain: [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)): [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md) |
