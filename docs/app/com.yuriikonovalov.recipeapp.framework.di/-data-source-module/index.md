//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.di](../index.md)/[DataSourceModule](index.md)

# DataSourceModule

[androidJvm]\
@Module

abstract class [DataSourceModule](index.md)

Orchestrates dependency inject for local, remote data sources and a preference data store.

## Constructors

| | |
|---|---|
| [DataSourceModule](-data-source-module.md) | [androidJvm]<br>fun [DataSourceModule](-data-source-module.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [binDateProvider](bin-date-provider.md) | [androidJvm]<br>@Binds<br>abstract fun [binDateProvider](bin-date-provider.md)(impl: [DateProviderImpl](../../com.yuriikonovalov.recipeapp.framework.data.local/-date-provider-impl/index.md)): [DateProvider](../../com.yuriikonovalov.recipeapp.data.local/-date-provider/index.md) |
| [bindPreferenceDataStore](bind-preference-data-store.md) | [androidJvm]<br>@Binds<br>abstract fun [bindPreferenceDataStore](bind-preference-data-store.md)(impl: [PreferenceDataStoreImpl](../../com.yuriikonovalov.recipeapp.framework.data.local.preferences/-preference-data-store-impl/index.md)): [PreferenceDataStore](../../com.yuriikonovalov.recipeapp.data.local/-preference-data-store/index.md) |
| [bindRecipeLocalDataSource](bind-recipe-local-data-source.md) | [androidJvm]<br>@Binds<br>abstract fun [bindRecipeLocalDataSource](bind-recipe-local-data-source.md)(impl: [RecipeLocalDataSourceImpl](../../com.yuriikonovalov.recipeapp.framework.data.local.database/-recipe-local-data-source-impl/index.md)): [RecipeLocalDataSource](../../com.yuriikonovalov.recipeapp.data.local/-recipe-local-data-source/index.md) |
| [bindRecipeRemoteDataSource](bind-recipe-remote-data-source.md) | [androidJvm]<br>@Binds<br>abstract fun [bindRecipeRemoteDataSource](bind-recipe-remote-data-source.md)(impl: [RecipeRemoteDataSourceImpl](../../com.yuriikonovalov.recipeapp.framework.data.remote/-recipe-remote-data-source-impl/index.md)): [RecipeRemoteDataSource](../../com.yuriikonovalov.recipeapp.data.remote/-recipe-remote-data-source/index.md) |
