package com.example.roadmapproject

import MovieData
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        setSupportActionBar(binding.toolbar2)

        /*
        binding.button1.setOnClickListener(View.OnClickListener {
            // Explicit Intent
            var `intent-var`=Intent(this,MainActivity2::class.java)
            startActivity(`intent-var`)
        })
        binding.button.setOnClickListener(View.OnClickListener {
            // passingObject is a serializable for intent
            val passingObject=MyCustomObject()
            passingObject.name="Abdul Rauf"
            passingObject.id=67
            passingObject.place="KhanPur"
            var intent=Intent(this,TextViews::class.java)
            intent.putExtra("checkId","Main")
            intent.putExtra("object",passingObject)
            startActivity(intent)
        })
        binding.cardViewBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,CardViewDesign::class.java)
            startActivity(intent)
        }) */
        binding.webSiteBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,WebSiteView::class.java)
            startActivity(intent)
        })
        binding.activity3btn.setOnClickListener(View.OnClickListener {
            val pop_upMenu=PopupMenu(this,binding.activity3btn)
            pop_upMenu.menuInflater.inflate(R.menu.pop_up_menu,pop_upMenu.menu)
            pop_upMenu.setOnMenuItemClickListener { menuItem ->
                Toast.makeText(this,"you clicked "+ menuItem.title,Toast.LENGTH_LONG).show()
                true
            }
            pop_upMenu.show()
        })

    }
    //configure option menus
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus_in_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.ParcelableIntent){
            val movieData=MovieData(5,"ClassFllows","Generic information","2023",
                "10:35","Abdul Rauf","BSCS fallows","Http://GeeksForGeeks")
            // Parcelable Intent
            var intent=Intent(this,ParcelableIntentDesign::class.java)
            intent.putExtra("MoveInfo",movieData)
            startActivity(intent)
        }
        else if (item.itemId== R.id.views){
            val passingObject=MyCustomObject()
            passingObject.name="Abdul Rauf"
            passingObject.id=67
            passingObject.place="KhanPur"
            var intent=Intent(this,TextViews::class.java)
            intent.putExtra("checkId","Main")
            intent.putExtra("object",passingObject)
            startActivity(intent)
        }
        else if (item.itemId== R.id.secondActivity) {
            var `intent-var` = Intent(this, MainActivity2::class.java)
            startActivity(`intent-var`)
        }
        else if (item.itemId == R.id.recycler_view){
            var intent=Intent(this,BasicRecyclerView::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.nested_recyclerViewId){
            var intent=Intent(this,Nested_Recycler_View_Activity::class.java)
            startActivity(intent)
        }
        else if (item.itemId ==R.id.BasicFragmentView){
            var intent=Intent(this,BasicFragmentsViewActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.BasicCartView){
            var intent=Intent(this,CardViewDesign::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.SimpleFragment){
            var intent=Intent(this,SingleFragmentActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.ListFragment){
            var intent=Intent(this, ListFragmentActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.fragments_passingdata_backstack){
            var intent=Intent(this, kotlin_fragments_passingdata_backstack::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.ViewPagerActivity){
            var intent=Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId==R.id.ImageSliderViewPager){
            var intent=Intent(this, ImageSliderViewPager::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Copy",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}