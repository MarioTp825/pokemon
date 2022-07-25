package com.tepe.detailedpokemon.view.interfaces

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor

sealed interface PokemonView {
    val manager: FragmentManager
    fun showErrorDialog(message: String)

    interface PokemonDashboardView: PokemonView {
        val interactor: PokemonInteractor.PokemonDashboardInteractor
    }

    interface PokemonFavoritesView: PokemonView {
        val viewLifecycleScope: LifecycleCoroutineScope
    }
}