package com.tepe.detailedpokemon.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tepe.detailedpokemon.databinding.ActivityAuthBinding
import com.tepe.detailedpokemon.presenter.implementations.AuthenticatorInteractorImpl
import com.tepe.detailedpokemon.presenter.interactors.AuthenticationInteractor
import com.tepe.detailedpokemon.utils.ARG_EMAIL
import com.tepe.detailedpokemon.view.interfaces.AuthenticationView

class AuthActivity : AppCompatActivity(), AuthenticationView {
    private val interactor: AuthenticationInteractor = AuthenticatorInteractorImpl(view = this)
    private val binding by lazy { ActivityAuthBinding.inflate(layoutInflater) }

    private val act get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        binding.apply {
            btnLogin.setOnClickListener {
                if(validate()) {
                    interactor.login(
                        etUsername.text.toString(),
                        etPassword.text.toString(),
                        act
                    )
                }
            }

            btnCreateUser.setOnClickListener {
                if(validate())
                    interactor.createUser(
                        etUsername.text.toString(),
                        etPassword.text.toString(),
                        act
                    )
            }
        }
    }

    override fun startSession(email: String) {
        clearPassword()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(ARG_EMAIL, email)
        startActivity(intent)
    }

    override fun clearPassword() {
        binding.etPassword.text.clear()
    }

    private fun validate(): Boolean {
        return interactor.validateInputs(
            binding.etUsername,
            binding.etPassword
        )
    }
}