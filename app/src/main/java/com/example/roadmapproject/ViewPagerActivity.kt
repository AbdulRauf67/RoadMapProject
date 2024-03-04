package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
//import com.android.car.ui.toolbar.TabLayout
import com.google.android.material.tabs.TabLayout
class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val viewPager=findViewById<ViewPager>(R.id.pagerView)
        val layoutTab=findViewById<TabLayout>(R.id.tabLayout)

        var adapter=ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter=adapter
        layoutTab.setupWithViewPager(viewPager)
    }
}