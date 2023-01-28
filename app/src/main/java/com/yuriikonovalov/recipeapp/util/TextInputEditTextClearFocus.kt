package com.yuriikonovalov.recipeapp.util

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


/**
 * This is a custom text field that is based on [TextInputEditText].
 * The difference between [TextInputEditText] and this one is that
 * it tracks key events and IME actions and clear focus when KeyEvent.KEYCODE_BACK
 * or EditorInfo.IME_ACTION_DONE happens.
 *
 * @constructor Creates a new instance of [TextInputEditTextClearFocus] using context.
 */
class TextInputEditTextClearFocus @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TextInputEditText(context, attrs), TextView.OnEditorActionListener {

    init {
        setOnEditorActionListener(this)
    }

    // Handles on 'Back'/'Hide' button click
    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clearFocus()
        }
        return super.onKeyPreIme(keyCode, event)
    }

    // Handles on 'Done' button click
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            clearFocus()
        }
        return false
    }
}