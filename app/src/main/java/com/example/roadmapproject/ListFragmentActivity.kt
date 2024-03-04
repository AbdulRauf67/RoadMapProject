package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityListFragmentBinding

class ListFragmentActivity : AppCompatActivity() {
    private lateinit var binding:ActivityListFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fragment)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_list_fragment)

        val fragmentManage=supportFragmentManager

        val fragmentTrasections=supportFragmentManager.beginTransaction()
        fragmentTrasections.add(R.id.frameLayoutForListFragment,FirstListFragment())
        fragmentTrasections.addToBackStack(null)
        fragmentTrasections.commit()

    }
}