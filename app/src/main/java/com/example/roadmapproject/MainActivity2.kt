package com.example.roadmapproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
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
        var value:String
        /* if(binding.radioGroup.checkedRadioButtonId){
            value="Male"
        }else if (!binding.radioButton2.isChecked){
            value="Female"
        }else
        {
            value="Not Selected"
        } */

        value=binding.radioGroup.checkedRadioButtonId.toString()

        binding.InfoBtn.setOnClickListener(View.OnClickListener {
            var intent1= Intent(this,TextViews::class.java)
            intent1.putExtra("FirstName",binding.editTextText.text.toString())
            intent1.putExtra("LastName",binding.editTextText2.text.toString())
            intent1.putExtra("Email",binding.editTextTextEmailAddress.text.toString())
            intent1.putExtra("Phone",binding.editTextPhone.text.toString())
            intent1.putExtra("Phone2", binding.editTextNumber2.text.toString())
            intent1.putExtra("Password",binding.editTextTextPassword.text.toString())
            intent1.putExtra("Password2",binding.editTextTextPassword2.text.toString())
            intent1.putExtra("Gender",value)
            startActivity(intent1)
        })
    }
}