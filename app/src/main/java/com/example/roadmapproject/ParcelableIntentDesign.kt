package com.example.roadmapproject

import MovieData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityParcelableIntentDesignBinding

@Suppress("DEPRECATION")
class ParcelableIntentDesign : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableIntentDesignBinding
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
        binding.listView.adapter=adapter


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


        binding.HomeBtn.setOnClickListener(View.OnClickListener {
            // Explicit Intent
            var `intent-var`= Intent(this,MainActivity2::class.java)
            startActivity(`intent-var`)
        })
    }

    fun click(view: View) {}
}