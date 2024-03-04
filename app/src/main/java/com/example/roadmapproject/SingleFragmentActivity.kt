@file:Suppress("DEPRECATION")

package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

@Suppress("DEPRECATION")
class SingleFragmentActivity : AppCompatActivity() {
    private val fragmentManager1=supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)
    }

    fun onFirstClick(view: View) {
        val fragmentTansition =fragmentManager1.beginTransaction()
        fragmentTansition.add(R.id.frameLayoutfragment,SimpleFirstFragment())
        fragmentTansition.addToBackStack(null)
        fragmentTansition.commit()
    }
    fun onSecondClick(view: View) {
        val fragmentTansition =fragmentManager1.beginTransaction()
        fragmentTansition.add(R.id.frameLayoutfragment,SimpleSecondFragment())
        fragmentTansition.addToBackStack(null)
        fragmentTansition.commit()
    }
}