@file:Suppress("DEPRECATION")

package com.example.roadmapproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    lateinit var fragmentlist1:ArrayList<Fragment>

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2 -> Tab3Fragment()
            else -> Tab4Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Tab 1"
            1 -> "Tab 2"
            2 -> "Tab 3"
            else -> "Tab 4"
        }
        return super.getPageTitle(position)
    }
    fun addFragment(fragment: Fragment){
        fragmentlist1.add(fragment)
    }
}