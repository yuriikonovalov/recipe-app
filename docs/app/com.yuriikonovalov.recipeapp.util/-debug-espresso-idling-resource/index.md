//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.util](../index.md)/[DebugEspressoIdlingResource](index.md)

# DebugEspressoIdlingResource

[androidJvm]\
object [DebugEspressoIdlingResource](index.md) : [EspressoIdlingResource](../-espresso-idling-resource/index.md)

This is a debug version of Espresso idling resource object.

This object will be used during ui tests.

## Functions

| Name | Summary |
|---|---|
| [decrement](decrement.md) | [androidJvm]<br>open override fun [decrement](decrement.md)()<br>Decreases a counter in the Espresso idling resource object by 1. |
| [increment](increment.md) | [androidJvm]<br>open override fun [increment](increment.md)()<br>Increases a counter in the Espresso idling resource object by 1. |

## Properties

| Name | Summary |
|---|---|
| [instance](instance.md) | [androidJvm]<br>open override val [instance](instance.md): [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html)<br>A reference to the object that keeps track of idling and working resources. |
