package com.tepe.detailedpokemon.presenter.interactors

import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.view.interfaces.PokemonView

sealed interface PokemonInteractor<T> {
    val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    fun showError(message: String?)

    fun update(wasSuccessful: Boolean = true)

    interface PokemonDashboardInteractor: PokemonInteractor<Pokemon> {
        val view: PokemonView.PokemonDashboardView

        fun loadData()
    }

    interface PokemonFavoritesInteractor: PokemonInteractor<Pokemon> {
        var view: PokemonView.PokemonFavoritesView?

        fun loadData(data: Pokemon)

        fun deletePokemon(data: Pokemon)

        fun pokemonExists(pokemon: Pokemon): Boolean
    }
}