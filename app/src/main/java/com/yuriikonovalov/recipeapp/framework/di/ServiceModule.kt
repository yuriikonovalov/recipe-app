package com.yuriikonovalov.recipeapp.framework.di

import com.squareup.moshi.Moshi
import com.yuriikonovalov.recipeapp.BuildConfig
import com.yuriikonovalov.recipeapp.framework.data.remote.service.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://api.spoonacular.com"
private const val HEADER_API_KEY = "x-api-key"

/**
 * Orchestrates dependency inject for a remote service and http client.
 */
@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader(HEADER_API_KEY, BuildConfig.API_KEY)
                .build()
            chain.proceed(newRequest)
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }


    @Singleton
    @Provides
    fun provideRecipeService(okHttpClient: OkHttpClient): RecipeService {
        val moshi = Moshi.Builder()
//            .addLast(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RecipeService::class.java)
    }
}