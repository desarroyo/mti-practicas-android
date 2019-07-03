package com.desarroyo.practica5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.card_food.view.*

class FoodAdapter(val context: Context, val listFood: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.card_food, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(position, listFood[position])
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(pos: Int, currentFood: Food){

            itemView.txtTitle.text = currentFood.food_name
            itemView.txtRate.text = currentFood.min_rate.toString()
            itemView.txtTotal.text = currentFood.total_rate.toString()
            itemView.txtPrice.text = "$ "+currentFood.price.toString()
            itemView.txtPhone.text = "(+52) "+currentFood.phone
            itemView.imgFood.setImageResource(currentFood.image)

            itemView.setOnClickListener {
                Toast.makeText(context, "Posición: " + pos, Toast.LENGTH_SHORT).show()
            }

        }

    }

}