//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.di](../index.md)/[MapperModule](index.md)

# MapperModule

[androidJvm]\
@Module

abstract class [MapperModule](index.md)

Orchestrates dependency inject for mappers.

## Constructors

| | |
|---|---|
| [MapperModule](-mapper-module.md) | [androidJvm]<br>fun [MapperModule](-mapper-module.md)() |

## Functions

| Name | Summary |
|---|---|
| [bindAggregateRecipeDbMapper](bind-aggregate-recipe-db-mapper.md) | [androidJvm]<br>@Binds<br>abstract fun [bindAggregateRecipeDbMapper](bind-aggregate-recipe-db-mapper.md)(impl: [AggregateRecipeDbMapper](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-aggregate-recipe-db-mapper/index.md)): [MapperDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-mapper-db/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt; |
| [bindIngredientDbMapper](bind-ingredient-db-mapper.md) | [androidJvm]<br>@Binds<br>abstract fun [bindIngredientDbMapper](bind-ingredient-db-mapper.md)(impl: [IngredientDbMapper](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-ingredient-db-mapper/index.md)): [MapperDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-mapper-db/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt; |
| [bindIngredientMapperApi](bind-ingredient-mapper-api.md) | [androidJvm]<br>@Binds<br>abstract fun [bindIngredientMapperApi](bind-ingredient-mapper-api.md)(impl: [IngredientMapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-ingredient-mapper-api/index.md)): [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[ExtendedIngredientApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-extended-ingredient-api/index.md), [Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)&gt; |
| [bindIngredientMapperUi](bind-ingredient-mapper-ui.md) | [androidJvm]<br>@Binds<br>abstract fun [bindIngredientMapperUi](bind-ingredient-mapper-ui.md)(impl: [IngredientMapperUi](../../com.yuriikonovalov.recipeapp.framework.ui.mapper/-ingredient-mapper-ui/index.md)): [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientUi](../../com.yuriikonovalov.recipeapp.presentation.model/-ingredient-ui/index.md)&gt; |
| [bindRandomRecipeMapperUi](bind-random-recipe-mapper-ui.md) | [androidJvm]<br>@Binds<br>abstract fun [bindRandomRecipeMapperUi](bind-random-recipe-mapper-ui.md)(impl: [RandomRecipeMapperUi](../../com.yuriikonovalov.recipeapp.framework.ui.mapper/-random-recipe-mapper-ui/index.md)): [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RandomRecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt; |
| [bindRecipeMapperApi](bind-recipe-mapper-api.md) | [androidJvm]<br>@Binds<br>abstract fun [bindRecipeMapperApi](bind-recipe-mapper-api.md)(impl: [RecipeMapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-recipe-mapper-api/index.md)): [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[RecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md), [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt; |
| [bindRecipeMapperUi](bind-recipe-mapper-ui.md) | [androidJvm]<br>@Binds<br>abstract fun [bindRecipeMapperUi](bind-recipe-mapper-ui.md)(impl: [RecipeMapperUi](../../com.yuriikonovalov.recipeapp.framework.ui.mapper/-recipe-mapper-ui/index.md)): [MapperUi](../../com.yuriikonovalov.recipeapp.presentation/-mapper-ui/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [RecipeUi](../../com.yuriikonovalov.recipeapp.presentation.model/-recipe-ui/index.md)&gt; |
| [bindSearchRecipeMapperApi](bind-search-recipe-mapper-api.md) | [androidJvm]<br>@Binds<br>abstract fun [bindSearchRecipeMapperApi](bind-search-recipe-mapper-api.md)(impl: [SearchRecipeMapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-search-recipe-mapper-api/index.md)): [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[SearchRecipeApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-api/index.md), [SearchRecipe](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt; |
| [bindSearchRecipeResponseMapperApi](bind-search-recipe-response-mapper-api.md) | [androidJvm]<br>@Binds<br>abstract fun [bindSearchRecipeResponseMapperApi](bind-search-recipe-response-mapper-api.md)(impl: [SearchRecipeResponseMapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-search-recipe-response-mapper-api/index.md)): [MapperApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.mapper/-mapper-api/index.md)&lt;[SearchRecipeResponseApi](../../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md), [SearchRecipeResponse](../../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)&gt; |
