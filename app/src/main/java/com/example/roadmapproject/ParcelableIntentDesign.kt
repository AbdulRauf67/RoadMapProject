package com.example.roadmapproject

import MovieData
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityParcelableIntentDesignBinding
import com.google.android.material.snackbar.Snackbar

@Suppress("DEPRECATION")
class ParcelableIntentDesign : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableIntentDesignBinding
    private lateinit var listView: ListView
    lateinit var Clayout:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_intent_design)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_parcelable_intent_design)

        var moveData: MovieData? = null

        if (intent.hasExtra("MoveInfo")) {
            moveData = intent.getParcelableExtra("MoveInfo")
        }
        if (moveData != null) {
            binding.textView1.text = moveData.sr_no.toString()
            binding.textView2.text = moveData.name
            binding.textView3.text = moveData.generic
            binding.textView4.text = moveData.year
            binding.textView5.text = moveData.length
            binding.textView6.text = moveData.director
            binding.textView7.text = moveData.decp
            binding.textView8.text = moveData.Url
        }
        var languages= arrayOf("java","Kotlin","javaScript","NodeJavaScript","C","C++",
            "Python","C#","Assembly Language",)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,languages)
        listView=binding.listView
        listView.adapter=adapter

        registerForContextMenu(binding.listView)
        registerForContextMenu(binding.textView8)


        // implemented search view using the list languages
        var searchView = binding.searchView.also {
            it.setOnQueryTextListener(/* listener = */ object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (languages.contains(query)) {
                        adapter.filter.filter(query)
                    } else {
                        Toast.makeText(this@ParcelableIntentDesign,"Notfound",Toast.LENGTH_LONG).show()
                    }
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }

            })
        }

        // seekBar code
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@ParcelableIntentDesign,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT).show()
            }
        })
        binding.seekBar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@ParcelableIntentDesign,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT).show()
            }
        })

        Clayout=binding.ParcelableIntentDesign
        var btn=binding.snackBtn2
        btn.setOnClickListener {
            // create an instance of the snackbar
            binding.textView1.setTextColor(Color.parseColor("green"))
            binding.textView2.setTextColor(Color.parseColor("green"))
            binding.textView3.setTextColor(Color.parseColor("green"))
            binding.textView4.setTextColor(Color.parseColor("green"))
            binding.textView5.setTextColor(Color.parseColor("green"))
            binding.textView6.setTextColor(Color.parseColor("green"))
            binding.textView7.setTextColor(Color.parseColor("green"))
            binding.textView8.setTextColor(Color.parseColor("green"))

            val snackbar = Snackbar.make(Clayout, "List Text Color changed to green", Snackbar.LENGTH_LONG)
                .setAction("UNDO") {
                    binding.textView1.setTextColor(Color.parseColor("blue"))
                    binding.textView2.setTextColor(Color.parseColor("blue"))
                    binding.textView3.setTextColor(Color.parseColor("blue"))
                    binding.textView4.setTextColor(Color.parseColor("blue"))
                    binding.textView5.setTextColor(Color.parseColor("blue"))
                    binding.textView6.setTextColor(Color.parseColor("blue"))
                    binding.textView7.setTextColor(Color.parseColor("blue"))
                    binding.textView8.setTextColor(Color.parseColor("blue"))

                    val snackbar =
                        Snackbar.make(Clayout, "changed to old color", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            // call show() method to
            // display the snackbar
            snackbar.show()
        }

        binding.HomeBtn.setOnClickListener(View.OnClickListener {
            // Explicit Intent
            var `intent-var`= Intent(this,MainActivity2::class.java)
            startActivity(`intent-var`)
        })
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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.call->{
                listView.setOnItemClickListener { parent, view, position, id ->
                    val textView=view.findViewById<TextView>(android.R.id.text1)
                    textView.setTextColor(Color.parseColor("green"))
                }
                Toast.makeText(this,"green color",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.sms->{
                listView.setOnItemClickListener { parent, view, position, id ->
                    val textView=view.findViewById<TextView>(android.R.id.text1)
                    textView.setTextColor(Color.parseColor("red"))
                }
                Toast.makeText(this,"red Color",Toast.LENGTH_LONG).show()
                return true
            }

            else -> {super.onContextItemSelected(item)}
        }
    }

}