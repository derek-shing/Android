package com.example.journal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val DATE_KEY = "DATE_KEY";
        const val RATING_KEY ="RATING_KEY";
        const val TEXT_ENTRY ="TEXT_ENTRY";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateTextView.text = Date().toString();
        dateSeekingBar.max = 4;
        textEntry.hint =" Enter your journal today";
    }

    override fun onBackPressed() {
        super.onBackPressed();
        val resultintent = Intent();
        resultintent.putExtra(DATE_KEY,dateTextView.text);
        resultintent.putExtra(RATING_KEY,dateSeekingBar.progress);
        resultintent.putExtra(TEXT_ENTRY,textEntry.text);

        setResult(Activity.RESULT_OK, resultintent);
        finish()

    }
}
