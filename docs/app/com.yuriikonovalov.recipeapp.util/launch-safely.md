//[app](../../index.md)/[com.yuriikonovalov.recipeapp.util](index.md)/[launchSafely](launch-safely.md)

# launchSafely

[androidJvm]\
fun [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).[launchSafely](launch-safely.md)(body: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Launches suspend functions in a coroutine scope that respects lifecycle of the receiver.

#### Receiver

an instance of [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).

#### Parameters

androidJvm

| | |
|---|---|
| body | a suspend function that will be performed. |
