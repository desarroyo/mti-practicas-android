package com.desarroyo.practica6

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.desarroyo.practicas.R
import org.jetbrains.anko.doAsync
import org.json.JSONObject

class Practica6Activity : AppCompatActivity() {

    private lateinit var rvMainContact : RecyclerView
    private var listContacts: ArrayList<Contact> = ArrayList()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica6)

        rvMainContact = findViewById(R.id.rvMainContact)

        rvMainContact.layoutManager = GridLayoutManager(this, 2)

        /*
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvMainContact.layoutManager = layoutManager
        */

/*
        listContacts.add( Contact("rirani","Developer","Romin","Irani","Romin Irani","E1","CA","408-1234567","romin.k.irani@gmail.com"))
        listContacts.add( Contact("nirani","Developer", "Neil","Irani", "Neil Irani","E2","CA","408-1111111", "neilrirani@gmail.com"))
        listContacts.add( Contact("thanks", "Directory","Tom","Hanks","Tom Hanks","E3","CA","408-2222222", "tomhanks@gmail.com"))
        listContacts.add( Contact("rirani","Developer","Romin","Irani","Romin Irani","E1","CA","408-1234567","romin.k.irani@gmail.com"))
        listContacts.add( Contact("nirani","Developer", "Neil","Irani", "Neil Irani","E2","CA","408-1111111", "neilrirani@gmail.com"))
        listContacts.add( Contact("thanks", "Directory","Tom","Hanks","Tom Hanks","E3","CA","408-2222222", "tomhanks@gmail.com"))
        listContacts.add( Contact("rirani","Developer","Romin","Irani","Romin Irani","E1","CA","408-1234567","romin.k.irani@gmail.com"))
        listContacts.add( Contact("nirani","Developer", "Neil","Irani", "Neil Irani","E2","CA","408-1111111", "neilrirani@gmail.com"))
        listContacts.add( Contact("thanks", "Directory","Tom","Hanks","Tom Hanks","E3","CA","408-2222222", "tomhanks@gmail.com"))
*/
        /*
        val adapter = ContactAdapter(this,listContacts)
        rvMainContact.adapter = adapter
        */
         getContacts(applicationContext)
    }

    private fun getContacts(context: Context){
        doAsync {

            val requestQueue: RequestQueue = Volley.newRequestQueue(context)

            val url = "http://www.mocky.io/v2/5d1aa3c93400006a00000298"

            var strRequest = object : StringRequest(Method.GET, url,
                Response.Listener {
                s-> Log.e("TAG", s.toString())

                    val jsonResponse = JSONObject(s)

                    val arrayEmployees = jsonResponse.getJSONArray("Employees")


                    for (i in 0 until arrayEmployees.length()){

                        var currentObject = arrayEmployees.getJSONObject(i)
                        listContacts.add( Contact(
                            currentObject.getString("userId"),
                            currentObject.getString("jobTitleName"),
                            currentObject.getString("firstName"),
                            currentObject.getString("lastName"),
                            currentObject.getString("preferredFullName"),
                            currentObject.getString("employeeCode"),
                            currentObject.getString("region"),
                            currentObject.getString("phoneNumber"),
                            currentObject.getString("emailAddress")
                            )
                        )
                    }


                    val adapter = ContactAdapter(context,listContacts)
                    rvMainContact.adapter = adapter

            }, Response.ErrorListener{
                s-> Log.e("TAG", s.toString())
            }){}

            requestQueue.add(strRequest)
        }
    }
}
