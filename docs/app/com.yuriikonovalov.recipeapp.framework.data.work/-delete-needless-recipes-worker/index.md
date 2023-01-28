//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.work](../index.md)/[DeleteNeedlessRecipesWorker](index.md)

# DeleteNeedlessRecipesWorker

[androidJvm]\
class [DeleteNeedlessRecipesWorker](index.md)@AssistedInjectconstructor(@Assistedcontext: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), @AssistedworkerParams: [WorkerParameters](https://developer.android.com/reference/kotlin/androidx/work/WorkerParameters.html), deleteNeedlessRecipes: [DeleteNeedlessRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-delete-needless-recipes/index.md)) : [CoroutineWorker](https://developer.android.com/reference/kotlin/androidx/work/CoroutineWorker.html)

A custom implementation of [CoroutineWorker](https://developer.android.com/reference/kotlin/androidx/work/CoroutineWorker.html) for a [DeleteNeedlessRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-delete-needless-recipes/index.md) use case.

## Constructors

| | |
|---|---|
| [DeleteNeedlessRecipesWorker](-delete-needless-recipes-worker.md) | [androidJvm]<br>@AssistedInject<br>fun [DeleteNeedlessRecipesWorker](-delete-needless-recipes-worker.md)(@Assistedcontext: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), @AssistedworkerParams: [WorkerParameters](https://developer.android.com/reference/kotlin/androidx/work/WorkerParameters.html), deleteNeedlessRecipes: [DeleteNeedlessRecipes](../../com.yuriikonovalov.recipeapp.application.usecases/-delete-needless-recipes/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [doWork](do-work.md) | [androidJvm]<br>open suspend override fun [doWork](do-work.md)(): [ListenableWorker.Result](https://developer.android.com/reference/kotlin/androidx/work/ListenableWorker.Result.html) |
