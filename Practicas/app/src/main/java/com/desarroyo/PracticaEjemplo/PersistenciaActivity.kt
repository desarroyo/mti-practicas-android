package com.desarroyo.PracticaEjemplo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.desarroyo.practicas.R

class PersistenciaActivity : AppCompatActivity() {

    private lateinit var  txtTexto: EditText
    private lateinit var  btnGuardar: Button
    private lateinit var  btnMostrar: Button
    private lateinit var  lblDato: TextView

    private lateinit var  btnNuevaVentana: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistencia)

        initComponents()


    }


    private fun initComponents(){
        txtTexto = findViewById(R.id.txtTexto)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnNuevaVentana = findViewById(R.id.btnNuevaVentana)
        lblDato = findViewById(R.id.lblDato)

        btnGuardar.setOnClickListener { saveSharedPreferences() }
        btnMostrar.setOnClickListener { getSharedPreferences() }

        btnNuevaVentana.setOnClickListener { enviarSharedPreferences() }
    }

    private fun enviarSharedPreferences(){
        var ir = Intent(this, NuevoActivity::class.java)
        ir.putExtra("texto", txtTexto.text.toString())
        startActivity(ir)
    }

    private fun saveSharedPreferences(){
        var texto:String = txtTexto.text.toString()

        //val prefs = this.getSharedPreferences(PREFS_FILENAME, 0)
        val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE).edit()

        editor.putString("texto",texto)
        editor.apply()

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()

    }

    private fun getSharedPreferences(){
        val sharedPreferences = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE)

        var texto:String? = sharedPreferences.getString("texto", "N/A")

        lblDato.setText(texto)
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()

    }
}
