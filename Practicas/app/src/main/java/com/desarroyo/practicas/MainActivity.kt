package com.desarroyo.practicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desarroyo.practica1.Practica1Activity
import com.desarroyo.practica2.LoginActivity
import com.desarroyo.practica3.RegistroActivity
import com.desarroyo.practica4.ParentActivity
import com.desarroyo.practica5.ListasActivity
import com.desarroyo.practica6.Practica6Activity
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnP1.setOnClickListener {
            val intent = Intent(this, Practica1Activity::class.java)
            startActivity(intent)
        }

        btnP2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnP3.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        btnP4.setOnClickListener {
            val intent = Intent(this, ParentActivity::class.java)
            startActivity(intent)
        }

        btnP5.setOnClickListener {
            val intent = Intent(this, ListasActivity::class.java)
            startActivity(intent)
        }

        btnP6.setOnClickListener {
            val intent = Intent(this, Practica6Activity::class.java)
            startActivity(intent)
        }
    }
}
