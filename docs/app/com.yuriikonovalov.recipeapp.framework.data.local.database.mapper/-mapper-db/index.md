//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.mapper](../index.md)/[MapperDb](index.md)

# MapperDb

[androidJvm]\
interface [MapperDb](index.md)&lt;[Domain](index.md), [Db](index.md)&gt;

Defines the interface for classes that are db mappers.

## Functions

| Name | Summary |
|---|---|
| [mapFromDomain](map-from-domain.md) | [androidJvm]<br>abstract fun [mapFromDomain](map-from-domain.md)(domain: [Domain](index.md)): [Db](index.md) |
| [mapToDomain](map-to-domain.md) | [androidJvm]<br>abstract fun [mapToDomain](map-to-domain.md)(db: [Db](index.md)): [Domain](index.md)<br>abstract fun [mapToDomain](map-to-domain.md)(dbList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Db](index.md)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Domain](index.md)&gt; |

## Inheritors

| Name |
|---|
| [AggregateRecipeDbMapper](../-aggregate-recipe-db-mapper/index.md) |
| [IngredientDbMapper](../-ingredient-db-mapper/index.md) |
