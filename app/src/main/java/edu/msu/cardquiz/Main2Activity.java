package edu.msu.cardquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button button, loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.button);
        loginbutton=(Button) findViewById(R.id.loginbutton);
//if button is clicked, launches login page.
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();

            }
        });
    }
    //if register button is pressed , activity launches into register.java page
    public void openRegister(){
        Intent intent=new Intent(this, Register.class);
        startActivity(intent);
    }
    //if Login button is pressed, activity launches into login.java page
    public void openLogin(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }

}