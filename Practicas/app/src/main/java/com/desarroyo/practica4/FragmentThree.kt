package com.desarroyo.practica4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.desarroyo.practicas.R


class FragmentThree : Fragment() {

    private lateinit var btnFragment3: Button

    companion object{
        fun newInstance() : FragmentThree{
            return FragmentThree()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fragment_three, container, false)

        btnFragment3 = view.findViewById(R.id.btnFragment3)
        btnFragment3.setOnClickListener {
            Toast.makeText(view.context, "Este es el fragmento 3", Toast.LENGTH_SHORT).show()
        }
        return view
    }


}
