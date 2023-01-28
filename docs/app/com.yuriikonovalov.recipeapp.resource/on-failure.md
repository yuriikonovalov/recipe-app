//[app](../../index.md)/[com.yuriikonovalov.recipeapp.resource](index.md)/[onFailure](on-failure.md)

# onFailure

[androidJvm]\
fun &lt;[T](on-failure.md)&gt; [Resource](-resource/index.md)&lt;[T](on-failure.md)&gt;.[onFailure](on-failure.md)(action: (resourceError: [ResourceError](-resource-error/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

An extension function that performs an [action](on-failure.md) if the type of the receiver is [Resource.Failure](-resource/-failure/index.md).

#### Receiver

an instance of [Resource](-resource/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| action | a function that accepts a [ResourceError](-resource-error/index.md) passed back after failed performing. |
