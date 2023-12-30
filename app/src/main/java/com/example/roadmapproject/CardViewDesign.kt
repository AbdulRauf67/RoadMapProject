package com.example.roadmapproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.R.layout.activity_card_view
import com.example.roadmapproject.databinding.ActivityCardViewBinding

class CardViewDesign : AppCompatActivity() {
    private lateinit var binding: ActivityCardViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_card_view)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_card_view)

        binding.button4.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }
}