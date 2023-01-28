//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.mapper](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the api mapper classes.

## Types

| Name | Summary |
|---|---|
| [IngredientMapperApi](-ingredient-mapper-api/index.md) | [androidJvm]<br>class [IngredientMapperApi](-ingredient-mapper-api/index.md)@Injectconstructor : [MapperApi](-mapper-api/index.md)&lt;[ExtendedIngredientApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-extended-ingredient-api/index.md), [Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)&gt; |
| [MapperApi](-mapper-api/index.md) | [androidJvm]<br>interface [MapperApi](-mapper-api/index.md)&lt;[Api](-mapper-api/index.md), [Domain](-mapper-api/index.md)&gt;<br>Defines the interface for classes that are api mappers. |
| [RecipeMapperApi](-recipe-mapper-api/index.md) | [androidJvm]<br>class [RecipeMapperApi](-recipe-mapper-api/index.md)@Injectconstructor(ingredientMapperApi: [MapperApi](-mapper-api/index.md)&lt;[ExtendedIngredientApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-extended-ingredient-api/index.md), [Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)&gt;) : [MapperApi](-mapper-api/index.md)&lt;[RecipeApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-recipe-api/index.md), [Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt; |
| [SearchRecipeMapperApi](-search-recipe-mapper-api/index.md) | [androidJvm]<br>class [SearchRecipeMapperApi](-search-recipe-mapper-api/index.md)@Injectconstructor : [MapperApi](-mapper-api/index.md)&lt;[SearchRecipeApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-api/index.md), [SearchRecipe](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt; |
| [SearchRecipeResponseMapperApi](-search-recipe-response-mapper-api/index.md) | [androidJvm]<br>class [SearchRecipeResponseMapperApi](-search-recipe-response-mapper-api/index.md)@Injectconstructor(searchRecipeMapper: [MapperApi](-mapper-api/index.md)&lt;[SearchRecipeApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-api/index.md), [SearchRecipe](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe/index.md)&gt;) : [MapperApi](-mapper-api/index.md)&lt;[SearchRecipeResponseApi](../com.yuriikonovalov.recipeapp.framework.data.remote.model/-search-recipe-response-api/index.md), [SearchRecipeResponse](../com.yuriikonovalov.recipeapp.application.entities/-search-recipe-response/index.md)&gt; |
