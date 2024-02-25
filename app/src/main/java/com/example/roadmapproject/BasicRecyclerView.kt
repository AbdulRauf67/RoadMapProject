package com.example.roadmapproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BasicRecyclerView : AppCompatActivity()  {
    val data = ArrayList<ItemsViewModel>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_recycler_view)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)

        //val data = ArrayList<ItemsViewModel>()
        for(i in 1..40)
            data.add(ItemsViewModel(R.drawable.customt_icon, "Item $i"))

        val onItemClickListener: AdapterView.OnItemClickListener?=null

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

}
