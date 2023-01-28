//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.resource](../index.md)/[Resource](index.md)

# Resource

[androidJvm]\
sealed class [Resource](index.md)&lt;[T](index.md)&gt;

A wrapper class for results of performing resource related operations such as retrieving data, storing, deleting, etc.

Based on the result of an operation can be either [Resource.Success](-success/index.md) or [Resource.Failure](-failure/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [Failure](-failure/index.md) | [androidJvm]<br>data class [Failure](-failure/index.md)&lt;[T](-failure/index.md)&gt;(val resourceError: [ResourceError](../-resource-error/index.md)) : [Resource](index.md)&lt;[T](-failure/index.md)&gt; <br>A wrapper class for results of failed operations. |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)&lt;[T](-success/index.md)&gt;(val data: [T](-success/index.md)) : [Resource](index.md)&lt;[T](-success/index.md)&gt; <br>A wrapper class for results of successful operations. |

## Inheritors

| Name |
|---|
| [Success](-success/index.md) |
| [Failure](-failure/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [onFailure](../on-failure.md) | [androidJvm]<br>fun &lt;[T](../on-failure.md)&gt; [Resource](index.md)&lt;[T](../on-failure.md)&gt;.[onFailure](../on-failure.md)(action: (resourceError: [ResourceError](../-resource-error/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>An extension function that performs an [action](../on-failure.md) if the type of the receiver is [Resource.Failure](-failure/index.md). |
| [onSuccess](../on-success.md) | [androidJvm]<br>fun &lt;[T](../on-success.md)&gt; [Resource](index.md)&lt;[T](../on-success.md)&gt;.[onSuccess](../on-success.md)(action: (data: [T](../on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>An extension function that performs an [action](../on-success.md) if the type of the receiver is [Resource.Success](-success/index.md). |
