//[app](../../index.md)/[com.yuriikonovalov.recipeapp.util](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the util classes of the application.

## Types

| Name | Summary |
|---|---|
| [AdaptiveNavUtils](-adaptive-nav-utils/index.md) | [androidJvm]<br>object [AdaptiveNavUtils](-adaptive-nav-utils/index.md)<br>This is an object that contains methods for updating navigation views depending on the current window size. |
| [DebugEspressoIdlingResource](-debug-espresso-idling-resource/index.md) | [androidJvm]<br>object [DebugEspressoIdlingResource](-debug-espresso-idling-resource/index.md) : [EspressoIdlingResource](-espresso-idling-resource/index.md)<br>This is a debug version of Espresso idling resource object. |
| [EspressoIdlingResource](-espresso-idling-resource/index.md) | [androidJvm]<br>interface [EspressoIdlingResource](-espresso-idling-resource/index.md)<br>This is an interface that is used for creating an Espresso idling resource object which is used in ui tests. |
| [InitialPadding](-initial-padding/index.md) | [androidJvm]<br>data class [InitialPadding](-initial-padding/index.md)(val left: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val top: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val right: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val bottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>A wrapper of the initial padding values of a view. |
| [TextInputEditTextClearFocus](-text-input-edit-text-clear-focus/index.md) | [androidJvm]<br>class [TextInputEditTextClearFocus](-text-input-edit-text-clear-focus/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) : TextInputEditText, [TextView.OnEditorActionListener](https://developer.android.com/reference/kotlin/android/widget/TextView.OnEditorActionListener.html)<br>This is a custom text field that is based on TextInputEditText. The difference between TextInputEditText and this one is that it tracks key events and IME actions and clear focus when KeyEvent.KEYCODE_BACK or EditorInfo.IME_ACTION_DONE happens. |
| [WindowSizeClass](-window-size-class/index.md) | [androidJvm]<br>enum [WindowSizeClass](-window-size-class/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[WindowSizeClass](-window-size-class/index.md)&gt; <br>An enum class of screen categories based on the window size. |

## Functions

| Name | Summary |
|---|---|
| [addSystemTopPadding](add-system-top-padding.md) | [androidJvm]<br>fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[addSystemTopPadding](add-system-top-padding.md)(targetView: [View](https://developer.android.com/reference/kotlin/android/view/View.html) = this)<br>Adds top system padding to a view with preserving initial padding. |
| [collectEvent](collect-event.md) | [androidJvm]<br>inline fun &lt;[T](collect-event.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).[collectEvent](collect-event.md)(eventFlow: StateFlow&lt;[T](collect-event.md)?&gt;, crossinline eventConsumer: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), crossinline onCollect: (value: [T](collect-event.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Launches collecting of an [eventFlow](collect-event.md) value in a coroutine scope that respects lifecycle behavior of the receiver. Also performs a passed [eventConsumer](collect-event.md) function after collection. |
| [computeWidthWindowSizeClass](compute-width-window-size-class.md) | [androidJvm]<br>fun [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html).[computeWidthWindowSizeClass](compute-width-window-size-class.md)(): [WindowSizeClass](-window-size-class/index.md)<br>Calculates the size of the window which the receiver [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html) is attached to. |
| [doOnApplyWindowInsetsCompat](do-on-apply-window-insets-compat.md) | [androidJvm]<br>fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[doOnApplyWindowInsetsCompat](do-on-apply-window-insets-compat.md)(f: ([View](https://developer.android.com/reference/kotlin/android/view/View.html), [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html), [InitialPadding](-initial-padding/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Adds system padding with preserving initial padding of the view. |
| [hideKeyboard](hide-keyboard.md) | [androidJvm]<br>fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[hideKeyboard](hide-keyboard.md)()<br>Hides a previously open keyboard. |
| [launchSafely](launch-safely.md) | [androidJvm]<br>fun [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html).[launchSafely](launch-safely.md)(body: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Launches suspend functions in a coroutine scope that respects lifecycle of the receiver. |
| [requestApplyInsetsWhenAttached](request-apply-insets-when-attached.md) | [androidJvm]<br>fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[requestApplyInsetsWhenAttached](request-apply-insets-when-attached.md)() |
| [roundDecimals](round-decimals.md) | [androidJvm]<br>fun [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html).[roundDecimals](round-decimals.md)(decimals: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Sets a number of decimals of a double to the given number. |

## Properties

| Name | Summary |
|---|---|
| [ime](ime.md) | [androidJvm]<br>val [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html).[ime](ime.md): [Insets](https://developer.android.com/reference/kotlin/androidx/core/graphics/Insets.html)<br>IME insets. |
| [navigationBars](navigation-bars.md) | [androidJvm]<br>val [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html).[navigationBars](navigation-bars.md): [Insets](https://developer.android.com/reference/kotlin/androidx/core/graphics/Insets.html)<br>Navigation bar insets. |
| [statusBar](status-bar.md) | [androidJvm]<br>val [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html).[statusBar](status-bar.md): [Insets](https://developer.android.com/reference/kotlin/androidx/core/graphics/Insets.html)<br>Status bar insets. |
| [systemBars](system-bars.md) | [androidJvm]<br>val [WindowInsetsCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowInsetsCompat.html).[systemBars](system-bars.md): [Insets](https://developer.android.com/reference/kotlin/androidx/core/graphics/Insets.html)<br>System bars insets. |
