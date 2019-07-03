package com.desarroyo.practica5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.practicas.R

class ListasActivity : AppCompatActivity() {

    private lateinit var rvMainFood : RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listas)

        rvMainFood = findViewById(R.id.rvMainFood)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvMainFood.layoutManager = layoutManager

        //class Food(food_name, min_rate, total_rate, price, phone, image)

        val listFood: ArrayList<Food> = ArrayList()
        listFood.add( Food("Alitas",20,50,100.0,"3318932211", R.drawable.alitas))
        listFood.add( Food("Burguer",90,100,80.00,"3318932211", R.drawable.burguer))
        listFood.add( Food("Hot_Cakes",60,80,50.00,"3318932211", R.drawable.hot_cakes))
        listFood.add( Food("Huevo",70,90,70.00,"3318932211", R.drawable.huevo))
        listFood.add( Food("Pescado",30,50,120.00,"3318932211", R.drawable.pescado))
        listFood.add( Food("Pizza",40,60,180.00,"3318932211", R.drawable.pizza))
        listFood.add( Food("Tacos",30,50,60.00,"3318932211", R.drawable.tacos))


        val adapter = FoodAdapter(this,listFood)
        rvMainFood.adapter = adapter

    }
}
