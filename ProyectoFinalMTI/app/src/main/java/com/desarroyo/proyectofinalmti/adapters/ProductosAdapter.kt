package com.desarroyo.proyectofinalmti.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.proyectofinalmti.R
import com.desarroyo.proyectofinalmti.models.Producto
import kotlinx.android.synthetic.main.card_producto.view.*

class ProductosAdapter(val context: Context, val listProducto: ArrayList<Producto>) : RecyclerView.Adapter<ProductosAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.card_producto, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProducto.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(position, listProducto[position])
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(pos: Int, currentProducto: Producto){

            itemView.txtProductoNombre.text = currentProducto.producto_nombre
            itemView.txtProductoPrecio.text = "$ "+currentProducto.producto_precio.toString()
            itemView.imgProducto.setImageResource(currentProducto.producto_img)

            itemView.setOnClickListener {
                Toast.makeText(context, "Posición: " + pos, Toast.LENGTH_SHORT).show()
            }

        }

    }

}