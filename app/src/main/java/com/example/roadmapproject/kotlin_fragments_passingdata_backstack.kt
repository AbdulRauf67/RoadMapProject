package com.example.roadmapproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class kotlin_fragments_passingdata_backstack : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_fragments_passingdata_backstack)

        val bottomNav=findViewById<BottomNavigationView>(R.id.bottomNavigationBar)

        bottomNav.setOnItemReselectedListener {
            when(it.itemId){
                R.id.fragment1 -> fragment1Call()
                R.id.fragment2 -> fragment2Call()
                R.id.backStack -> checkTatus()
            }
        }
    }
    fun onClickShowFragment1(view: View){


        val fragmentManager: FragmentManager = supportFragmentManager

        val fragments = fragmentManager?.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment.tag == "FRAGMENT_1"){

                    //we don't want to create a new Fragment each time the user presses the button
                   // return
                }
            }
        }

        val fragment: Fragment = SimpleFirstFragment()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        //Let's add this fragment to the activity state
        fragmentTransaction.add(R.id.host, fragment, "FRAGMENT_1")
        //Add this transaction to the back stack. This means that the transaction will be remembered after it is committed
        // This way we can reverse its operation when later popped off the stack

        //fragmentTransaction.replace(R.id.host, fragment, "FRAGMENT_1")
        fragmentTransaction.addToBackStack("SimpleFirstFragment")

        fragmentTransaction.commit()

        //fragment1?.visibility = View.VISIBLE


    }
    fun fragment1Call(){
        val fragmentManager: FragmentManager = supportFragmentManager

        val fragments = fragmentManager?.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment.tag == "FRAGMENT_1"){

                    //we don't want to create a new Fragment each time the user presses the button
                    // return
                }
            }
        }

        val fragment: Fragment = SimpleFirstFragment()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        //Let's add this fragment to the activity state
        fragmentTransaction.add(R.id.host, fragment, "FRAGMENT_1")
        //Add this transaction to the back stack. This means that the transaction will be remembered after it is committed
        // This way we can reverse its operation when later popped off the stack

        //fragmentTransaction.replace(R.id.host, fragment, "FRAGMENT_1")
        fragmentTransaction.addToBackStack("SimpleFirstFragment")

        fragmentTransaction.commit()

    }


    fun onClickShowStats(view: View){

        val context = this  //refers the current class context

        val fragmentManager: FragmentManager = context.supportFragmentManager
        val fragments = fragmentManager.fragments
        val myFragmentsonBackStack = fragmentManager.backStackEntryCount

        var showMyFragments: String = ""

        for (entry in 0 until fragmentManager.getBackStackEntryCount()) {
            showMyFragments = showMyFragments + fragmentManager.getBackStackEntryAt(entry).getId() + " - "+fragmentManager.getBackStackEntryAt(entry).name+" - " + fragments[entry].tag + "\n"

        }
        showMyFragments = showMyFragments + "no Fragments on Back Stack = " + myFragmentsonBackStack.toString()
        Toast.makeText(context, showMyFragments, Toast.LENGTH_LONG).show()


    }


    fun onClickShowFragment2(view: View){

        val fragmentManager: FragmentManager = supportFragmentManager

        val fragments = fragmentManager?.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment.tag == "FRAGMENT_2"){
                    //we don't want to create a new Fragment each time the user presses the button
                  //  return
                }
            }
        }

        val fragment: Fragment = SimpleSecondFragment()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        //Let's add this fragment to the activity state
        fragmentTransaction.add(R.id.host, fragment, "FRAGMENT_2")
        //Add this transaction to the back stack. This means that the transaction will be remembered after it is committed
        // This way we can reverse its operation when later popped off the stack

        fragmentTransaction.addToBackStack("SimpleSecondFragment")

        fragmentTransaction.commit()

        //fragment2?.visibility = View.VISIBLE
    }

    fun fragment2Call(){
        val fragmentManager: FragmentManager = supportFragmentManager

        val fragments = fragmentManager?.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment.tag == "FRAGMENT_2"){
                    //we don't want to create a new Fragment each time the user presses the button
                    //  return
                }
            }
        }

        val fragment: Fragment = SimpleSecondFragment()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        //Let's add this fragment to the activity state
        fragmentTransaction.add(R.id.host, fragment, "FRAGMENT_2")
        //Add this transaction to the back stack. This means that the transaction will be remembered after it is committed
        // This way we can reverse its operation when later popped off the stack

        fragmentTransaction.addToBackStack("SimpleSecondFragment")

        fragmentTransaction.commit()
    }
    fun checkTatus(){
        val context = this  //refers the current class context

        val fragmentManager: FragmentManager = context.supportFragmentManager
        val fragments = fragmentManager.fragments
        val myFragmentsonBackStack = fragmentManager.backStackEntryCount

        var showMyFragments: String = ""

        for (entry in 0 until fragmentManager.getBackStackEntryCount()) {
            showMyFragments = showMyFragments + fragmentManager.getBackStackEntryAt(entry).getId() + " - "+fragmentManager.getBackStackEntryAt(entry).name+" - " + fragments[entry].tag + "\n"

        }
        showMyFragments = showMyFragments + "no Fragments on Back Stack = " + myFragmentsonBackStack.toString()
        Toast.makeText(context, showMyFragments, Toast.LENGTH_LONG).show()
    }
}