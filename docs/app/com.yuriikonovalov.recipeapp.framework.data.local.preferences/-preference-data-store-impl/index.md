//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.preferences](../index.md)/[PreferenceDataStoreImpl](index.md)

# PreferenceDataStoreImpl

[androidJvm]\
class [PreferenceDataStoreImpl](index.md)@Injectconstructor(preferenceDataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;) : [PreferenceDataStore](../../com.yuriikonovalov.recipeapp.data.local/-preference-data-store/index.md)

## Constructors

| | |
|---|---|
| [PreferenceDataStoreImpl](-preference-data-store-impl.md) | [androidJvm]<br>@Inject<br>fun [PreferenceDataStoreImpl](-preference-data-store-impl.md)(preferenceDataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [getLastCacheDate](get-last-cache-date.md) | [androidJvm]<br>open override fun [getLastCacheDate](get-last-cache-date.md)(): Flow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Creates a Flow that emits last cache date as [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
| [updateLastCacheDate](update-last-cache-date.md) | [androidJvm]<br>open suspend override fun [updateLastCacheDate](update-last-cache-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Update last cache date with the given [date](update-last-cache-date.md). |
