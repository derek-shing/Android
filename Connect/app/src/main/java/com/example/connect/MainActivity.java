package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;

import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int turn ;
    private int[] status;
    private List<Integer> playerColor;

    private boolean gameOver(){
        boolean result = false;
        int[][]winning = { {0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1,4,7}, {2,5,8},{0,4,8},{2,4,6}};
        for(int[] i:winning){
            if (status[i[0]]!=0){
                if (status[i[0]]==status[i[1]]&& status[i[1]]==status[i[2]]){
                    result = true;
                }
            }
        }

        return result;

    }

    public void restart(){

        turn =1;
        status= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        Toast.makeText(this,"restart",Toast.LENGTH_SHORT).show();
        GridLayout gridLayout= (GridLayout) findViewById(R.id.grid);
        int l = gridLayout.getChildCount();
        for (int i=0; i<l;i++){
            ImageView imageViews = (ImageView)gridLayout.getChildAt(i);
            imageViews.setImageResource(0);
        }

    }

    public void place(View view){
        ImageView currentGrid = (ImageView)view;
        currentGrid.setTranslationY(-1000);
        int position = Integer.parseInt(currentGrid.getTag().toString());

        if (turn%2==0)
        {

            currentGrid.setImageResource(playerColor.get(0));
            currentGrid.animate().translationYBy(1000).setDuration(300);
            status[position]=2;


        } else
        {
            currentGrid.setImageResource(playerColor.get(1));
            currentGrid.animate().translationYBy(1000).setDuration(300);
            status[position]=1;
        }
        if (gameOver()){
            restart();
        }
        String temp="";
        for (Integer i:status) {
            temp=temp+i.toString();

        }
        Log.i("state " , temp);
        turn++;
    }

    public void clickGrid(View view){
        GridLayout grid = (GridLayout)findViewById(R.id.grid);
        int c = grid.getChildCount();
        Toast.makeText(this,"Click"+Integer.toString(c),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn =1;
        status= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerColor = new ArrayList<>();
        playerColor.add(R.drawable.red);
        playerColor.add(R.drawable.yellow);
        GridLayout gridLayout= (GridLayout) findViewById(R.id.grid);
        int l = gridLayout.getChildCount();
        for (int i=0; i<l;i++){
            ImageView imageViews = (ImageView)gridLayout.getChildAt(i);
            imageViews.setImageResource(0);
        }

    }
}
