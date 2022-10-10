package com.yuriikonovalov.recipeapp.resource

sealed interface ResourceError {
    object RemoteService : ResourceError
    object NoConnection : ResourceError
    object NotFound : ResourceError
    object Unknown : ResourceError

    companion object {
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

