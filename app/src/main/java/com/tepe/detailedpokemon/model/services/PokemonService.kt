package com.tepe.detailedpokemon.model.services

import com.tepe.detailedpokemon.model.pojo.PokemonCollectionPage
import com.tepe.detailedpokemon.model.pojo.PokemonResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon/{id}")
    fun singlePokemon(
        @Path("id") id: String
    ) : Call<PokemonResource?>?

    @GET("pokemon")
    fun pokemonResource(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Call<PokemonCollectionPage?>?
}