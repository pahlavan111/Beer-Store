package ir.kidzyland.data.model.response.adapter

import com.example.checkconnectivity.CheckConnectivityModule
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.net.HttpURLConnection.*
import kotlin.let
import kotlin.ranges.until

internal class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<S, E>> {

    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    body?.let {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Success(body))
                        )
                    } ?: run {
                        // Response is successful but the body is null
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.SuccessWithOutBody)
                        )
                    }

                } else {
                    val errorBody = try {
                            errorConverter.convert(error)
                        } catch (ex: Exception) {
                            null
                        }

                    when (code) {
                        HTTP_UNAUTHORIZED -> {
                            callback.onResponse(
                                this@NetworkResponseCall,
                                Response.success(NetworkResponse.AuthenticationError(errorBody, code))
                            )
                        }
                        in HTTP_BAD_REQUEST until HTTP_INTERNAL_ERROR -> {
                            callback.onResponse(
                                this@NetworkResponseCall,
                                Response.success(NetworkResponse.ApiError(errorBody, code))
                            )
                        }
                        else -> {
                            return callback.onResponse(
                                this@NetworkResponseCall,
                                Response.success(NetworkResponse.ApiError(null, code))
                            )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val networkResponse = if (CheckConnectivityModule.checkHasConnectionAndInternet() == CheckConnectivityModule.ConnectivityState.HASINTERNET) {
                    NetworkResponse.UnknownError(throwable)
                } else {
                    NetworkResponse.NetworkError(throwable)
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    override fun isExecuted() = delegate.isExecuted

    override fun clone() = NetworkResponseCall(delegate.clone(), errorConverter)

    override fun isCanceled() = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<NetworkResponse<S, E>> {
        throw kotlin.UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

}
