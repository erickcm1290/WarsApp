package com.ecm.warsapp.UI.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecm.warsapp.API.MainActivityInterface
import com.ecm.warsapp.Data.Models.Models
import com.ecm.warsapp.R
import com.ecm.warsapp.databinding.ItemPersonajeBinding

class AdapterGalactico(
    val personajes: List<Models.Personaje?>?,
    private val itemClickListener: itemClick?
) :
    RecyclerView.Adapter<AdapterGalactico.ViewHolder>() {
    var interfaz: MainActivityInterface? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = personajes!![position]
        holder.bind(item!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_personaje, parent, false))
    }

    override fun getItemCount(): Int {
        return personajes!!.size
    }

    interface itemClick {
        fun onClick(persona: Models.Personaje)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPersonajeBinding.bind(view)
        fun bind(individuo: Models.Personaje) {
            binding.nacimiento.text = individuo.nacimiento
            binding.nombre.text = individuo.nombre
            binding.planeta.text = individuo.planeta
            //Glide.with(context)
            //    .load(individuo.urlimagen)
            //    .into(binding.imagen)
            binding.cvPersonaje.setOnClickListener {
            }
        }
    }
}