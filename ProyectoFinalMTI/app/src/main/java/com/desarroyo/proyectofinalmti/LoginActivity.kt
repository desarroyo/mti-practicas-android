package com.desarroyo.proyectofinalmti

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var txtNombre : EditText
    private lateinit var txtPassword : EditText
    private lateinit var btnLogin : Button

    private lateinit var lblLogin : TextView

    private final var _USER = "admin"
    private final var _PASS = "123456"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        initComponents();
        initListeners();

        val intent = intent

        val sharedUsuario = intent?.getStringExtra("usuario")

        txtNombre.setText(sharedUsuario)

        //Acciones Edit Text
        //txtNombre.setText("David");


    }

    //match
    private fun initComponents(){

        txtNombre = findViewById(R.id.txtNombre);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        lblLogin = findViewById(R.id.lblLogin);
    }

    private fun initListeners(){

        btnRegistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        btnLogin.setOnClickListener {
            //val intent = Intent(this, Pantalla1Activity::class.java)
            //startActivity(intent)
            var nombre:String = txtNombre.text.toString();
            var pass:String = txtPassword.text.toString();


            val editor = this.getSharedPreferences("com.desarroyo.persistencia", Context.MODE_PRIVATE)

            val sharedUsuario = editor.getString("usuario", "");
            val sharedPassword = editor.getString("password", "");


            if(nombre.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Favor de completar tus credenciales", Toast.LENGTH_SHORT).show()

            }
            else if(sharedUsuario == nombre && sharedPassword == pass){
                Toast.makeText(this, "Login Correcto", Toast.LENGTH_SHORT).show()

                var home = Intent(this, MainActivity::class.java)
                home.putExtra("usuario", sharedUsuario)

                startActivity(home)
                //startActivity(Intent(this, Pantalla1Activity::class.java))
            }else{
                Toast.makeText(this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
            }

            //Toast.makeText(this, "Nombre: " + nombre + "\nPass: "+pass, Toast.LENGTH_SHORT).show()

        }
    }

}
