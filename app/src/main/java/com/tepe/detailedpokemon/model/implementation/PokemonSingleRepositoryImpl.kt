package com.tepe.detailedpokemon.model.implementation

import com.tepe.detailedpokemon.BuildConfig
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.model.pojo.PokemonResource
import com.tepe.detailedpokemon.model.repository.PokemonRepository
import com.tepe.detailedpokemon.model.services.PokemonService
import com.tepe.detailedpokemon.model.utils.DefaultRetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PokemonSingleRepositoryImpl(
    override val mainRepository: PokemonRepository.PokemonDashboardRepository<Pokemon>
) : Callback<PokemonResource?>, PokemonRepository.PokemonSingleRepository<Pokemon> {
    var id: String = ""

    private val service by lazy {
        DefaultRetrofitFactory.newInstance(
            baseUrl = BuildConfig.BASE_URL,
            serviceClass = PokemonService::class.java
        )
    }

    override fun onResponse(call: Call<PokemonResource?>, response: Response<PokemonResource?>) {
        if (!response.isSuccessful) {
            addFailure(
                msg = "error ${response.code()}: ${response.message()}"
            )
            return
        }
        response.body()?.let { pk ->
            mainRepository.enqueuePokemon(
                pokemon = Pokemon(
                    name = pk.name.na().nameFormat(),
                    _number = pk.id.na().toLong(),
                    hd = pk.sprites?.other?.officialArtwork?.frontDefault,
                    thumbnail = pk.sprites?.frontDefault,
                    experience = pk.baseExperience?.toString(),
                    height = pk.height?.toString(),
                    weight = pk.weight?.toString(),
                    order = pk.order?.toString(),
                ),
                message = response.message()
            )
        } ?: addFailure(msg = "Error when trying to get response of $id")

    }

    override fun onFailure(call: Call<PokemonResource?>, t: Throwable) = addFailure(t.message)

    private fun addFailure(msg: String?) {
        mainRepository.enqueuePokemon(
            pokemon = null,
            message = msg
        )
    }

    override fun loadData(id: String) {
        this.id = id
        service.singlePokemon(
            id = id
        )?.enqueue(this)
    }

    //If the property was not available, returns N/A
    private fun String?.na() = this ?: "N/A"
    private fun Int?.na() = this ?: -1

    private fun String.nameFormat() =
        replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else it.toString()
        }
}