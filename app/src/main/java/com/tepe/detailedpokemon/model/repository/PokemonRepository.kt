package com.tepe.detailedpokemon.model.repository

import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor

sealed interface PokemonRepository<T> {

    fun loadData()

    interface PokemonDashboardRepository<T>: PokemonRepository<T> {
        val pokemonCollection: MutableList<T>
        val interactor: PokemonInteractor.PokemonDashboardInteractor

        fun enqueuePokemon(pokemon: T?, message: String? = null)
    }

    interface PokemonSingleRepository<T> {
        val mainRepository: PokemonDashboardRepository<T>
        fun loadData(id: String)
    }

    interface PokemonFavoritesRepository<T>: PokemonRepository<T> {
        val email: String
        val interactor: PokemonInteractor.PokemonFavoritesInteractor

        fun getPokemonCollection(): MutableList<Pokemon>

        fun enqueuePokemon(pokemon: T)

        fun deletePokemon(pokemon: T)

        fun pokemonExists(pokemon: T): Boolean
    }
}