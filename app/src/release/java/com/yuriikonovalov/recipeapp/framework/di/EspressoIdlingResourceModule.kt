package com.yuriikonovalov.recipeapp.framework.di

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReleaseEspressoIdlingResourceModule {

    @Provides
    @Singleton
    fun provideEspressoIdlingResource(): EspressoIdlingResource = object : EspressoIdlingResource {
        override val idlingResource: IdlingResource
            get() = CountingIdlingResource("ReleaseEspressoIdlingResource")

        override fun increment() {
            /* no-op */
        }

        override fun decrement() {
            /* no-op */
        }
    }
}