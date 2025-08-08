package ir.bpf.domain.base

sealed class Result<out T: Any> {

    data class Success<out T: Any>(val data: T) : Result<T>()

    data class Error(val error: ir.bpf.domain.base.Error) : Result<Nothing>()
}