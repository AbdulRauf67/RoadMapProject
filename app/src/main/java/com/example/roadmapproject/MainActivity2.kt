package com.example.roadmapproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityMain2Binding
import com.example.roadmapproject.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main2)

        binding.HomeBtn.setOnClickListener(View.OnClickListener {
            var intent1=Intent(this,MainActivity::class.java)
            startActivity(intent1)
        })

        binding.InfoBtn.setOnClickListener(View.OnClickListener {

        })
    }
}