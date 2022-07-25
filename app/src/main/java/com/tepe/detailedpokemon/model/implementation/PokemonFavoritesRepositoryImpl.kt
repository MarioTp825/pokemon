package com.tepe.detailedpokemon.model.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.protobuf.MapEntryLite
import com.tepe.detailedpokemon.model.dto.Pokemon
import com.tepe.detailedpokemon.model.repository.PokemonRepository.PokemonFavoritesRepository
import com.tepe.detailedpokemon.presenter.interactors.PokemonInteractor.PokemonFavoritesInteractor

class PokemonFavoritesRepositoryImpl(
    override val email: String,
    override val interactor: PokemonFavoritesInteractor,
) : PokemonFavoritesRepository<Pokemon>{
    private val collection = mutableListOf<Pokemon>()
    private val db = FirebaseFirestore.getInstance()

    init {
        db.collection("favorites").document(email).get().addOnSuccessListener { ds ->
            try {
                (ds.get("pokemon") as List<*>).forEach { item ->
                    item?.let {
                        try {
                            val pk = it as HashMap<String?, *>
                            collection.add(
                                Pokemon(
                                    _number = pk["_number"] as Long,
                                    name = pk["name"] as String,
                                    thumbnail = pk["thumbnail"] as String?,
                                    hd = pk["hd"] as String?,
                                    weight = pk["weight"] as String?,
                                    experience = pk["experience"] as String?,
                                    height = pk["height"] as String?,
                                    order = pk["order"] as String?,
                                )
                            )
                        } catch (e: Exception) {
                            interactor.showError("Error trying to retrieve favorites")
                        }
                    }
                }
            } catch (e: Exception) {
                interactor.showError("Error trying to retrieve favorites")
            }
        }
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }

    override fun getPokemonCollection(): MutableList<Pokemon> {
        return collection
    }

    override fun enqueuePokemon(pokemon: Pokemon) {
        collection.add(pokemon)
        update()
    }

    override fun pokemonExists(pokemon: Pokemon) = collection
        .firstOrNull { it._number == pokemon._number } != null

    override fun deletePokemon(pokemon: Pokemon) {
        collection.remove(pokemon)
        update()
    }

    private fun update() {
        db.collection("favorites").document(email).set(
            hashMapOf(
                "pokemon" to collection
            )
        )
    }

}