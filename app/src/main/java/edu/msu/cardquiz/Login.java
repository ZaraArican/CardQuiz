package edu.msu.cardquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button2);
        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login(){
        // convert the value in editext to string
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        //if condition that checks whether the password is correct or incorrect, based on input, outputs message,
        if(user.equals("1")&& pass.equals("1"))
        {
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
//launches an activity, if validations are correct, goes to Main2Activity class (screen)

            Intent intent=new Intent(this, Instruction.class);
            startActivity(intent);
        }else {
            //outputs this message if username or password is false
            Toast.makeText(this,"Incorrect username or password!",Toast.LENGTH_LONG).show();
        }
    }
}
