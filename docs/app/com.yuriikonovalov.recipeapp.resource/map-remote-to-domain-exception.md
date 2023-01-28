//[app](../../index.md)/[com.yuriikonovalov.recipeapp.resource](index.md)/[mapRemoteToDomainException](map-remote-to-domain-exception.md)

# mapRemoteToDomainException

[androidJvm]\
fun [mapRemoteToDomainException](map-remote-to-domain-exception.md)(remoteException: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), httpExceptionsMapper: (HttpException) -&gt; [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)? = { null }): [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)

Transforms an accepted general Exception to a custom one.

#### Return

an instance of one of the domain exceptions.

#### See also

androidJvm

| | |
|---|---|
| [ApiException](-api-exception/index.md) | . |
| [NoConnectionException](-no-connection-exception/index.md) | . |
| [UnexpectedException](-unexpected-exception/index.md) | . |

#### Parameters

androidJvm

| | |
|---|---|
| remoteException | [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) that has been thrown during triggering remote services. |
| httpExceptionsMapper | a function that is a custom mapper for a [remoteException](map-remote-to-domain-exception.md) when it's an instance of HttpException. It's null by default. |
