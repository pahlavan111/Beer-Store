package ir.bpf.data.datasource

import ir.bpf.domain.base.Error
import ir.bpf.domain.base.Result
import ir.bpf.data.model.response.adapter.GenericResponse
import ir.bpf.data.model.response.adapter.NetworkResponse


open class BaseDataSource {

//    @Inject
//    open lateinit var parentPreferences: ParentPreferences
//
//    fun userNotLoggedIn() = !parentPreferences.isUserLoggedIn()

    fun handleError(response: GenericResponse<Any>) = when (response) {
        is NetworkResponse.ApiError -> Result.Error(Error.ServerError(response.body?.getErrorMessage()))
        is NetworkResponse.NetworkError -> Result.Error(Error.Internet)
        else -> Result.Error(Error.Unknown)
    }
}