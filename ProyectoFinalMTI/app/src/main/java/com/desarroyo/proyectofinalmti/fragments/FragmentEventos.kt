package com.desarroyo.practica4


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.desarroyo.proyectofinalmti.R
import com.desarroyo.proyectofinalmti.adapters.EventoAdapter
import com.desarroyo.proyectofinalmti.models.Evento
import org.jetbrains.anko.doAsync
import org.json.JSONObject


class FragmentEventos : Fragment() {

    private lateinit var rvMainContact : RecyclerView
    private var listEventos: ArrayList<Evento> = ArrayList()

    companion object{
        fun newInstance() : FragmentEventos{
            return FragmentEventos()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_eventos, container, false)

        rvMainContact = view.findViewById(R.id.rvMainContact)

        rvMainContact.layoutManager = GridLayoutManager(view.context, 2)

        getContacts(view.context)

        return view
    }


    private fun getContacts(context: Context){
        doAsync {

            val requestQueue: RequestQueue = Volley.newRequestQueue(context)

            val url = "http://www.mocky.io/v2/5d1ceeb034000001b2b6015e"

            var strRequest = object : StringRequest(Method.GET, url,
                Response.Listener {
                        s-> Log.e("TAG", s.toString())

                    val jsonResponse = JSONObject(s)

                    val arrayEmployees = jsonResponse.getJSONArray("Evntos")


                    for (i in 0 until arrayEmployees.length()){

                        var currentObject = arrayEmployees.getJSONObject(i)
                        listEventos.add( Evento(
                            currentObject.getString("img"),
                            currentObject.getString("nombre"),
                            currentObject.getString("fecha"),
                            currentObject.getString("hora")
                        )
                        )
                    }


                    val adapter = EventoAdapter(context,listEventos)
                    rvMainContact.adapter = adapter

                }, Response.ErrorListener{
                        s-> Log.e("TAG", s.toString())
                }){}

            requestQueue.add(strRequest)
        }
    }

}
