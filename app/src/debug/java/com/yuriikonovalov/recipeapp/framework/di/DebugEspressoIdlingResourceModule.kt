package com.yuriikonovalov.recipeapp.framework.di

import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.util.DebugEspressoIdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DebugEspressoIdlingResourceModule {

    @Provides
    @Singleton
    fun provideEspressoIdlingResource(): EspressoIdlingResource = DebugEspressoIdlingResource
}