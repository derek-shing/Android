package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showName.setOnClickListener{
            Toast.makeText(this, "Hello Kolin", Toast.LENGTH_SHORT).show();
            val intent = Intent(this, Activity3::class.java);
            intent.putExtra("Data", "Derek");
            startActivity(intent);
        }

        requestPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT);
            intent.type="image/*"
            startActivityForResult(intent,1);

        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && resultCode== Activity.RESULT_OK){
            Toast.makeText(this, "image received! ", Toast.LENGTH_SHORT).show();
        }
    }
}
