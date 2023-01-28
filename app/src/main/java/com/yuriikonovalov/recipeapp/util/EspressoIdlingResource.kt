package com.yuriikonovalov.recipeapp.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

/**
 * This is an interface that is used for creating an Espresso idling resource object which is used in ui tests.
 */
interface EspressoIdlingResource {
    /**
     * A reference to the object that keeps track of idling and working resources.
     */
    val instance: IdlingResource

    /**
     * Increases a counter in the Espresso idling resource object by 1.
     */
    fun increment()

    /**
     * Decreases a counter in the Espresso idling resource object by 1.
     */
    fun decrement()
}

/**
 * This is a debug version of Espresso idling resource object.
 *
 * This object will be used during ui tests.
 */
object DebugEspressoIdlingResource : EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    private val countingIdlingResource = CountingIdlingResource(RESOURCE)

    override val instance: CountingIdlingResource
        get() = countingIdlingResource

    override fun increment() {
        instance.increment()
    }

    override fun decrement() {
        if (!instance.isIdleNow) {
            instance.decrement()
        }
    }
}

