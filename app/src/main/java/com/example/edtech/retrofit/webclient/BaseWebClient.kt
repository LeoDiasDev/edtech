package com.example.edtech.retrofit.webclient

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val UNSUCCESSFUL_REQUEST = "Error ao se comunicar com o servidor"
private val NAME_CLASS = BaseClient::class.simpleName

abstract class BaseClient {
    protected fun <T> doRequest(
        call: Call<T>,
        onSuccess: (success: T?) -> Unit,
        onFailure: (error: String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                when {
                    response.isSuccessful -> {
                        onSuccess(response.body())
                    }
                    response.code() == 401 -> {
                        val error = response.errorBody()?.string()
                        onFailure(error)
                        Log.e(NAME_CLASS,"401 - $error - Response Successful: ${response.isSuccessful}")
                    }
                    else -> {
                        onFailure(UNSUCCESSFUL_REQUEST)
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.e(NAME_CLASS,"BAD REQUEST - ${t.message}")
                onFailure(UNSUCCESSFUL_REQUEST)
            }
        })
    }
}