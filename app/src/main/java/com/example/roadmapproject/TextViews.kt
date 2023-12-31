package com.example.roadmapproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
//import com.example.roadmapproject.databinding.ActivityMain2Binding
import com.example.roadmapproject.databinding. ActivityTextViewsBinding
import java.time.DayOfWeek

class TextViews : AppCompatActivity() {
    private lateinit var binding: ActivityTextViewsBinding
    private var progressBarStatus=0
    private var dummy = 0

    private var handler=Handler(Looper.myLooper()!!)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_views)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_text_views)

/*
        var progress=0

        binding.incrementBtn.setOnClickListener(View.OnClickListener {
            binding.progressBar.visibility=View.VISIBLE
            if (progress<100){
                progress += 10
                binding.progressBar.setProgress(progress)
                binding.progress.setText(progress.toString()+"%")

            }
        })
        binding.DecrementBtn.setOnClickListener(View.OnClickListener {
            if (progress>0){
                progress -= 10
                binding.progressBar.setProgress(progress)
                binding.progress.setText(progress.toString()+"%")
            }
        })

 */

        binding.timePicker.setOnTimeChangedListener { _, hours, minute ->
            var hour=hours
            var pm_am=" "
            when{
                hours == 0 -> {
                    hour += 12
                    pm_am="AM"
                }
                hours == 12 -> {
                    pm_am="PM"
                }
                hours > 12 -> {
                    hour -= 12
                    pm_am="PM"
                }
                else -> pm_am="AM"
            }
            val hour1 = if(hour<10 ) "0"+hour else hour
            val minutes = if (minute<10) "0"+minute else minute
            val smg="$hour1 : $minutes $pm_am"
            binding.editTextTime3.setText(smg)
        }

        var datepicker=binding.datepicker
        binding.datepicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth, ->
            var month=monthOfYear+1
            var msg="$dayOfMonth/$month/$year "
            binding.editTextDate2.setText(msg)
        }




        binding.button3.setOnClickListener(View.OnClickListener {

            binding.textView1.text = intent.getStringExtra("FirstName")
            binding.textView2.text = intent.getStringExtra("LastName")
            binding.textView3.text = intent.getStringExtra("Email")
            binding.textView4.text = intent.getStringExtra("Phone")
            binding.textView5.text = intent.getStringExtra("Phone2")
            binding.textView6.text = intent.getStringExtra("Password")
            binding.textView7.text = intent.getStringExtra("Password2")
            binding.textView8.text = intent.getStringExtra("Gender")
        })



        binding.HomeBtn1.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }
}
