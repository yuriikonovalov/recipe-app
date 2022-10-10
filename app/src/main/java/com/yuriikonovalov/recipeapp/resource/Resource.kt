package com.yuriikonovalov.recipeapp.resource

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Failure<T>(val resourceError: ResourceError) : Resource<T>()
    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> failure(resourceError: ResourceError) = Failure<T>(resourceError)
        fun <T> failure(exception: Exception) = Failure<T>(ResourceError.from(exception))
    }
}

fun <T> Resource<T>.onSuccess(action: (data: T) -> Unit) {
    if (this is Resource.Success) {
        action(this.data)
    }
}

fun <T> Resource<T>.onFailure(action: (resourceError: ResourceError) -> Unit) {
    if (this is Resource.Failure) {
        action(this.resourceError)
    }
}


