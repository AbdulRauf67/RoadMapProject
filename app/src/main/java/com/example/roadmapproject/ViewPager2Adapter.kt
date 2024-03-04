package com.example.roadmapproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.roadmapproject.ViewPager2Adapter.*

class ViewPager2Adapter(private val context: Context):
    RecyclerView.Adapter<ViewPager2Adapter.viewHolder>() {
    val imageList= arrayOf(R.drawable.image_one,R.drawable.image_two,
        R.drawable.image_three,R.drawable.image_four,)

    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var images=itemView.findViewById<ImageView>(R.id.images)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.image_holder_view_pager2,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.images.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}