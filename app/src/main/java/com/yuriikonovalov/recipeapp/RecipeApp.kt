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

/**
 * The main class of the application.
 */
@HiltAndroidApp
class RecipeApp : Application(), Configuration.Provider {

    @Inject
    /**
     * A variable that contains a reference to WorkerFactory.
     */
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        addDeleteNeedlessRecipesPeriodicWork()
    }

    /**
     * A method that adds a unique periodic work to WorkManager
     */
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

    /**
     * A method that builds a [Configuration] object which is used to customize WorkManager upon initialization.
     * @return [Configuration]
     */
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}