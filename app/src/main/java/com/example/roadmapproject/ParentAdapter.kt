package com.example.roadmapproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ParentAdapter(private val animationId:Int, private val parentItemList: List<ParentItemModel>):
    RecyclerView.Adapter<ParentAdapter.parentViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): parentViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recycler_view,parent,false)
        return parentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentItemList.size
    }

    override fun onBindViewHolder(holder: parentViewHolder, position: Int) {
        val parentItemtitle=parentItemList[position]

        holder.itemView.animation=AnimationUtils.loadAnimation(holder.itemView.context,animationId)

        holder.parentItemTitle.text=parentItemtitle.parentItemTitle

        val childLayoutManager=LinearLayoutManager(holder.childRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,false)
        holder.childRecyclerView.layoutManager=childLayoutManager
        val childAdapter=ChildAdapter(animationId,parentItemtitle.childItemList)
        holder.childRecyclerView.adapter=childAdapter

    }

    class parentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val parentItemTitle=itemView.findViewById<TextView>(R.id.textView11)
        val childRecyclerView=itemView.findViewById<RecyclerView>(R.id.second_Recycler_view)

        /*
        fun bind(RawparentItemTitle:ParentItemModel){
            parentItemTitle.text=RawparentItemTitle.parentItemTitle

            var Childadapter=ChildAdapter( animationId,RawparentItemTitle.childItemList)
            childRecyclerView.adapter=Childadapter
            childRecyclerView.layoutManager=LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
            //for staggered or grid Recycler View so the layoutManager to set
            //childRecyclerView.layoutManager=StaggeredGridLayoutManager(3,LinearLayoutManager.HORIZONTAL)

            }
         */
    }
}