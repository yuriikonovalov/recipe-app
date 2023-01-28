package com.yuriikonovalov.recipeapp.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/**
 * Adds top system padding to a view with preserving initial padding.
 * @param targetView a view to which system top padding will be applied.
 * @receiver an instance of parent [View] of the target view.
 */
fun View.addSystemTopPadding(
    targetView: View = this,
) {
    doOnApplyWindowInsetsCompat { _, insets, initialPadding ->
        targetView.updatePadding(
            top = initialPadding.top + insets.systemBars.top
        )
    }
}

/**
 * Adds system padding with preserving initial padding of the view.
 * @param f a function that accepts [View], [WindowInsetsCompat] and [InitialPadding] as parameters.
 * @receiver an instance of [View] to which insets are applied.
 */
fun View.doOnApplyWindowInsetsCompat(f: (View, WindowInsetsCompat, InitialPadding) -> Unit) {
    // Create a snapshot of the view's padding state
    val initialPadding = recordInitialPaddingForView(this)
    // Set an actual OnApplyWindowInsetsListener which proxies to the given
    // lambda, also passing in the original padding state
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        f(v, insets, initialPadding)
        // Always return the insets, so that children can also use them
        insets
    }
    // request some insets
    requestApplyInsetsWhenAttached()
}

/**
 * A wrapper of the initial padding values of a view.
 * @constructor Creates an instance of [InitialPadding] using given [left], [right], [top], [bottom] values.
 * @property left left padding.
 * @property right right padding.
 * @property top top padding.
 * @property bottom bottom padding.
 */
data class InitialPadding(
    val left: Int, val top: Int,
    val right: Int, val bottom: Int,
)

/**
 * Creates an instance of [InitialPadding] from the given [view].
 * @param view a view which padding values will be wrapped in an [InitialPadding] instance.
 * @return an instance of [InitialPadding]
 */
private fun recordInitialPaddingForView(view: View) = InitialPadding(
    view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom
)

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to
        // request when we are
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

/**
 * System bars insets.
 */
val WindowInsetsCompat.systemBars
    get() = this.getInsets(WindowInsetsCompat.Type.systemBars())

/**
 * Status bar insets.
 */
val WindowInsetsCompat.statusBar
    get() = this.getInsets(WindowInsetsCompat.Type.statusBars())

/**
 * Navigation bar insets.
 */
val WindowInsetsCompat.navigationBars
    get() = this.getInsets(WindowInsetsCompat.Type.navigationBars())

/**
 * IME insets.
 */
val WindowInsetsCompat.ime
    get() = this.getInsets(WindowInsetsCompat.Type.ime())
