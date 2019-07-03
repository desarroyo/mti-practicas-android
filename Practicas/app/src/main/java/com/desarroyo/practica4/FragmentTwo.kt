package com.desarroyo.practica4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.desarroyo.practicas.R


class FragmentTwo : Fragment() {
    private lateinit var btnFragment2: Button
    companion object{
        fun newInstance() : FragmentTwo{
            return FragmentTwo()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fragment_two, container, false)

        btnFragment2 = view.findViewById(R.id.btnFragment2)
        btnFragment2.setOnClickListener {
            Toast.makeText(view.context, "Este es el fragmento 2", Toast.LENGTH_SHORT).show()
        }
        return view
    }


}
