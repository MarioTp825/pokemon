package com.tepe.detailedpokemon.presenter.interactors

import android.app.Activity
import android.widget.EditText

interface AuthenticationInteractor {

    fun showError(msg: String, activity: Activity)

    fun login(email: String, password: String, activity: Activity)

    fun createUser(email: String, password: String, activity: Activity)

    fun validateInputs(email: EditText, password: EditText): Boolean
}