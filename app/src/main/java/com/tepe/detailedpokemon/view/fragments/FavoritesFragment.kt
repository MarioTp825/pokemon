package com.tepe.detailedpokemon.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.R
import com.tepe.detailedpokemon.presenter.implementations.PokemonFavoritesInteractorImpl
import com.tepe.detailedpokemon.utils.alertDialog
import com.tepe.detailedpokemon.view.interfaces.PokemonView

class FavoritesFragment : Fragment(), PokemonView.PokemonFavoritesView {
    private val interactor by lazy { PokemonFavoritesInteractorImpl.getInstance(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        interactor.view = this
        view.findViewById<RecyclerView>(R.id.rvFavoritesPokemon).apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = interactor.adapter

        }

        return view
    }

    override fun onResume() {
        super.onResume()
        interactor.update()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavoritesFragment()
    }

    override val viewLifecycleScope: LifecycleCoroutineScope
            by lazy { lifecycleScope }

    override val manager: FragmentManager by lazy { parentFragmentManager }

    override fun showErrorDialog(message: String) {
        alertDialog(
            requireActivity(),
            msg = message,
        ) {

        }
    }
}