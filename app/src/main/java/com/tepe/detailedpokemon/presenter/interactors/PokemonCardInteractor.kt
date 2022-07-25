package com.tepe.detailedpokemon.presenter.interactors

import androidx.recyclerview.widget.RecyclerView
import com.tepe.detailedpokemon.model.dto.Pokemon

interface PokemonCardInteractor {
    val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    fun loadData()

    fun onClick(pokemon: Pokemon?)
}