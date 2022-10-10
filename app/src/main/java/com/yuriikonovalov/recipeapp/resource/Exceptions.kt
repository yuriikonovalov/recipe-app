package com.yuriikonovalov.recipeapp.resource

import retrofit2.HttpException
import java.io.IOException


class ApiException(val code: Int) : Exception()
object NoConnectionException : Exception()
class UnexpectedException(val exception: Exception) : Exception()

fun mapRemoteToDomainException(
    remoteException: Exception,
    httpExceptionsMapper: (HttpException) -> Exception? = { null }
): Exception {
    return when (remoteException) {
        is IOException -> NoConnectionException
        is HttpException -> httpExceptionsMapper(remoteException) ?: ApiException(
            remoteException.code()
        )
        else -> UnexpectedException(remoteException)
    }
}

