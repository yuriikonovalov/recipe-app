//[app](../../index.md)/[com.yuriikonovalov.recipeapp.util](index.md)/[collectEvent](collect-event.md)

# collectEvent

[androidJvm]\
inline fun &lt;[T](collect-event.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).[collectEvent](collect-event.md)(eventFlow: StateFlow&lt;[T](collect-event.md)?&gt;, crossinline eventConsumer: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), crossinline onCollect: (value: [T](collect-event.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Launches collecting of an [eventFlow](collect-event.md) value in a coroutine scope that respects lifecycle behavior of the receiver. Also performs a passed [eventConsumer](collect-event.md) function after collection.

The actions on collected values are defined by a [onCollect](collect-event.md) function.

#### Receiver

an instance of [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).

#### Parameters

androidJvm

| | |
|---|---|
| eventFlow | StateFlow that emits values. |
| onCollect | a function that accepts a value emitted by the [eventFlow](collect-event.md). |
| eventConsumer | a function that will be invoked after [onCollect](collect-event.md) is done. |
