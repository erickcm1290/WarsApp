package com.ecm.warsapp.UI.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecm.theapp.Utilities.UTBaseFragment
import com.ecm.warsapp.API.MainActivityInterface
import com.ecm.warsapp.Core.Constants
import com.ecm.warsapp.Data.Models.Models
import com.ecm.warsapp.Data.Network.IApi
import com.ecm.warsapp.UI.Adapters.AdapterGalactico
import com.ecm.warsapp.Utilities.RequestManager
import com.ecm.warsapp.databinding.FragmentPersonajesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentListado : UTBaseFragment() , AdapterGalactico.itemClick{

    private var interfaz: MainActivityInterface? = null
    private var binding: FragmentPersonajesBinding? = null
    private var personajesstarwars : List<Models.Personaje?>? = null
    lateinit var adapter: AdapterGalactico



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonajesBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        consultaGalactica()
    }


    fun consultaGalactica() {
        interfaz!!.mostrarProgress(true)
        val requestManager = RequestManager(Constants.BASE_URL)
        requestManager.create(IApi::class.java).getPersonajes()
            .enqueue(object : Callback<List<Models.Personaje?>> {

                override fun onResponse(
                    call: Call<List<Models.Personaje?>>,
                    response: Response<List<Models.Personaje?>>
                ) {
                    try {
                        if (response.body()!!.isEmpty()) {
                            Log.d("Starwars", "onResponse: No se encontraron personajes")
                        } else {
                            personajesstarwars = response.body()
                        }
                    } catch (e: Exception) {

                    }
                    interfaz!!.mostrarProgress(false)
                }
                override fun onFailure(call: Call<List<Models.Personaje?>>, t: Throwable) {
                    interfaz!!.mostrarProgress(false)

                }
            })
    }


    private fun listaAvisos() {
        interfaz!!.mostrarProgress(true)
        adapter = AdapterGalactico(personajesstarwars, this)
        binding?.rvGalactico?.layoutManager = LinearLayoutManager(context)
        binding?.rvGalactico?.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 1)
        binding?.rvGalactico?.setLayoutManager(layoutManager)
        binding?.rvGalactico?.adapter = adapter
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivityInterface) {
            interfaz = context
        }
    }

    override fun onBackPressed(): Boolean {
        activity?.moveTaskToBack(true)
        return super.onBackPressed()
    }

    override fun onClick(persona: Models.Personaje) {
        interfaz!!.mostrarFragmentDetalle(persona)
    }
}