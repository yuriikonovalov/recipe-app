package com.yuriikonovalov.recipeapp.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.math.round

/**
 * Hides a previously open keyboard.
 * @receiver an instance of [View] that contains a view that triggers keyboard.
 */
fun View.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * Launches suspend functions in a coroutine scope that respects lifecycle of the receiver.
 * @param body a suspend function that will be performed.
 * @receiver an instance of [Fragment].
 */
fun Fragment.launchSafely(body: suspend () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            body()
        }
    }
}

/**
 * Launches collecting of an [eventFlow] value in a coroutine scope that respects lifecycle behavior
 * of the receiver. Also performs a passed [eventConsumer] function after collection.
 *
 * The actions on collected values are defined by a [onCollect] function.
 *
 * @param eventFlow [StateFlow] that emits values.
 * @param onCollect a function that accepts a value emitted by the [eventFlow].
 * @param eventConsumer a function that will be invoked after [onCollect] is done.
 * @receiver an instance of [Fragment].
 */
inline fun <T : Any> Fragment.collectEvent(
    eventFlow: StateFlow<T?>,
    crossinline eventConsumer: () -> Unit,
    crossinline onCollect: (value: T) -> Unit,
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            eventFlow.filterNotNull()
                .collect {
                    onCollect(it)
                    eventConsumer.invoke()
                }
        }
    }
}

/**
 * Sets a number of decimals of a double to the given number.
 * @param decimals a number of decimals the receiver should contain.
 * @receiver a [Double] to which rounding will be applied.
 * @return a rounded [Double] with a number of decimals equals to passed [decimals]
 */
fun Double.roundDecimals(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}