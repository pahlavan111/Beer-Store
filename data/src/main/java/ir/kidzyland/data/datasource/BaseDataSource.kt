package ir.kidzyland.data.datasource

import ir.kidzyland.data.model.response.adapter.GenericResponse
import ir.kidzyland.data.model.response.adapter.NetworkResponse
import ir.kidzyland.domain.base.Error
import ir.kidzyland.domain.base.Result


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