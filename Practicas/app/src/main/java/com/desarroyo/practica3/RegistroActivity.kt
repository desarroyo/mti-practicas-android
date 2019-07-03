package com.desarroyo.practica3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.desarroyo.practica2.LoginActivity
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnguardar.setOnClickListener { guardar() }
    }

    private fun guardar(){

        if(!txtUsuario.text.isEmpty() &&!txtPassword.text.isEmpty() &&!txtSexo.text.isEmpty() &&!txtEdad.text.isEmpty() ){
            val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE).edit()

            editor.putString("usuario",txtUsuario.text.toString())
            editor.putString("password",txtPassword.text.toString())
            editor.putString("sexo",txtSexo.text.toString())
            editor.putString("edad",txtEdad.text.toString())
            editor.apply()

            Toast.makeText(this, "Usuario '"+txtUsuario.text.toString()+"' registrado", Toast.LENGTH_SHORT).show()

            var loginActivity = Intent(this, LoginActivity::class.java)
            loginActivity.putExtra("usuario", txtUsuario.text.toString())
            loginActivity.putExtra("password", txtPassword.text.toString())
            startActivity(loginActivity)
        }else{
            Toast.makeText(this, "Favor de completar los datos", Toast.LENGTH_SHORT).show()

        }


    }
}
