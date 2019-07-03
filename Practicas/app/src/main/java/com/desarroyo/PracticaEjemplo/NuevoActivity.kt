package com.desarroyo.PracticaEjemplo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nuevo.*


class NuevoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.desarroyo.practicas.R.layout.activity_nuevo)

        val intent = intent

        val texto = intent?.getStringExtra("texto")

        txtDestino.setText(texto)

        //Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        getSharedPreferences()

    }


    private fun getSharedPreferences(){
        val sharedPreferences = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE)

        var texto:String? = sharedPreferences.getString("texto", "N/A")

        //lblDato.setText(texto)
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()

    }
}
