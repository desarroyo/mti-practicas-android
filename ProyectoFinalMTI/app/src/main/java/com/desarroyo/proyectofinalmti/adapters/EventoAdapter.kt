package com.desarroyo.proyectofinalmti.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.proyectofinalmti.R
import com.desarroyo.proyectofinalmti.models.Evento
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_evento.view.*

class EventoAdapter(val context: Context, val listEventos: ArrayList<Evento>) : RecyclerView.Adapter<EventoAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.card_evento, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listEventos.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(position, listEventos[position])
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(pos: Int, current: Evento){

            itemView.txtNombre.text = current.nombre
            itemView.txtFecha.text = current.fecha
            itemView.txtHora.text = current.hora
            Picasso.get().load(current.img).placeholder(R.drawable.profile).into(itemView.imgEvento);

            itemView.setOnClickListener {
                Toast.makeText(context, "Posición: " + pos, Toast.LENGTH_SHORT).show()
            }

        }

    }

}