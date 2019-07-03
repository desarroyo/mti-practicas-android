package com.desarroyo.practica4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.desarroyo.proyectofinalmti.R
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions



class FragmentMapa : Fragment() , OnMapReadyCallback{

    private lateinit var mMap: GoogleMap

    companion object{
        fun newInstance() : FragmentMapa{
            return FragmentMapa()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_mapa, container, false)


        val mapFragment: SupportMapFragment  =  childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val auditorio = LatLng(20.733609, -103.381336)
        val zoomLevel = 16.0f;
        mMap.addMarker(MarkerOptions().position(auditorio).title("Auditorio Telmex"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(auditorio,zoomLevel))
    }


}
