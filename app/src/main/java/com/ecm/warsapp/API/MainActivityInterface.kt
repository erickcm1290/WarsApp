package com.ecm.warsapp.API

import com.ecm.warsapp.Data.Models.Models

interface MainActivityInterface {
    fun mostrarFragmentInicial()
    fun mostrarFragmentListado()
    fun mostrarFragmentDetalle(persona : Models.Personaje)
    fun mostrarFragmentBusqueda()
    fun mostrarProgress(valor: Boolean?)

}