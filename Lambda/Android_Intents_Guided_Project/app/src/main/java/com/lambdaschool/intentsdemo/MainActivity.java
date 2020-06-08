package com.lambdaschool.intentsdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_REQUEST_CODE = 54;
    private Context context;

    private EditText textEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

//        textEntry = findViewById(R.id.editText);
        // code associated with the textEntry

        findViewById(R.id.button_start_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String enteredText = textEntry.getText().toString();

                Intent intent = new Intent(context, FullscreenActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, enteredText);
                intent.setAction(Intent.ACTION_SEND);
                intent.setType(context.getResources().getString(R.string.plain_text_type));
                startActivity(intent);*/

                Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent, IMAGE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if(requestCode == IMAGE_REQUEST_CODE) {
                Uri photoUri = data.getData();
                ((ImageView)findViewById(R.id.image)).setImageURI(photoUri);
            }
        }
    }
}
