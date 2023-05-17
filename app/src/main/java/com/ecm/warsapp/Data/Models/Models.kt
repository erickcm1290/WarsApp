package com.ecm.warsapp.Data.Models

import com.google.gson.annotations.SerializedName

class Models {

    data class respuestaStarWarsJson(
        var respuesta : List<Personaje>
    )

    data class Personaje(
        @SerializedName("name") var nombre: String,
        @SerializedName("born") var nacimiento: String,
        @SerializedName("gender") var genero: String,
        @SerializedName("height") var altura: String,
        @SerializedName("mass") var peso: String,
        @SerializedName("species") var especie: String,
        @SerializedName("homeworld") var planeta: String,
        @SerializedName("image") var urlimagen: String,
        @SerializedName("affiliations") var peliculas: List<String>,
        @SerializedName("formerAffiliations") var afiliaciones: List<String>,
    )
}