package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void changeActivity(View view){
        Toast.makeText(this,"button click !",Toast.LENGTH_SHORT).show();
        Log.i("test","pressed!");

    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "onClickListener function!", Toast.LENGTH_SHORT).show();
            Log.i("test", "onClickListener function!");
            Intent intent = new Intent(getApplicationContext(), Activity2.class);
            intent.putExtra("data", "hello");
            startActivity(intent);

        }
    };

    View.OnClickListener requestlistenser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "request function!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(intent,2);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(l);

        Button requesButton = findViewById(R.id.request);
        requesButton.setOnClickListener(requestlistenser);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2 && resultCode== Activity.RESULT_OK){
            Toast.makeText(this, "Receving image",Toast.LENGTH_SHORT).show();
        }
    }
}
