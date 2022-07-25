package com.tepe.detailedpokemon.presenter.implementations

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.model.implementation.PokemonDashboardRepositoryImpl
import com.tepe.detailedpokemon.model.repository.PokemonRepository.PokemonDashboardRepository
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor.PokemonDashboardInteractor
import com.tepe.detailedpokemon.view.interfaces.PokemonView

class PokemonDashboardInteractorImpl(
    override val view: PokemonView.PokemonDashboardView,
    lifecycleScope: LifecycleCoroutineScope,
    lifecycle: Lifecycle,
    ) : PokemonDashboardInteractor {
    private val model: PokemonDashboardRepository<Pokemon> = PokemonDashboardRepositoryImpl(
        interactor = this
    )

    private val cardInteractor =
        PokemonCardInteractorImpl(
            list = model.pokemonCollection,
            fragmentManager = view.manager,
            lifecycleScope = lifecycleScope,
            load = { loadData() },
            showLoading = true,
        )

    override val adapter get() = cardInteractor.adapter

    override fun loadData() = model.loadData()

    override fun showError(message: String?) = view.showErrorDialog(
        message = message ?: "Unknown network error"
    )

    override fun update(wasSuccessful: Boolean) {
        adapter.notifyDataSetChanged()
    }

}