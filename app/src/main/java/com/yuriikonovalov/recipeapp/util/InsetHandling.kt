package com.yuriikonovalov.recipeapp.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

fun View.addSystemTopPadding(
    targetView: View = this,
) {
    doOnApplyWindowInsetsCompat { _, insets, initialPadding ->
        targetView.updatePadding(
            top = initialPadding.top + insets.systemBars.top
        )
    }
}

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

data class InitialPadding(
    val left: Int, val top: Int,
    val right: Int, val bottom: Int,
)

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

val WindowInsetsCompat.systemBars
    get() = this.getInsets(WindowInsetsCompat.Type.systemBars())

val WindowInsetsCompat.statusBar
    get() = this.getInsets(WindowInsetsCompat.Type.statusBars())

val WindowInsetsCompat.navigationBars
    get() = this.getInsets(WindowInsetsCompat.Type.navigationBars())

val WindowInsetsCompat.ime
    get() = this.getInsets(WindowInsetsCompat.Type.ime())
