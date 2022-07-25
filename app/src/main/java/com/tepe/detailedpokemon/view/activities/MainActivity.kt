package com.tepe.detailedpokemon.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.common.util.SharedPreferencesUtils
import com.tepe.detailedpokemon.R
import com.tepe.detailedpokemon.databinding.ActivityMainBinding
import com.tepe.detailedpokemon.presenter.implementations.PokemonFavoritesInteractorImpl
import com.tepe.detailedpokemon.utils.ARG_EMAIL
import com.tepe.detailedpokemon.utils.SHARED_POKEMON_EMAIL



class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getStringExtra(ARG_EMAIL)?.let {
            val shared = this.getSharedPreferences(SHARED_POKEMON_EMAIL, Context.MODE_PRIVATE)
            shared.edit().putString(SHARED_POKEMON_EMAIL, it).apply()
            PokemonFavoritesInteractorImpl.getInstance(this)
        }

        val controller = supportFragmentManager
            .findFragmentById(R.id.fcvMainContainer) as NavHostFragment

        binding.bnvMainNav.setupWithNavController(controller.navController)
    }

}