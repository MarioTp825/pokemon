package com.tepe.detailedpokemon.model.pojo


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class PokemonResource(
    val abilities: List<Ability?>? = null,
    @SerializedName("base_experience")
    val baseExperience: Int? = null,
    val forms: List<Form?>? = null,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice?>? = null,
    val height: Int? = null,
    @SerializedName("held_items")
    val heldItems: List<HeldItem?>? = null,
    val id: Int? = null,
    @SerializedName("is_default")
    val isDefault: Boolean? = null,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = null,
    val moves: List<Move?>? = null,
    val name: String? = null,
    val order: Int? = null,
    @SerializedName("past_types")
    val pastTypes: List<Any?>? = null,
    val species: Species? = null,
    val sprites: Sprites? = null,
    val stats: List<Stat?>? = null,
    val types: List<Type?>? = null,
    val weight: Int? = null
) {
    @Keep
    data class Ability(
        val ability: Ability? = null,
        @SerializedName("is_hidden")
        val isHidden: Boolean? = null,
        val slot: Int? = null
    ) {
        @Keep
        data class Ability(
            val name: String? = null,
            val url: String? = null
        )
    }

    @Keep
    data class Form(
        val name: String? = null,
        val url: String? = null
    )

    @Keep
    data class GameIndice(
        @SerializedName("game_index")
        val gameIndex: Int? = null,
        val version: Version? = null
    ) {
        @Keep
        data class Version(
            val name: String? = null,
            val url: String? = null
        )
    }

    @Keep
    data class HeldItem(
        val item: Item? = null,
        @SerializedName("version_details")
        val versionDetails: List<VersionDetail?>? = null
    ) {
        @Keep
        data class Item(
            val name: String? = null,
            val url: String? = null
        )

        @Keep
        data class VersionDetail(
            val rarity: Int? = null,
            val version: Version? = null
        ) {
            @Keep
            data class Version(
                val name: String? = null,
                val url: String? = null
            )
        }
    }

    @Keep
    data class Move(
        val move: Move? = null,
        @SerializedName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail?>? = null
    ) {
        @Keep
        data class Move(
            val name: String? = null,
            val url: String? = null
        )

        @Keep
        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            val levelLearnedAt: Int? = null,
            @SerializedName("move_learn_method")
            val moveLearnMethod: MoveLearnMethod? = null,
            @SerializedName("version_group")
            val versionGroup: VersionGroup? = null
        ) {
            @Keep
            data class MoveLearnMethod(
                val name: String? = null,
                val url: String? = null
            )

            @Keep
            data class VersionGroup(
                val name: String? = null,
                val url: String? = null
            )
        }
    }

    @Keep
    data class Species(
        val name: String? = null,
        val url: String? = null
    )

    @Keep
    data class Sprites(
        @SerializedName("back_default")
        val backDefault: String? = null,
        @SerializedName("back_female")
        val backFemale: Any? = null,
        @SerializedName("back_shiny")
        val backShiny: String? = null,
        @SerializedName("back_shiny_female")
        val backShinyFemale: Any? = null,
        @SerializedName("front_default")
        val frontDefault: String? = null,
        @SerializedName("front_female")
        val frontFemale: Any? = null,
        @SerializedName("front_shiny")
        val frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        val frontShinyFemale: Any? = null,
        val other: Other? = null,
        val versions: Versions? = null
    ) {
        @Keep
        data class Other(
            @SerializedName("dream_world")
            val dreamWorld: DreamWorld? = null,
            val home: Home? = null,
            @SerializedName("official-artwork")
            val officialArtwork: OfficialArtwork? = null
        ) {
            @Keep
            data class DreamWorld(
                @SerializedName("front_default")
                val frontDefault: String? = null,
                @SerializedName("front_female")
                val frontFemale: Any? = null
            )

            @Keep
            data class Home(
                @SerializedName("front_default")
                val frontDefault: String? = null,
                @SerializedName("front_female")
                val frontFemale: Any? = null,
                @SerializedName("front_shiny")
                val frontShiny: String? = null,
                @SerializedName("front_shiny_female")
                val frontShinyFemale: Any? = null
            )

            @Keep
            data class OfficialArtwork(
                @SerializedName("front_default")
                val frontDefault: String? = null
            )
        }

        @Keep
        data class Versions(
            @SerializedName("generation-i")
            val generationI: GenerationI? = null,
            @SerializedName("generation-ii")
            val generationIi: GenerationIi? = null,
            @SerializedName("generation-iii")
            val generationIii: GenerationIii? = null,
            @SerializedName("generation-iv")
            val generationIv: GenerationIv? = null,
            @SerializedName("generation-v")
            val generationV: GenerationV? = null,
            @SerializedName("generation-vi")
            val generationVi: GenerationVi? = null,
            @SerializedName("generation-vii")
            val generationVii: GenerationVii? = null,
            @SerializedName("generation-viii")
            val generationViii: GenerationViii? = null
        ) {
            @Keep
            data class GenerationI(
                @SerializedName("red-blue")
                val redBlue: RedBlue? = null,
                val yellow: Yellow? = null
            ) {
                @Keep
                data class RedBlue(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_gray")
                    val backGray: String? = null,
                    @SerializedName("back_transparent")
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_gray")
                    val frontGray: String? = null,
                    @SerializedName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Keep
                data class Yellow(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_gray")
                    val backGray: String? = null,
                    @SerializedName("back_transparent")
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_gray")
                    val frontGray: String? = null,
                    @SerializedName("front_transparent")
                    val frontTransparent: String? = null
                )
            }

            @Keep
            data class GenerationIi(
                val crystal: Crystal? = null,
                val gold: Gold? = null,
                val silver: Silver? = null
            ) {
                @Keep
                data class Crystal(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_transparent")
                    val backShinyTransparent: String? = null,
                    @SerializedName("back_transparent")
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_transparent")
                    val frontShinyTransparent: String? = null,
                    @SerializedName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Keep
                data class Gold(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Keep
                data class Silver(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    val frontTransparent: String? = null
                )
            }

            @Keep
            data class GenerationIii(
                val emerald: Emerald? = null,
                @SerializedName("firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen? = null,
                @SerializedName("ruby-sapphire")
                val rubySapphire: RubySapphire? = null
            ) {
                @Keep
                data class Emerald(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null
                )

                @Keep
                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null
                )

                @Keep
                data class RubySapphire(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null
                )
            }

            @Keep
            data class GenerationIv(
                @SerializedName("diamond-pearl")
                val diamondPearl: DiamondPearl? = null,
                @SerializedName("heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver? = null,
                val platinum: Platinum? = null
            ) {
                @Keep
                data class DiamondPearl(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )

                @Keep
                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )

                @Keep
                data class Platinum(
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )
            }

            @Keep
            data class GenerationV(
                @SerializedName("black-white")
                val blackWhite: BlackWhite? = null
            ) {
                @Keep
                data class BlackWhite(
                    val animated: Animated? = null,
                    @SerializedName("back_default")
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                ) {
                    @Keep
                    data class Animated(
                        @SerializedName("back_default")
                        val backDefault: String? = null,
                        @SerializedName("back_female")
                        val backFemale: Any? = null,
                        @SerializedName("back_shiny")
                        val backShiny: String? = null,
                        @SerializedName("back_shiny_female")
                        val backShinyFemale: Any? = null,
                        @SerializedName("front_default")
                        val frontDefault: String? = null,
                        @SerializedName("front_female")
                        val frontFemale: Any? = null,
                        @SerializedName("front_shiny")
                        val frontShiny: String? = null,
                        @SerializedName("front_shiny_female")
                        val frontShinyFemale: Any? = null
                    )
                }
            }

            @Keep
            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
                @SerializedName("x-y")
                val xY: XY? = null
            ) {
                @Keep
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )

                @Keep
                data class XY(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )
            }

            @Keep
            data class GenerationVii(
                val icons: Icons? = null,
                @SerializedName("ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon? = null
            ) {
                @Keep
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null
                )

                @Keep
                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any? = null
                )
            }

            @Keep
            data class GenerationViii(
                val icons: Icons? = null
            ) {
                @Keep
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    val frontFemale: Any? = null
                )
            }
        }
    }

    @Keep
    data class Stat(
        @SerializedName("base_stat")
        val baseStat: Int? = null,
        val effort: Int? = null,
        val stat: Stat? = null
    ) {
        @Keep
        data class Stat(
            val name: String? = null,
            val url: String? = null
        )
    }

    @Keep
    data class Type(
        val slot: Int? = null,
        val type: Type? = null
    ) {
        @Keep
        data class Type(
            val name: String? = null,
            val url: String? = null
        )
    }
}