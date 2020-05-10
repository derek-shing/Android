package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    List<Integer>imageList= new ArrayList<>();
    int current=0;



    public void changeImage(View view){
        int l = imageList.size();
        ImageView image = findViewById(R.id.imageView);
        current++;
        if (current == l-1) {
            current=0;
        }
        image.setImageResource(imageList.get(current));

    }
    public void test(View view){

        EditText nameEditText = (EditText)findViewById(R.id.nameEditText);

        Toast.makeText(this,"Hello "+ nameEditText.getText().toString(),Toast.LENGTH_LONG).show();

        Log.i("msg","Hello " + nameEditText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageList.add(R.drawable.cat);
        imageList.add(R.drawable.cat2);
        imageList.add(R.drawable.cat3);
        imageList.add(R.drawable.cat4);
        imageList.add(R.drawable.cat5);
        imageList.add(R.drawable.cat6);
        imageList.add(R.drawable.cat7);
        imageList.add(R.drawable.cat8);
        imageList.add(R.drawable.cat9);

    }
}
