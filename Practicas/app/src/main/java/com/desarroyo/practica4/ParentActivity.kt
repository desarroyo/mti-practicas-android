package com.desarroyo.practica4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.desarroyo.practicas.R
import com.google.android.material.tabs.TabLayout

class ParentActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)

        tabs = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.viewpager)


        val adapter = ParentPagerAdapter(supportFragmentManager)
        viewpager!!.adapter = adapter
        tabs!!.setupWithViewPager(viewpager)


        tabs!!.getTabAt(0)?.setText("F 1")
        tabs!!.getTabAt(0)?.setIcon(R.drawable.abc_ic_arrow_drop_right_black_24dp)

        tabs!!.getTabAt(1)?.setText("F 2")
        tabs!!.getTabAt(1)?.setIcon(R.drawable.ic_mtrl_chip_close_circle)

        tabs!!.getTabAt(2)?.setText("F 3")
        tabs!!.getTabAt(2)?.setIcon(R.drawable.abc_ic_voice_search_api_material)


    }
}
