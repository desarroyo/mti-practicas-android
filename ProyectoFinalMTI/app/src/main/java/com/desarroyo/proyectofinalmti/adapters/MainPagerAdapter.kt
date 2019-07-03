package com.desarroyo.proyectofinalmti.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.desarroyo.practica4.FragmentProductos
import com.desarroyo.practica4.FragmentMapa
import com.desarroyo.practica4.FragmentEventos
import com.desarroyo.proyectofinalmti.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return FragmentEventos.newInstance()
            1 -> return FragmentProductos.newInstance()
            else -> return FragmentMapa.newInstance()

        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}