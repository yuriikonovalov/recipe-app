//[app](../../index.md)/[com.yuriikonovalov.recipeapp.resource](index.md)/[onSuccess](on-success.md)

# onSuccess

[androidJvm]\
fun &lt;[T](on-success.md)&gt; [Resource](-resource/index.md)&lt;[T](on-success.md)&gt;.[onSuccess](on-success.md)(action: (data: [T](on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

An extension function that performs an [action](on-success.md) if the type of the receiver is [Resource.Success](-resource/-success/index.md).

#### Receiver

an instance of [Resource](-resource/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| action | a function that accepts data passed back after successful performing. |
