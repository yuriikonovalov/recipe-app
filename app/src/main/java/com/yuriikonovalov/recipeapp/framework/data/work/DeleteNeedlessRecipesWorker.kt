package com.yuriikonovalov.recipeapp.framework.data.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.yuriikonovalov.recipeapp.application.usecases.DeleteNeedlessRecipesUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DeleteNeedlessRecipesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val deleteNeedlessRecipesUseCase: DeleteNeedlessRecipesUseCase
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            deleteNeedlessRecipesUseCase()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object {
        const val NAME = "DeleteNeedlessRecipesWorker"
    }
}