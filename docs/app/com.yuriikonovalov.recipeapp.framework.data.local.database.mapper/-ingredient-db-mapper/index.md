//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.mapper](../index.md)/[IngredientDbMapper](index.md)

# IngredientDbMapper

[androidJvm]\
class [IngredientDbMapper](index.md)@Injectconstructor : [MapperDb](../-mapper-db/index.md)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md), [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;

## Constructors

| | |
|---|---|
| [IngredientDbMapper](-ingredient-db-mapper.md) | [androidJvm]<br>@Inject<br>fun [IngredientDbMapper](-ingredient-db-mapper.md)() |

## Functions

| Name | Summary |
|---|---|
| [mapFromDomain](map-from-domain.md) | [androidJvm]<br>open override fun [mapFromDomain](map-from-domain.md)(domain: [Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)): [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md) |
| [mapToDomain](map-to-domain.md) | [androidJvm]<br>open override fun [mapToDomain](map-to-domain.md)(db: [IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)): [Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)<br>open override fun [mapToDomain](map-to-domain.md)(dbList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[IngredientDb](../../com.yuriikonovalov.recipeapp.framework.data.local.database.model/-ingredient-db/index.md)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Ingredient](../../com.yuriikonovalov.recipeapp.application.entities/-ingredient/index.md)&gt; |
