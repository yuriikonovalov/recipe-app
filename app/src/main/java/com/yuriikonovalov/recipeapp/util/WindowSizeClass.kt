package com.yuriikonovalov.recipeapp.util

import android.app.Activity
import androidx.window.layout.WindowMetrics
import androidx.window.layout.WindowMetricsCalculator

/**
 * An enum class of screen categories based on the window size.
 */
enum class WindowSizeClass { COMPACT, MEDIUM, EXPANDED }

private fun Activity.computeMetrics(): WindowMetrics {
    return WindowMetricsCalculator.getOrCreate()
        .computeCurrentWindowMetrics(this)
}

/**
 * Calculates the size of the window which the receiver [Activity] is attached to.
 *
 * @return [WindowSizeClass]
 * @receiver an instance of [Activity]
 */
fun Activity.computeWidthWindowSizeClass(): WindowSizeClass {
    val widthDp = computeMetrics().bounds.width() / resources.displayMetrics.density
    return when {
        widthDp < 600f -> WindowSizeClass.COMPACT
        widthDp < 840f -> WindowSizeClass.MEDIUM
        else -> WindowSizeClass.EXPANDED
    }
}