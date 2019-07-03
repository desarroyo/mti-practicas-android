package com.desarroyo.practica4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ParentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return FragmentOne.newInstance()
            1 -> return FragmentTwo.newInstance()
            else -> return FragmentThree.newInstance()

        }
    }

    override fun getCount(): Int {
        return 3
    }


}