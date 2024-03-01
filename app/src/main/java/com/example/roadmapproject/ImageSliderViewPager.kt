package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.roadmapproject.R.drawable.image_ten

class ImageSliderViewPager : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var imageSliderAdapter: ImageSliderAdapter
    lateinit var imageList: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider_view_pager)


        imageList= ArrayList<Int>()
        imageList.add(R.drawable.image_one)
        imageList.add(R.drawable.image_two)
        imageList.add(R.drawable.image_three)
        imageList.add(R.drawable.image_four)
        imageList.add(R.drawable.image_five)
        imageList.add(R.drawable.image_six)
        imageList.add(R.drawable.image_seven)

        viewPager=findViewById(R.id.viewPager)
        imageSliderAdapter= ImageSliderAdapter(this,imageList)
        viewPager.adapter=imageSliderAdapter
//        viewPager.pageMargin=15
  //      viewPager.setPadding(20,0,20,0)
        //viewPager.clipToPadding=false


        /*
        var viewPagerChangeListener: ViewPager.OnPageChangeListener= object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onPageSelected(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onPageScrollStateChanged(state: Int) {
                TODO("Not yet implemented")
            }

        }
        viewPager.addOnPageChangeListener(viewPagerChangeListener)


         */
    }
}