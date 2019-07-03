package com.desarroyo.proyectofinalmti

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnPerfilActualizar.setOnClickListener { guardar() }

        btnRegistroLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun guardar(){

        if(!txtRegistroUsuario.text.isEmpty() &&!txtRegistroPassword.text.isEmpty() &&!txtRegistroSexo.text.isEmpty() &&!txtRegistroEdad.text.isEmpty() ){
            val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE).edit()

            editor.putString("usuario",txtRegistroUsuario.text.toString())
            editor.putString("password",txtRegistroPassword.text.toString())
            editor.putString("sexo",txtRegistroSexo.text.toString())
            editor.putString("edad",txtRegistroEdad.text.toString())
            editor.putString("nombre",txtRegistroNombre.text.toString())
            editor.putString("telefono",txtRegistroTelefono.text.toString())
            editor.apply()

            Toast.makeText(this, "Usuario '"+txtRegistroUsuario.text.toString()+"' registrado", Toast.LENGTH_SHORT).show()

            var loginActivity = Intent(this, LoginActivity::class.java)
            loginActivity.putExtra("usuario", txtRegistroUsuario.text.toString())
            loginActivity.putExtra("password", txtRegistroPassword.text.toString())
            startActivity(loginActivity)
        }else{
            Toast.makeText(this, "Favor de completar los datos", Toast.LENGTH_SHORT).show()

        }


    }
}
