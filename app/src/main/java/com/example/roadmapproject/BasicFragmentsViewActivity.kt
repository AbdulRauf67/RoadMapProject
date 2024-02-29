package com.example.roadmapproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.roadmapproject.databinding.ActivityForBasicViewFragmentsBinding

class BasicFragmentsViewActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding:ActivityForBasicViewFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForBasicViewFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_for_fragments)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.BackStackBtn.setOnClickListener(View.OnClickListener {
            val context=this@BasicFragmentsViewActivity
            val fragmentManager=context.supportFragmentManager
            val fragmentes = fragmentManager.fragments
            val myFragmentOnBackStack=fragmentManager.backStackEntryCount
            var showMyFragment:String=""
            for (entry in 0 until fragmentManager.backStackEntryCount){
                showMyFragment=showMyFragment+fragmentManager.getBackStackEntryAt(entry).id + "---"+fragmentes[entry].tag+"\n"
            }
            showMyFragment=showMyFragment+"No more fragmenets on Back Stack = "+myFragmentOnBackStack.toString()
            Toast.makeText(context,showMyFragment,Toast.LENGTH_LONG).show()
        })

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_for_fragments)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}