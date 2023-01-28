//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.ui.mapper](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the ui mapper classes.

## Types

| Name | Summary |
|---|---|
| [IngredientMapperUi](-ingredient-mapper-ui/index.md) | [androidJvm]<br>class [IngredientMapperUi](-ingredient-mapper-ui/index.md)@Injectconstructor : [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientUi](../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md)&gt; <br>This is a UI mapper between [IngredientUi](../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md) and [Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md). |
| [RandomRecipeMapperUi](-random-recipe-mapper-ui/index.md) | [androidJvm]<br>class [RandomRecipeMapperUi](-random-recipe-mapper-ui/index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RandomRecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt; <br>This is a UI mapper between [RandomRecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md) and [Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md). |
| [RecipeMapperUi](-recipe-mapper-ui/index.md) | [androidJvm]<br>class [RecipeMapperUi](-recipe-mapper-ui/index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), ingredientMapper: [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientUi](../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md)&gt;) : [MapperUi](../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; <br>This is a UI mapper between [RecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md) and [Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md). |
