//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.di](../index.md)/[DatabaseModule](index.md)

# DatabaseModule

[androidJvm]\
@Module

object [DatabaseModule](index.md)

Orchestrates dependency inject for a database and DAOs.

## Functions

| Name | Summary |
|---|---|
| [provideDatabase](provide-database.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideDatabase](provide-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [AppDatabase](../../com.yuriikonovalov.recipeapp.framework.data.local.database/-app-database/index.md) |
| [provideRecipeDao](provide-recipe-dao.md) | [androidJvm]<br>@Provides<br>fun [provideRecipeDao](provide-recipe-dao.md)(database: [AppDatabase](../../com.yuriikonovalov.recipeapp.framework.data.local.database/-app-database/index.md)): [RecipeDao](../../com.yuriikonovalov.recipeapp.framework.data.local.database.dao/-recipe-dao/index.md) |
