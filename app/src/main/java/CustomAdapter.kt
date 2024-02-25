package com.example.roadmapproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class CustomAdapter(private val context: Context, private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)
        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text


        holder.textView.setOnClickListener(View.OnClickListener {
            val builder=AlertDialog.Builder(context)
            builder.setTitle(ItemsViewModel.text)
            builder.setMessage("fill the required fields before show the information of these infromations ..   okay")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("yes"){
                    _, _ ->
                Toast.makeText(context,"you choice the Yes", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){
                    _, _ ->
                Toast.makeText(context,"Cancel operation", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No"){
                    _, _ ->
                Toast.makeText(context,"Clicked No", Toast.LENGTH_LONG).show()
            }
            val alertDialog:AlertDialog=builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        })



        holder.button.setOnClickListener(View.OnClickListener {
            val builder= AlertDialog.Builder(context,R.style.CustomAlertDialog).create()
            val inflaterRaw=LayoutInflater.from(context)
            val view= inflaterRaw.inflate(R.layout.customview_layout,null)
            var title=view.findViewById<TextView>(R.id.title)
            title.text="Goto"
            //binding1.title.text="GoTo"
            var message=view.findViewById<TextView>(R.id.message)
            message.text="Click on anyone  \n if you Click the 2nd Activity than goto second screen \n" + "if you click on the home button then goto Home screen"
            // binding1.message.text="Click on anyone  \n if you Click the parent than goto parent screen \n" + "if you click on the home button then goto Home screen"
            var homeBtn=view.findViewById<Button>(R.id.home)
            var parentBtn=view.findViewById<Button>(R.id.parent)
            builder.setView(view)
            homeBtn.setOnClickListener(View.OnClickListener {
                var intent1=Intent(context,MainActivity::class.java)
                context.startActivity(intent1)
                builder.dismiss()
            })
            parentBtn.setOnClickListener(View.OnClickListener {
                // Explicit Intent
                var `intent-var`= Intent(context,MainActivity2::class.java)
                context.startActivity(`intent-var`)
                builder.dismiss()
            })
            builder.setCanceledOnTouchOutside(false)
            builder.show()
        })
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val button:Button=itemView.findViewById(R.id.homeButton)

    }
}


