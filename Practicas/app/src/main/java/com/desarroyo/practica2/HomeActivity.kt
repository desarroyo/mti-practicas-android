package com.desarroyo.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val intent = intent

        val usuario = intent?.getStringExtra("usuario")

        txtUsuario.setText(usuario)
        Toast.makeText(this, usuario, Toast.LENGTH_SHORT).show()
    }
}
