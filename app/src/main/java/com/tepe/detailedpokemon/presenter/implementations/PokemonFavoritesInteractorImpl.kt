package com.tepe.detailedpokemon.presenter.implementations

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.model.implementation.PokemonFavoritesRepositoryImpl
import com.tepe.detailedpokemon.model.repository.PokemonRepository.PokemonFavoritesRepository
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor.PokemonFavoritesInteractor
import com.tepe.detailedpokemon.utils.SHARED_POKEMON_EMAIL
import com.tepe.detailedpokemon.view.interfaces.PokemonView

class PokemonFavoritesInteractorImpl
private constructor(
    private val context: Context
) : PokemonFavoritesInteractor {
    override var view: PokemonView.PokemonFavoritesView? = null

    private val repository: PokemonFavoritesRepository<Pokemon> = PokemonFavoritesRepositoryImpl(
        interactor = this,
        email = context.let {
            val shared = context.getSharedPreferences(SHARED_POKEMON_EMAIL, Context.MODE_PRIVATE)
            val email = shared.getString(SHARED_POKEMON_EMAIL, null)
            email ?: ""
        }
    )

    private val cardInteractor by lazy {
        PokemonCardInteractorImpl(
            list = repository.getPokemonCollection(),
            fragmentManager = view?.manager,
            lifecycleScope = view?.viewLifecycleScope,
            load = {  },
            showLoading = false,
        )
    }

    override val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        get() = cardInteractor.adapter

    override fun loadData(data: Pokemon) {
        repository.enqueuePokemon(
            data
        )
    }

    override fun deletePokemon(data: Pokemon) {
        repository.deletePokemon(data)
    }

    override fun pokemonExists(pokemon: Pokemon) = repository.pokemonExists(pokemon)

    override fun showError(message: String?) {
        message?.let {
            view?.showErrorDialog(it)
        }
    }

    override fun update(wasSuccessful: Boolean) {
        view?.let {
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        private var favoritesInteractor: PokemonFavoritesInteractor? = null

        @JvmStatic
        fun getInstance(context: Context): PokemonFavoritesInteractor {
            if (favoritesInteractor == null) {
                favoritesInteractor = PokemonFavoritesInteractorImpl(context)
            }
            return favoritesInteractor!!
        }
    }
}