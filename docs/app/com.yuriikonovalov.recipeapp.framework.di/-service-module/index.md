//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.di](../index.md)/[ServiceModule](index.md)

# ServiceModule

[androidJvm]\
@Module

object [ServiceModule](index.md)

Orchestrates dependency inject for a remote service and http client.

## Functions

| Name | Summary |
|---|---|
| [provideHttpClient](provide-http-client.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideHttpClient](provide-http-client.md)(): OkHttpClient |
| [provideRecipeService](provide-recipe-service.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideRecipeService](provide-recipe-service.md)(okHttpClient: OkHttpClient): [RecipeService](../../com.yuriikonovalov.recipeapp.framework.data.remote.service/-recipe-service/index.md) |
