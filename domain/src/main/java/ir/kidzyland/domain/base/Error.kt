package ir.kidzyland.domain.base

sealed class Error : Exception() {

    // server
    object Internet : Error() // retrofit timeout

    data class ServerError(override val message: String?) : Error() // 4xx

    object Unknown : Error() // 5xx

    object TokenExpired : Error() // 401

    object NotFound : Error() // 404

    object NotLoggedIn : Error() // refresh token is empty

    object AccessDenied : Error() // 403

    object EmptyResult : Error() // 200 but without and data

    object ChatDisconnected : Error()



    // fields validation error

    object Empty : Error()

    object WrongFormat : Error()

    object CreditNotEnough : Error()

    object FinancialLevelError : Error()

    object NumberOnly : Error()

    object ShortLength : Error()



    // edit profile
    object NoFirstName : Error()

    object NoLastName : Error()

    object NoNationalCode : Error()

    object NationalCodeError : Error()

    object NoNationalCardSerial : Error()

    object NationalCardSerialWrong : Error()

    object NoVideo : Error()

    object NoBirthday : Error()


    // pin code
    object NoPinCode: Error()

    object PinCodeWrong: Error()

    object NoRepeatPinCode: Error()

    object RepeatPinCodeNotMatch: Error()

    object NoOldPinCode: Error()

    object OldPinCodeWrong: Error()

}