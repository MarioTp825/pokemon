package com.tepe.detailedpokemon.view.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.squareup.picasso.Picasso
import com.tepe.detailedpokemon.R
import com.tepe.detailedpokemon.databinding.FragmentPokemonDetailsBinding
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.presenter.implementations.PokemonFavoritesInteractorImpl
import com.tepe.detailedpokemon.utils.ARG_POKEMON

class PokemonDetailsFragment : DialogFragment() {
    private val interactor by lazy { PokemonFavoritesInteractorImpl.getInstance(requireActivity()) }
    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var pokemon: Pokemon
    private var favorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemon = arguments?.getParcelable(ARG_POKEMON)!!
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        interactor.update()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailsBinding.inflate(layoutInflater, container, false)

        setEvents()
        bindPokemon()
        return binding.root
    }

    private fun bindPokemon() = pokemon.let {
        favorite = interactor.pokemonExists(pokemon)

        binding.apply {
            tvPokemonDetailName.text = it.name
            tvDataExperience.text = it.experience
            tvDataHeight.text = it.height
            tvDataOrder.text = it.order
            tvDataWeight.text = it.weight

            btnPokemonDetailFavorite.setImageDrawable(
                requireContext().getDrawable(
                    if (!favorite) {
                        R.drawable.ic_favorite_border
                    } else {
                        R.drawable.ic_favorite_filled
                    }
                )
            )

        }
        Picasso
            .get()
            .load(it.hd)
            .fit()
            .centerCrop()
            .into(binding.ivPokemonDetailPicture)
    }

    private fun setEvents() {
        binding.btnOk.setOnClickListener { dismiss() }

        binding.btnPokemonDetailFavorite.setOnClickListener {
            binding.btnPokemonDetailFavorite.setImageDrawable(
                requireContext().getDrawable(
                    if (!favorite) {
                        showMsg("Agregado a favoritos")
                        interactor.loadData(pokemon)
                        R.drawable.ic_favorite_filled
                    } else {
                        showMsg("Eliminado de favoritos")
                        interactor.deletePokemon(pokemon)
                        R.drawable.ic_favorite_border
                    }
                )
            )
            favorite = !favorite
        }
    }

    private fun showMsg(msg: String) {
        Toast
            .makeText(requireContext(), msg, Toast.LENGTH_SHORT)
            .show()
    }

}
