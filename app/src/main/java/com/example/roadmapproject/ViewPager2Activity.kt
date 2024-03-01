package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class ViewPager2Activity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        viewPager2=findViewById(R.id.viewPagerTwo)
        val adapter=ViewPager2Adapter(this)
        viewPager2.adapter=adapter

    }
    fun childItemList(): ArrayList<ChildItemModel> {
        var childItemModel = ArrayList<ChildItemModel>()

        var random = java.util.Random()
        for (i in 1..30) {
            var tempValue = random.nextInt(9)

            childItemModel.add(ChildItemModel(when(tempValue){
                1->R.drawable.image_one
                2->R.drawable.image_two
                3->R.drawable.image_three
                4->R.drawable.image_four
                5->R.drawable.image_five
                6->R.drawable.image_six
                7->R.drawable.image_seven
                8->R.drawable.image_six
                else -> R.drawable.image_ten
            }, "Abdul Rauf  ---$i ::: $tempValue"))
        }
        return childItemModel
    }
}