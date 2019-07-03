package com.desarroyo.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.activity_practica1.*

class Practica1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1)


        btn1.setOnClickListener {
            val intent = Intent(this, Pantalla1Activity::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, Pantalla2Activity::class.java)
            startActivity(intent)
        }

        btn22.setOnClickListener {
            val intent = Intent(this, Pantalla2v2Activity::class.java)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(this, Pantalla3Activity::class.java)
            startActivity(intent)
        }
    }

}
