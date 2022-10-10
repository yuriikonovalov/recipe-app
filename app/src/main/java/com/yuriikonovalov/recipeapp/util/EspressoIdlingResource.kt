package com.yuriikonovalov.recipeapp.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

interface EspressoIdlingResource {
    val instance: IdlingResource
    fun increment()
    fun decrement()
}

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

