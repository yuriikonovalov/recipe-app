package com.yuriikonovalov.recipeapp

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.yuriikonovalov.recipeapp.framework.data.work.DeleteNeedlessRecipesWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class RecipeApp : Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        addDeleteNeedlessRecipesPeriodicWork()
    }

    private fun addDeleteNeedlessRecipesPeriodicWork() {
        val workRequest =
            PeriodicWorkRequestBuilder<DeleteNeedlessRecipesWorker>(12, TimeUnit.HOURS)
                .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            DeleteNeedlessRecipesWorker.NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}