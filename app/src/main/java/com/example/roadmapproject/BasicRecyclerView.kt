package com.example.roadmapproject

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.Collections
import java.util.Random

class BasicRecyclerView : AppCompatActivity()  {

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:CustomAdapter
    var data = ArrayList<ItemsViewModel>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_recycler_view)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        //val data = ArrayList<ItemsViewModel>()
        for (i in 1..40)
            data.add(ItemsViewModel(R.drawable.customt_icon, "Item $i"))

        val onItemClickListener: AdapterView.OnItemClickListener? = null

        // This will pass the ArrayList to our Adapter
        adapter = CustomAdapter(R.anim.scale,this,data)

        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter
        val swipeRefresh=findViewById<SwipeRefreshLayout>(R.id.swipelayour)
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing=false
            Collections.shuffle(data, Random(System.currentTimeMillis()))
            adapter = CustomAdapter(R.anim.translate,this,data )
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()


        }

        registerForContextMenu(recyclerView)

        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(this, recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(
                            applicationContext,
                            "item clicked ${data[position].text}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onItemLongClick(view: View?, position: Int) {

                        val adapter1=recyclerView.adapter as? CustomAdapter
                        //val textViewid=adapter1?.getTextViewId(position)
                        val viewHolder=recyclerView.findViewHolderForAdapterPosition(position) as? CustomAdapter.ViewHolder
                        if (viewHolder != null){
                            val textView=viewHolder.itemView.findViewById<TextView>(R.id.textView)

                            var languages= arrayOf("java","Kotlin","javaScript","NodeJavaScript","C","C++",
                                "Python","C#","Assembly Language",)
                            var Random=java.util.Random()
                            val randomIndex:Int=Random.nextInt(languages.size)
                            var randomlanguage:String=languages[randomIndex]
                            textView.text=randomlanguage
                            data[position].text=randomlanguage
                            textView.setTextColor(Color.parseColor("green"))
                        }
                        Toast.makeText(
                            applicationContext,
                            "item long clicked $position and viewHolder $viewHolder and itemView ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_main,menu)
    }
}