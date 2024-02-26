package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Nested_Recycler_View_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recycler_view)

        var recyclerView = findViewById<RecyclerView>(R.id.nested_recyclerView)
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        var childItemModel = ArrayList<ChildItemModel>()

        childItemModel.add(ChildItemModel(R.drawable.image_one, "Abdul Rauf"))
        childItemModel.add(ChildItemModel(R.drawable.image_two, "Abdul Rauf"))
        childItemModel.add(ChildItemModel(R.drawable.image_three, "Abdul Rauf"))
        childItemModel.add(ChildItemModel(R.drawable.image_four, "Abdul Rauf"))

        var parentItemList = ArrayList<ParentItemModel>()

        parentItemList.add(ParentItemModel("Photos", childItemList()))
        parentItemList.add(ParentItemModel("any Photos", childItemList()))
        parentItemList.add(ParentItemModel("Random Photos", childItemList()))
        parentItemList.add(ParentItemModel("Photos in any series", childItemList()))
        parentItemList.add(ParentItemModel("Photos list", childItemList()))
        parentItemList.add(ParentItemModel("Photos Views", childItemList()))
        var adapter = ParentAdapter(parentItemList)

        recyclerView.adapter = adapter
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