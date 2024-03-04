package com.example.roadmapproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter(private val animationId:Int,private val childItemList: List<ChildItemModel>): RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAdapter.ChildViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.child_recycler_view2,parent,false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildAdapter.ChildViewHolder, position: Int) {
        var item_view_model=childItemList[position]

        holder.imageView.setImageResource(item_view_model.imageView)
        holder.textView.text=item_view_model.childItemTitle
        holder.itemView.animation=AnimationUtils.loadAnimation(holder.itemView.context,animationId)
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }
    class ChildViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView=itemView.findViewById<ImageView>(R.id.imageView_recyclerView)
        val textView=itemView.findViewById<TextView>(R.id.child_item_title)
    }
}