package com.yuriikonovalov.recipeapp.resource

/**
 * A wrapper class for results of performing resource related operations
 * such as retrieving data, storing, deleting, etc.
 *
 *
 * Based on the result of an operation can be either [Resource.Success] or [Resource.Failure].
 */
sealed class Resource<T> {
    /**
     * A wrapper class for results of successful operations.
     *
     * @property data any data that's passed back after performing an operation.
     */
    data class Success<T>(val data: T) : Resource<T>()

    /**
     * A wrapper class for results of failed operations.
     *
     * @property resourceError a [ResourceError] that caused a failure.
     */
    data class Failure<T>(val resourceError: ResourceError) : Resource<T>()
    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> failure(resourceError: ResourceError) = Failure<T>(resourceError)
        fun <T> failure(exception: Exception) = Failure<T>(ResourceError.from(exception))
    }
}

/**
 * An extension function that performs an [action] if the type of the receiver is [Resource.Success].
 * @param action a function that accepts data passed back after successful performing.
 * @receiver an instance of [Resource].
 */
fun <T> Resource<T>.onSuccess(action: (data: T) -> Unit) {
    if (this is Resource.Success) {
        action(this.data)
    }
}

/**
 * An extension function that performs an [action] if the type of the receiver is [Resource.Failure].
 * @param action a function that accepts a [ResourceError] passed back after failed performing.
 * @receiver an instance of [Resource].
 */
fun <T> Resource<T>.onFailure(action: (resourceError: ResourceError) -> Unit) {
    if (this is Resource.Failure) {
        action(this.resourceError)
    }
}


