package com.example.roadmapproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity() {
    lateinit var BtnShowBottomSheeet:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        BtnShowBottomSheeet=findViewById(R.id.ShowBottomSheet)
        BtnShowBottomSheeet.setOnClickListener(View.OnClickListener {
            val dialog=BottomSheetDialog(this)
            val view =layoutInflater.inflate(R.layout.bottom_sheet_layout,null)
            val closeBtn=view.findViewById<Button>(R.id.idDismissBtn)
            closeBtn.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        })

    }
}