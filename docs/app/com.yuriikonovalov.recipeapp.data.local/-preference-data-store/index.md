//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.data.local](../index.md)/[PreferenceDataStore](index.md)

# PreferenceDataStore

[androidJvm]\
interface [PreferenceDataStore](index.md)

Defines the interface for a class that will provide access to app preferences.

## Functions

| Name | Summary |
|---|---|
| [getLastCacheDate](get-last-cache-date.md) | [androidJvm]<br>abstract fun [getLastCacheDate](get-last-cache-date.md)(): Flow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Creates a Flow that emits last cache date as [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
| [updateLastCacheDate](update-last-cache-date.md) | [androidJvm]<br>abstract suspend fun [updateLastCacheDate](update-last-cache-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Update last cache date with the given [date](update-last-cache-date.md). |

## Inheritors

| Name |
|---|
| [PreferenceDataStoreImpl](../../com.yuriikonovalov.recipeapp.framework.data.local.preferences/-preference-data-store-impl/index.md) |
