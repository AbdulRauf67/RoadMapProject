package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityChipsShownBinding
import com.example.roadmapproject.databinding.ActivityListFragmentBinding

class ChipsShownActivity : AppCompatActivity() {
    lateinit var binding: ActivityChipsShownBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chips_shown)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_chips_shown)

        binding.chip11.setOnCloseIconClickListener{
            binding.chipGroup3.removeView(it)
            Toast.makeText(this,"Removed 11th Chip",Toast.LENGTH_LONG).show()
        }
        binding.chip12.setOnCloseIconClickListener{
            binding.chipGroup3.removeView(it)
            Toast.makeText(this,"Removed 12th Chip",Toast.LENGTH_LONG).show()
        }
        binding.chip13.setOnCloseIconClickListener{
            binding.chipGroup3.removeView(it)
            Toast.makeText(this,"Removed 13th Chip",Toast.LENGTH_LONG).show()
        }
        binding.chip14.setOnCloseIconClickListener{
            binding.chipGroup3.removeView(it)
            Toast.makeText(this,"Removed 14th Chip",Toast.LENGTH_LONG).show()
        }
        binding.chip15.setOnCloseIconClickListener{
            binding.chipGroup3.removeView(it)
            Toast.makeText(this,"Removed 15th Chip",Toast.LENGTH_LONG).show()
        }
    }
}