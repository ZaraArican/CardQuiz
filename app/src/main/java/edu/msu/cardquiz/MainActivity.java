package edu.msu.cardquiz;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//splash screen
public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT= 4000;//4000 milliseconds splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // splash screen for 4000 ms, then automatically launches into Main2Activity.class at the end of time.
        //A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);


    }

}