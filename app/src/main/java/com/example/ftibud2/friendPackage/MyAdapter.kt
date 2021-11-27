package com.example.ftibud2.friendPackage

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ftibud2.R
import org.w3c.dom.Text

class MyAdapter(private  val peoplist : ArrayList<People>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.peopleitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = peoplist[position]
        holder.pname.text=currentItem.name
        holder.page.text=currentItem.email
        holder.ptime.text=currentItem.time
        holder.Intrests.text=currentItem.pref.toString()
    }

    override fun getItemCount(): Int {
        return peoplist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pname : TextView = itemView.findViewById(R.id.PName)
        val page : TextView = itemView.findViewById(R.id.page)
        val ptime : TextView =  itemView.findViewById(R.id.ptime)
        val Intrests: TextView = itemView.findViewById(R.id.pintrests)

    }

}