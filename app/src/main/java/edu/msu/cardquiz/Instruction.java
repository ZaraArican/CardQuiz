package edu.msu.cardquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instruction extends AppCompatActivity {
    Button begin;
    //This is the screen tht explains the instructions to the user.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        begin = (Button) findViewById(R.id.begin);
        //the button that when clicked, goes into Question1.class to begin the game
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin();
            }
        });
    }
    public void begin(){
        //An intent is an abstract description of an operation to be performed. it starts an activity.
        Intent intent=new Intent(this, Question1.class);
        startActivity(intent);
    }
}

