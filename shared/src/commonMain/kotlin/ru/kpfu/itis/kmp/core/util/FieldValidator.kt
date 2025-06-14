package ru.kpfu.itis.kmp.core.util

object FieldValidator {
    private const val EMAIL_REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
            "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
    private const val PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"

    fun isValidEmail(email: String): Boolean {
        return Regex(EMAIL_REGEX).matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return Regex(PASSWORD_REGEX).matches(password)
    }
}
