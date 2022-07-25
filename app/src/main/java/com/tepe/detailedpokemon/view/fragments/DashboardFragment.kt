package com.tepe.detailedpokemon.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.R
import com.tepe.detailedpokemon.presenter.implementations.PokemonDashboardInteractorImpl
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor.PokemonDashboardInteractor
import com.tepe.detailedpokemon.utils.alertDialog
import com.tepe.detailedpokemon.view.interfaces.PokemonView

class DashboardFragment : Fragment(), PokemonView.PokemonDashboardView {
    override val manager: FragmentManager by lazy { parentFragmentManager }

    override val interactor: PokemonDashboardInteractor by lazy {
        PokemonDashboardInteractorImpl(
            view = this,
            lifecycle = lifecycle,
            lifecycleScope = lifecycleScope
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        view.findViewById<RecyclerView>(R.id.rvDashboard).apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = interactor.adapter
        }

        interactor.loadData()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }

    override fun showErrorDialog(message: String) {
        alertDialog(
            requireActivity(),
            msg = message,
        ) {
        }
    }
}