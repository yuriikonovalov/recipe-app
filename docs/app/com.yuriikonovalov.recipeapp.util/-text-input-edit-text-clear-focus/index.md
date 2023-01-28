//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.util](../index.md)/[TextInputEditTextClearFocus](index.md)

# TextInputEditTextClearFocus

[androidJvm]\
class [TextInputEditTextClearFocus](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) : TextInputEditText, [TextView.OnEditorActionListener](https://developer.android.com/reference/kotlin/android/widget/TextView.OnEditorActionListener.html)

This is a custom text field that is based on TextInputEditText. The difference between TextInputEditText and this one is that it tracks key events and IME actions and clear focus when KeyEvent.KEYCODE_BACK or EditorInfo.IME_ACTION_DONE happens.

## Constructors

| | |
|---|---|
| [TextInputEditTextClearFocus](-text-input-edit-text-clear-focus.md) | [androidJvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [TextInputEditTextClearFocus](-text-input-edit-text-clear-focus.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null)<br>Creates a new instance of [TextInputEditTextClearFocus](index.md) using context. |

## Functions

| Name | Summary |
|---|---|
| [onEditorAction](on-editor-action.md) | [androidJvm]<br>open override fun [onEditorAction](on-editor-action.md)(v: [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html)?, actionId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onKeyPreIme](on-key-pre-ime.md) | [androidJvm]<br>open override fun [onKeyPreIme](on-key-pre-ime.md)(keyCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
