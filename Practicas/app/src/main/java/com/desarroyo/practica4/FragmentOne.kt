package com.desarroyo.practica4


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.desarroyo.practicas.R
//import kotlinx.android.synthetic.main.fragment_fragment_one2.*



class FragmentOne : Fragment() {

    private lateinit var btnFragment1: Button

    companion object{
        fun newInstance() : FragmentOne{
            return FragmentOne()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_fragment_one, container, false)

        btnFragment1 = view.findViewById(R.id.btnFragment1)
        btnFragment1.setOnClickListener {
            Toast.makeText(view.context, "Este es el fragmento 1", Toast.LENGTH_SHORT).show()
        }
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context != null) {



        }
    }


}
