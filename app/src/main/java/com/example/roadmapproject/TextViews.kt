package com.example.roadmapproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
//import com.example.roadmapproject.databinding.ActivityMain2Binding
import com.example.roadmapproject.databinding.ActivityTextViewsBinding

class TextViews : AppCompatActivity() {
    private lateinit var binding: ActivityTextViewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_views)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_text_views)

        binding.textView1.text=intent.getStringExtra("FirstName")
        binding.textView2.text=intent.getStringExtra("LastName")
        binding.textView3.text=intent.getStringExtra("Email")
        binding.textView4.text=intent.getStringExtra("Phone")
        binding.textView5.text=intent.getStringExtra("Phone2")
        binding.textView6.text=intent.getStringExtra("Password")
        binding.textView7.text=intent.getStringExtra("Password2")
        binding.textView8.text=intent.getStringExtra("Gender")

        binding.button.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }
}