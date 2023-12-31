package com.example.roadmapproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.button1.setOnClickListener(View.OnClickListener {
            var `intent-var`=Intent(this,MainActivity2::class.java)
            startActivity(`intent-var`)
        })
        binding.button.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,TextViews::class.java)
            startActivity(intent)
        })
        binding.cardViewBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,CardViewDesign::class.java)
            startActivity(intent)
        })
        binding.webSiteBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,WebSiteView::class.java)
            startActivity(intent)
        })


    }
}