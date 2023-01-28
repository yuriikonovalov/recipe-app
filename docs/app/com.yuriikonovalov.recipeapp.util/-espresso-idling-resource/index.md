//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.util](../index.md)/[EspressoIdlingResource](index.md)

# EspressoIdlingResource

[androidJvm]\
interface [EspressoIdlingResource](index.md)

This is an interface that is used for creating an Espresso idling resource object which is used in ui tests.

## Functions

| Name | Summary |
|---|---|
| [decrement](decrement.md) | [androidJvm]<br>abstract fun [decrement](decrement.md)()<br>Decreases a counter in the Espresso idling resource object by 1. |
| [increment](increment.md) | [androidJvm]<br>abstract fun [increment](increment.md)()<br>Increases a counter in the Espresso idling resource object by 1. |

## Properties

| Name | Summary |
|---|---|
| [instance](instance.md) | [androidJvm]<br>abstract val [instance](instance.md): [IdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/IdlingResource.html)<br>A reference to the object that keeps track of idling and working resources. |

## Inheritors

| Name |
|---|
| [DebugEspressoIdlingResource](../-debug-espresso-idling-resource/index.md) |
