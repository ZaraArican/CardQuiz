package edu.msu.cardquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Question1 extends AppCompatActivity {

    private  Questions mQuestions=new Questions();

    Button answer1,answer2,answer3,answer4;
    TextView mScoreView,question;
    TextView tv_score;
    int lastScore;
    int best1,best2,best3;
    private  String mAnswer;
    private int mScore=0;
    private int mQuestionsLength=mQuestions.mQuestions.length;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        r=new Random();

        answer1=(Button)findViewById(R.id.answer1);
        answer2=(Button)findViewById(R.id.answer2);
        answer3=(Button)findViewById(R.id.answer3);
        answer4=(Button)findViewById(R.id.answer4);

        mScoreView=(TextView)findViewById(R.id.score);
        question=(TextView)findViewById(R.id.question);

        //  mScoreView.setText("Score: "+mScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText()==mAnswer){
                    mScore++;
                    updateQuestion(r.nextInt(mQuestionsLength));
                    Toast.makeText(Question1.this, "Correct", Toast.LENGTH_SHORT).show();
                }else{
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup();
                if(answer2.getText()==mAnswer){
                    mScore++;
                    Toast.makeText(Question1.this, "Correct", Toast.LENGTH_SHORT).show();

                    updateQuestion(r.nextInt(mQuestionsLength));
                }else{
                    gameOver();

                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText()==mAnswer){
                    mScore++;
                    Toast.makeText(Question1.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(mQuestionsLength));
                }else{
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText()==mAnswer){
                    Toast.makeText(Question1.this, "Correct", Toast.LENGTH_SHORT).show();

                    mScore++;
                    updateQuestion(r.nextInt(mQuestionsLength));
                }else{
                    SharedPreferences preferences=getSharedPreferences("prefs",0);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putInt("lastScore",mScore);
                    editor.apply();

                    Intent intent=new Intent(getApplicationContext(),BestActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));
        mAnswer=mQuestions.getCorrectAnswer(num);

    }

    private void gameOver(){
        SharedPreferences preferences=getSharedPreferences("prefs",0);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("lastScore",mScore);
        editor.apply();

        Intent intent=new Intent(getApplicationContext(),BestActivity.class);
        startActivity(intent);
        finish();
    }
}
