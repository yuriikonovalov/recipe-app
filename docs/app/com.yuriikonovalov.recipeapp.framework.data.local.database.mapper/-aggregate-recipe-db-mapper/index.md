//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.mapper](../index.md)/[AggregateRecipeDbMapper](index.md)

# AggregateRecipeDbMapper

[androidJvm]\
class [AggregateRecipeDbMapper](index.md)@Injectconstructor(ingredientDbMapper: [MapperDb](../-mapper-db/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;) : [MapperDb](../-mapper-db/index.md)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;

## Constructors

| | |
|---|---|
| [AggregateRecipeDbMapper](-aggregate-recipe-db-mapper.md) | [androidJvm]<br>@Inject<br>fun [AggregateRecipeDbMapper](-aggregate-recipe-db-mapper.md)(ingredientDbMapper: [MapperDb](../-mapper-db/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [mapFromDomain](map-from-domain.md) | [androidJvm]<br>open override fun [mapFromDomain](map-from-domain.md)(domain: [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)): [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md) |
| [mapToDomain](map-to-domain.md) | [androidJvm]<br>open override fun [mapToDomain](map-to-domain.md)(db: [AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)): [Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)<br>open override fun [mapToDomain](map-to-domain.md)(dbList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[AggregateRecipeDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md)&gt; |
