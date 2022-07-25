package com.tepe.detailedpokemon.view.interfaces

interface AuthenticationView {
    fun startSession(email: String)
    fun clearPassword()
}