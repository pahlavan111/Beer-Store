package ir.kidzyland.data.model.response.adapter

sealed class NetworkResponse<out T : Any, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    object SuccessWithOutBody : NetworkResponse<Nothing, Nothing>()

    /**
     * Failure response with body, non 2xx response
     */
    data class ApiError<U : Any>(val body: U?, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Failure response with body, non 2xx response
     */
    data class AuthenticationError<U : Any>(val body: U?, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Network error, such no internet connection
     */
    data class NetworkError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
}


typealias GenericResponse<S> = NetworkResponse<S, ResponseError>