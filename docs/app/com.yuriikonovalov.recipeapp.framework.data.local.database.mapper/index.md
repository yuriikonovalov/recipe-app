//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.mapper](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the db mapper classes.

## Types

| Name | Summary |
|---|---|
| [AggregateRecipeDbMapper](-aggregate-recipe-db-mapper/index.md) | [androidJvm]<br>class [AggregateRecipeDbMapper](-aggregate-recipe-db-mapper/index.md)@Injectconstructor(ingredientDbMapper: [MapperDb](-mapper-db/index.md)&lt;[Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;) : [MapperDb](-mapper-db/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt; |
| [IngredientDbMapper](-ingredient-db-mapper/index.md) | [androidJvm]<br>class [IngredientDbMapper](-ingredient-db-mapper/index.md)@Injectconstructor : [MapperDb](-mapper-db/index.md)&lt;[Ingredient](../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt; |
| [MapperDb](-mapper-db/index.md) | [androidJvm]<br>interface [MapperDb](-mapper-db/index.md)&lt;[Domain](-mapper-db/index.md), [Db](-mapper-db/index.md)&gt;<br>Defines the interface for classes that are db mappers. |
