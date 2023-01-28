//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes of the application related to database.

## Types

| Name | Summary |
|---|---|
| [AppDatabase](-app-database/index.md) | [androidJvm]<br>abstract class [AppDatabase](-app-database/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html) |
| [RecipeLocalDataSourceImpl](-recipe-local-data-source-impl/index.md) | [androidJvm]<br>class [RecipeLocalDataSourceImpl](-recipe-local-data-source-impl/index.md)@Injectconstructor(dao: [RecipeDao](../com.yuriikonovalov.recipeapp.framework.data.local.database.dao/-recipe-dao/index.md), mapper: [MapperDb](../com.yuriikonovalov.recipeapp.framework.data.local.database.mapper/-mapper-db/index.md)&lt;[Recipe](../com.yuriikonovalov.recipeapp.application.entities/-recipe/index.md), [AggregateRecipeDb](../com.yuriikonovalov.recipeapp.framework.data.local.database.model.relation/-aggregate-recipe-db/index.md)&gt;) : [RecipeLocalDataSource](../com.yuriikonovalov.recipeapp.data.local/-recipe-local-data-source/index.md)<br>Implementation of [RecipeLocalDataSource](../com.yuriikonovalov.recipeapp.data.local/-recipe-local-data-source/index.md). |
