package com.tepe.detailedpokemon.presenter.implementations

import android.app.Activity
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.tepe.detailedpokemon.presenter.interactors.AuthenticationInteractor
import com.tepe.detailedpokemon.utils.alertDialog
import com.tepe.detailedpokemon.view.interfaces.AuthenticationView

class AuthenticatorInteractorImpl(
    private val view: AuthenticationView
): AuthenticationInteractor {

    override fun showError(msg: String, activity: Activity) {
        alertDialog(
            activity,
            msg = msg,
            title = "Login"
        ) {
            view.clearPassword()
        }
    }

    override fun login(email: String, password: String, activity: Activity) {
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    view.startSession(email)
                    return@addOnCompleteListener
                }
            }.addOnFailureListener {
                showError("Authentication unsuccessful, try again.", activity)
            }
    }

    override fun createUser(email: String, password: String, activity: Activity) {
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {
                if(it.isSuccessful) {
                    view.startSession(email)
                    return@addOnCompleteListener
                }

            }.addOnFailureListener {
                showError(it.message?:"Error creating user, try later", activity)
            }
    }

    override fun validateInputs(email: EditText, password: EditText): Boolean {
        return verifyEmptyInputs(email, password)
    }

    private fun verifyEmptyInputs(vararg et: EditText): Boolean {
        var flag = true
        for (item in et) {
            if(item.text.isEmpty()) {
                item.error = "Required field"
                flag = false
            }
        }
        return  flag
    }


}