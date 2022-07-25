package com.tepe.detailedpokemon.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val hd: String?,
    val thumbnail: String?,
    val _number: Long,
    val description: String? = null,
    val experience: String? = null,
    val height: String? = null,
    val weight: String? = null,
    val order: String? = null,
) : Parcelable {
    val number: String get() = _number.toString().zeros

    private val String.zeros
        get() = '#' + when (length) {
            1 -> "00"
            2 -> "0"
            else -> ""
        } + this
}