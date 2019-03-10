package edu.msu.cardquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BestActivity extends AppCompatActivity {
    TextView tv_score;
    int lastScore;
    int best1,best2,best3;
    Button newgame,exitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best);
        newgame=(Button)findViewById(R.id.newgame);
        exitbutton=(Button)findViewById(R.id.exitbutton);

        tv_score=(TextView)findViewById(R.id.tv_score);
//if new game is clicked, loads new game
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
//returns to instruction page
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Instruction.class));
            }
        });

//load old scores
        SharedPreferences preferences=getSharedPreferences("prefs",0);
        lastScore=preferences.getInt("lastScore",0);
        best1=preferences.getInt("best1",0);
        best2=preferences.getInt("best2",0);
        best3=preferences.getInt("best3",0);
//replace if there is a highscore
        if(lastScore >best3){
            best3=lastScore;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best3",best3);
            editor.apply();
        }
        if(lastScore >best2){
            int temp=best2;
            best2=lastScore;
            best3=temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best3",best3);
            editor.putInt("best2",best2);

            editor.apply();
        }

        if(lastScore >best1){
            int temp=best1;
            best1=lastScore;
            best2=temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best1",best1);

            editor.apply();
        }
//displays scores
        tv_score.setText("LAST SCORE: " +lastScore+ "\n" +
                "BEST1: "+ best1+ "\n" +
                "BEST2: "+ best2+ "\n" +
                "BEST3: "+ best3);
    }
    @Override
    public  void onBackPressed(){
        Intent intent=new Intent(getApplicationContext(),Question1.class);
        startActivity(intent);
        finish();
    }}
