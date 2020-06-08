package com.example.resourcedemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contactlayout.view.*

class ConversationListAdapter (val data:MutableList<Conversation>): RecyclerView.Adapter<ConversationListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.photo
        val name : TextView = view.name
        val message : TextView = view.lastMessage
        val time : TextView = view.time

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.contactlayout,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageDrawable(data[position].image)
        holder.name.text = data[position].name
        holder.message.text = data[position].message
        holder.time.text =data[position].time
    }
}