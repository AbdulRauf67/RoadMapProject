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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.roadmapproject.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("UseSupportActionBar", "MissingInflatedId")
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

        toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout1)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

    }
    //configure option menus
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus_in_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ParcelableIntent -> {
                val movieData=MovieData(5,"ClassFllows","Generic information","2023",
                    "10:35","Abdul Rauf","BSCS fallows","Http://GeeksForGeeks")
                // Parcelable Intent
                var intent=Intent(this,ParcelableIntentDesign::class.java)
                intent.putExtra("MoveInfo",movieData)
                startActivity(intent)
            }
            R.id.views -> {
                val passingObject=MyCustomObject()
                passingObject.name="Abdul Rauf"
                passingObject.id=67
                passingObject.place="KhanPur"
                var intent=Intent(this,TextViews::class.java)
                intent.putExtra("checkId","Main")
                intent.putExtra("object",passingObject)
                startActivity(intent)
            }
            R.id.secondActivity -> {
                var `intent-var` = Intent(this, MainActivity2::class.java)
                startActivity(`intent-var`)
            }
            R.id.recycler_view -> {
                var intent=Intent(this,BasicRecyclerView::class.java)
                startActivity(intent)
            }
            R.id.nested_recyclerViewId -> {
                var intent=Intent(this,Nested_Recycler_View_Activity::class.java)
                startActivity(intent)
            }
            R.id.BasicFragmentView -> {
                var intent=Intent(this,BasicFragmentsViewActivity::class.java)
                startActivity(intent)
            }
            R.id.BasicCartView -> {
                var intent=Intent(this,CardViewDesign::class.java)
                startActivity(intent)
            }
            R.id.SimpleFragment -> {
                var intent=Intent(this,SingleFragmentActivity::class.java)
                startActivity(intent)
            }
            R.id.ListFragment -> {
                var intent=Intent(this, ListFragmentActivity::class.java)
                startActivity(intent)
            }
            R.id.fragments_passingdata_backstack -> {
                var intent=Intent(this, kotlin_fragments_passingdata_backstack::class.java)
                startActivity(intent)
            }
            R.id.ViewPagerActivity -> {
                var intent=Intent(this, ViewPagerActivity::class.java)
                startActivity(intent)
            }
            R.id.ImageSliderViewPager -> {
                var intent=Intent(this, ImageSliderViewPager::class.java)
                startActivity(intent)
            }
            R.id.ViewPagerTwo -> {
                var intent=Intent(this, ViewPager2Activity::class.java)
                startActivity(intent)
            }
            R.id.ViewPager2WithFragments -> {
                var intent=Intent(this, ViewPager2WithFragmentsActivity::class.java)
                startActivity(intent)
            }
            R.id.ChipActivity -> {
                var intent = Intent(this, ChipsShownActivity::class.java)
                startActivity(intent)
            }
            R.id.BottomSheet -> {
                var intent = Intent(this, BottomSheetActivity::class.java)
                startActivity(intent)
            }
            R.id.navigationDrawerBar -> {
                var intent = Intent(this, NavigationDrawerActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this,"Copy",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_messages -> {
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_friends -> {
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}