package com.example.roadmapproject

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.R.layout.activity_card_view
import com.example.roadmapproject.databinding.ActivityCardViewBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class CardViewDesign : AppCompatActivity() {
    private lateinit var binding: ActivityCardViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_card_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_card_view)

        binding.button4.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        binding.timeview.setOnClickListener(View.OnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hours, minute ->
                var hour = hours
                var pm_am = " "
                when {
                    hours == 0 -> {
                        hour += 12
                        pm_am = "AM"
                    }

                    hours == 12 -> {
                        pm_am = "PM"
                    }

                    hours > 12 -> {
                        hour -= 12
                        pm_am = "PM"
                    }

                    else -> pm_am = "AM"
                }
                val hour1 = if (hour < 10) "0" + hour else hour
                val minutes = if (minute < 10) "0" + minute else minute
                val smg = "$hour1 : $minutes $pm_am"
                //cal.set(Calendar.HOUR_OF_DAY,hour)
                //cal.set(Calendar.MINUTE,minute)
                //binding.textView12.text=SimpleDateFormat("HH:mm").format(cal.time)

                binding.timeview.text = smg
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        })
        binding.dateview.setOnClickListener(View.OnClickListener {
            val cal = Calendar.getInstance()
            var dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                var month1 = month + 1
                var msg = "$dayOfMonth/$month1/$year"
                binding.dateview.text = msg
            }
            DatePickerDialog(this,dateSetListener,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        })
    }
}

