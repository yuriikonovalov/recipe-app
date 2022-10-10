package com.yuriikonovalov.recipeapp.util

import android.app.Activity
import androidx.window.layout.WindowMetrics
import androidx.window.layout.WindowMetricsCalculator

enum class WindowSizeClass { COMPACT, MEDIUM, EXPANDED }

private fun Activity.computeMetrics(): WindowMetrics {
    return WindowMetricsCalculator.getOrCreate()
        .computeCurrentWindowMetrics(this)
}

fun Activity.computeWidthWindowSizeClass(): WindowSizeClass {
    val widthDp = computeMetrics().bounds.width() / resources.displayMetrics.density
    return when {
        widthDp < 600f -> WindowSizeClass.COMPACT
        widthDp < 840f -> WindowSizeClass.MEDIUM
        else -> WindowSizeClass.EXPANDED
    }
}