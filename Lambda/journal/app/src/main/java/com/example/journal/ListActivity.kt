package com.example.journal

import android.R.attr
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {

    companion object{
        const val REQUEST_KEY =1346;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val intent = Intent(this, DetailActivity::class.java);
            //startActivity(intent)

            startActivityForResult(intent, REQUEST_KEY);
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val temp = requestCode


        if (resultCode== Activity.RESULT_OK){
            Toast.makeText(this,"receive journal!",Toast.LENGTH_SHORT);
        }

        if (data!=null) {
            val date = data?.getStringExtra(DetailActivity.DATE_KEY) ?: "Jan 1 1970"
            val rate = data?.getIntExtra(DetailActivity.RATING_KEY, 0);
            val text = data?.getStringExtra(DetailActivity.TEXT_ENTRY) ?: "";
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data)
    }




}
