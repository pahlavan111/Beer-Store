package ir.kidzyland.domain.base

sealed class Result<out T: Any> {

    data class Success<out T: Any>(val data: T) : Result<T>()

    data class Error(val error: ir.kidzyland.domain.base.Error) : Result<Nothing>()
}