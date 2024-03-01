package com.example.roadmapproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.roadmapproject.R.id.pager2View
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2WithFragmentsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_with_fragments)

        val pictures= arrayOf("Abdul Rauf","old Picture","Any Image","flower")

        val viewPager2=findViewById<ViewPager2>(pager2View)
        val layoutTab=findViewById<TabLayout>(R.id.tabLayout)

        val adapter=ViewPager2FragmentStateAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter

        TabLayoutMediator(layoutTab,viewPager2){tab,position ->
            tab.text=pictures[position]
        }.attach()
    }
}