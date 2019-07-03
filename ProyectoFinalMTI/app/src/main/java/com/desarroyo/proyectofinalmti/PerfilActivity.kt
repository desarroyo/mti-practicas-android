package com.desarroyo.proyectofinalmti

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE)

        lblNombre.setText(editor.getString("nombre", "N/A"))
        lblPerfilUsuario.setText(editor.getString("usuario", "N/A"))
        txtPerfilNombre.setText(editor.getString("nombre", "N/A"))
        txtPerfilTelefono.setText(editor.getString("usuario", "N/A"))
        txtPerfilEdad.setText(editor.getString("edad", "N/A"))
        txtPerfilSexo.setText(editor.getString("sexo", "N/A"))
        txtPerfilPassword.setText(editor.getString("password", ""))

        btnPerfilActualizar.setOnClickListener {
            val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE).edit()

            editor.putString("password",txtPerfilPassword.text.toString())
            editor.putString("sexo",txtPerfilSexo.text.toString())
            editor.putString("edad",txtPerfilEdad.text.toString())
            editor.putString("nombre",txtPerfilNombre.text.toString())
            editor.putString("telefono",txtPerfilTelefono.text.toString())
            editor.apply()

            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
