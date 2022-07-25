package com.tepe.detailedpokemon.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tepe.detailedpokemon.databinding.ItemRvPkCardBinding
import com.tepe.detailedpokemon.databinding.ItemRvPkLoadingBinding
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.presenter.interactors.PokemonCardInteractor
import com.tepe.detailedpokemon.utils.DismissDialog

private const val TYPE_LOADING = 0
private const val TYPE_CARD = 1

class PokemonCardAdapter(
    private val pokemonCollection: MutableList<Pokemon>,
    private val interactor: PokemonCardInteractor,
    private val showLoading: Boolean = true,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == TYPE_LOADING && showLoading) LoadingViewHolder(
            ItemRvPkLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) else ViewHolder(
            ItemRvPkCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) { pk -> interactor.onClick(pk) }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LoadingViewHolder) {
            holder.bind()
            interactor.loadData()
        } else
            (holder as ViewHolder).bind(pokemonCollection[position])
    }

    override fun getItemViewType(position: Int) =
        if (pokemonCollection.lastIndex == position) TYPE_LOADING else TYPE_CARD

    override fun getItemCount() = pokemonCollection.size

    class ViewHolder(
        private val view: ItemRvPkCardBinding,
        onClick: (Pokemon?) -> Unit
    ) : RecyclerView.ViewHolder(view.root) {

        private var pokemon: Pokemon? = null

        init {
            view.cvPokemonCard.setOnClickListener {
                onClick(pokemon)
            }
        }

        fun bind(pokemon: Pokemon) {
            this.pokemon = pokemon
            view.tvPokemonId.text = pokemon.number
            view.tvPokemonName.text = pokemon.name

            Picasso.get()
                .load(pokemon.thumbnail)
                .fit()
                .centerInside()
                .into(view.ivPokemonImage)

        }
    }

    class LoadingViewHolder(private val view: ItemRvPkLoadingBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind() {
            view.llLoadingPikachu
        }
    }
}