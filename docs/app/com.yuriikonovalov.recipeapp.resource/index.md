//[app](../../index.md)/[com.yuriikonovalov.recipeapp.resource](index.md)

# Package-level declarations

[androidJvm]\
Contains resource pattern classes.

## Types

| Name | Summary |
|---|---|
| [ApiException](-api-exception/index.md) | [androidJvm]<br>class [ApiException](-api-exception/index.md)(val code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html) |
| [NoConnectionException](-no-connection-exception/index.md) | [androidJvm]<br>object [NoConnectionException](-no-connection-exception/index.md) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html) |
| [Resource](-resource/index.md) | [androidJvm]<br>sealed class [Resource](-resource/index.md)&lt;[T](-resource/index.md)&gt;<br>A wrapper class for results of performing resource related operations such as retrieving data, storing, deleting, etc. |
| [ResourceError](-resource-error/index.md) | [androidJvm]<br>interface [ResourceError](-resource-error/index.md)<br>This is a sealed interface that defines types of possible resource errors. |
| [UnexpectedException](-unexpected-exception/index.md) | [androidJvm]<br>class [UnexpectedException](-unexpected-exception/index.md)(val exception: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html) |

## Functions

| Name | Summary |
|---|---|
| [mapRemoteToDomainException](map-remote-to-domain-exception.md) | [androidJvm]<br>fun [mapRemoteToDomainException](map-remote-to-domain-exception.md)(remoteException: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), httpExceptionsMapper: (HttpException) -&gt; [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)? = { null }): [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)<br>Transforms an accepted general Exception to a custom one. |
| [onFailure](on-failure.md) | [androidJvm]<br>fun &lt;[T](on-failure.md)&gt; [Resource](-resource/index.md)&lt;[T](on-failure.md)&gt;.[onFailure](on-failure.md)(action: (resourceError: [ResourceError](-resource-error/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>An extension function that performs an [action](on-failure.md) if the type of the receiver is [Resource.Failure](-resource/-failure/index.md). |
| [onSuccess](on-success.md) | [androidJvm]<br>fun &lt;[T](on-success.md)&gt; [Resource](-resource/index.md)&lt;[T](on-success.md)&gt;.[onSuccess](on-success.md)(action: (data: [T](on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>An extension function that performs an [action](on-success.md) if the type of the receiver is [Resource.Success](-resource/-success/index.md). |
