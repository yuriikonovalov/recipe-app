package com.yuriikonovalov.recipeapp.resource

/**
 * This is a sealed interface that defines types of possible resource errors.
 */
sealed interface ResourceError {
    object RemoteService : ResourceError
    object NoConnection : ResourceError
    object NotFound : ResourceError
    object Unknown : ResourceError

    companion object {
        /**
         * A mapper function that returns a [ResourceError] object based on an accepted [Exception].
         * @param exception [Exception] that has been thrown.
         * @return a [ResourceError] object.
         */
        fun from(exception: Exception): ResourceError {
            return when (exception) {
                is ApiException -> RemoteService
                is NoConnectionException -> NoConnection
                is UnexpectedException -> Unknown
                else -> Unknown
            }
        }
    }
}

