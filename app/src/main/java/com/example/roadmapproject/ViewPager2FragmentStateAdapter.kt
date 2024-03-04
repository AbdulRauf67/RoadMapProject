package com.example.roadmapproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2FragmentStateAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    private val numberOfTabs=4
    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2-> Tab3Fragment()
            else -> Tab4Fragment()
        }
    }
}