package ir.bpf.data.model.response.adapter

import kotlin.collections.forEach
import kotlin.collections.last


data class ResponseError(
    val messages: MutableList<Error>?
) {
    fun getErrorMessage(): String {
        var joinedErrorMessage = ""
        messages?.forEach { error ->
            joinedErrorMessage += error.message
            if (messages.last() != error)
                joinedErrorMessage += ", "
        }

        return joinedErrorMessage
    }

    fun getErrorCode() : Int? {
        messages?.forEach { error ->
            return error.code
        }
        return null
    }
}

data class Error(
    val code: Int,
    val message: String
)