//[app](../../../index.md)/[com.yuriikonovalov.recipeapp](../index.md)/[RecipeApp](index.md)

# RecipeApp

[androidJvm]\
class [RecipeApp](index.md) : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html), [Configuration.Provider](https://developer.android.com/reference/kotlin/androidx/work/Configuration.Provider.html)

The main class of the application.

## Constructors

| | |
|---|---|
| [RecipeApp](-recipe-app.md) | [androidJvm]<br>fun [RecipeApp](-recipe-app.md)() |

## Functions

| Name | Summary |
|---|---|
| [getWorkManagerConfiguration](get-work-manager-configuration.md) | [androidJvm]<br>open override fun [getWorkManagerConfiguration](get-work-manager-configuration.md)(): [Configuration](https://developer.android.com/reference/kotlin/androidx/work/Configuration.html)<br>A method that builds a [Configuration](https://developer.android.com/reference/kotlin/androidx/work/Configuration.html) object which is used to customize WorkManager upon initialization. |
| [onCreate](on-create.md) | [androidJvm]<br>open override fun [onCreate](on-create.md)() |

## Properties

| Name | Summary |
|---|---|
| [workerFactory](worker-factory.md) | [androidJvm]<br>@Inject<br>lateinit var [workerFactory](worker-factory.md): [HiltWorkerFactory](https://developer.android.com/reference/kotlin/androidx/hilt/work/HiltWorkerFactory.html)<br>A variable that contains a reference to WorkerFactory. |
