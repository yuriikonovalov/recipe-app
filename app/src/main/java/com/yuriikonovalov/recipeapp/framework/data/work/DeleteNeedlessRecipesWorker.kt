package com.yuriikonovalov.recipeapp.framework.data.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.yuriikonovalov.recipeapp.application.usecases.DeleteNeedlessRecipes
import com.yuriikonovalov.recipeapp.application.usecases.DeleteNeedlessRecipesImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * A custom implementation of [CoroutineWorker] for a [DeleteNeedlessRecipes] use case.
 */
@HiltWorker
class DeleteNeedlessRecipesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val deleteNeedlessRecipes: DeleteNeedlessRecipes
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            deleteNeedlessRecipes()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object {
        const val NAME = "DeleteNeedlessRecipesWorker"
    }
}