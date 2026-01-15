package com.itandrew.braincalc.data.remote

import retrofit2.HttpException
import retrofit2.Response

class ApiUtils {
    companion object {
        fun <T>safeApiCall(call: () -> Response<T>) : Result<T?>{
            kotlin.runCatching{
                call()
            }.fold(
                onSuccess = {
                    return if (it.isSuccessful)
                        Result.success(it.body())
                    else Result.failure(HttpException(it))
                },
                onFailure = {
                    return Result.failure(it)
                }
            )
        }
    }
}