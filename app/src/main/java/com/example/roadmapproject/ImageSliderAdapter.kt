package com.example.roadmapproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.Objects

class ImageSliderAdapter(val context:Context,val imageList:ArrayList<Int>):PagerAdapter() {
    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    @SuppressLint("MissingInflatedId")
    private var mLayoutInflater:LayoutInflater?=null
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
         mLayoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        val itemview:View=mLayoutInflater!!.inflate(R.layout.image_view_layout,container,false)
        val imageView:ImageView=itemview.findViewById(R.id.imageViewSlider)
        imageView.setImageResource(imageList[position])
        Objects.requireNonNull(container).addView(itemview)
        return itemview
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val view=`object`as View

        container.removeView(view)

        //container.removeView(`object` as RelativeLayout)
        //super.destroyItem(container, position, `object`)
    }
}