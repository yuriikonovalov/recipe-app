//[app](../../index.md)/[com.yuriikonovalov.recipeapp.util](index.md)/[doOnApplyWindowInsetsCompat](do-on-apply-window-insets-compat.md)

# doOnApplyWindowInsetsCompat

[androidJvm]\
fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[doOnApplyWindowInsetsCompat](do-on-apply-window-insets-compat.md)(f: ([View](https://developer.android.com/reference/kotlin/android/view/View.html), [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html), [InitialPadding](-initial-padding/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Adds system padding with preserving initial padding of the view.

#### Receiver

an instance of [View](https://developer.android.com/reference/kotlin/android/view/View.html) to which insets are applied.

#### Parameters

androidJvm

| | |
|---|---|
| f | a function that accepts [View](https://developer.android.com/reference/kotlin/android/view/View.html), [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html) and [InitialPadding](-initial-padding/index.md) as parameters. |
