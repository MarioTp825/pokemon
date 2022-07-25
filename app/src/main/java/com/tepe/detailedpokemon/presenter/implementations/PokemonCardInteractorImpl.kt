package com.tepe.detailedpokemon.presenter.implementations

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.presenter.interactors.PokemonCardInteractor
import com.tepe.detailedpokemon.utils.ARG_POKEMON
import com.tepe.detailedpokemon.utils.DismissDialog
import com.tepe.detailedpokemon.view.adapter.PokemonCardAdapter
import com.tepe.detailedpokemon.view.fragments.PokemonDetailsFragment
import kotlinx.coroutines.launch


class PokemonCardInteractorImpl(
    list: MutableList<Pokemon>,
    private val load: () -> Unit,
    private val fragmentManager: FragmentManager?,
    private val lifecycleScope: LifecycleCoroutineScope?,
    showLoading: Boolean = true,
) : PokemonCardInteractor {
    private val dialog by lazy {
        PokemonDetailsFragment()
    }

    override fun loadData() = load()

    override val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder> = PokemonCardAdapter(
        pokemonCollection = list,
        interactor = this,
        showLoading = showLoading,

        )

    override fun onClick(pokemon: Pokemon?) {
        lifecycleScope?.launchWhenResumed {
            pokemon?.let {
                dialog.arguments = getArguments(it)
                fragmentManager?.let { f ->
                    dialog.show(f, "PokemonDetail")
                }
            }
        }
    }

    private fun getArguments(pokemon: Pokemon) = Bundle().apply {
        putParcelable(ARG_POKEMON, pokemon)
    }


}