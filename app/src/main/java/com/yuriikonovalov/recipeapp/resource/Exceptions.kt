package com.yuriikonovalov.recipeapp.resource

import retrofit2.HttpException
import java.io.IOException


class ApiException(val code: Int) : Exception()
object NoConnectionException : Exception()
class UnexpectedException(val exception: Exception) : Exception()

/**
 * Transforms an accepted general Exception to a custom one.
 * @param  remoteException [Exception] that has been thrown during triggering remote services.
 * @param httpExceptionsMapper a function that is a custom mapper for a [remoteException]
 * when it's an instance of [HttpException]. It's null by default.
 * @return an instance of one of the domain exceptions.
 * @see [ApiException].
 * @see [NoConnectionException].
 * @see [UnexpectedException].
 */
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

