package com.ecm.warsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecm.theapp.Utilities.UTBaseActivity
import com.ecm.warsapp.API.MainActivityInterface
import com.ecm.warsapp.Data.Models.Models
import com.ecm.warsapp.UI.Fragments.FragmentListado
import com.ecm.warsapp.UI.Fragments.FragmentMain
import com.ecm.warsapp.databinding.ActivityMainBinding

class MainActivity : UTBaseActivity() , MainActivityInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun mostrarFragmentInicial() {
        showFragment(FragmentMain::class.java, binding.clMain.id, null, true, true)
    }

    override fun mostrarFragmentListado() {
        showFragment(FragmentListado::class.java, binding.clMain.id, null, true, true)
    }

    override fun mostrarFragmentDetalle(persona : Models.Personaje) {
        showFragment(FragmentListado::class.java, binding.clMain.id, null, true, true)
    }

    override fun mostrarFragmentBusqueda() {
        TODO("Not yet implemented")
    }

    override fun mostrarProgress(valor: Boolean?) {

    }


}