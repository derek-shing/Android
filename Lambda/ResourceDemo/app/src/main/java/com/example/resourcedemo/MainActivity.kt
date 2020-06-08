package com.example.resourcedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = mutableListOf<Conversation>()
        val image = ContextCompat.getDrawable(this,R.drawable.photo)
        if (image != null) {

            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
            data.add(Conversation(image, " Derek", "This is the message", "10 min"))
        }

        listView.setHasFixedSize(true)
        val manager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val adapter = ConversationListAdapter(data)
        listView.adapter = adapter
        listView.layoutManager = manager
    }
}
