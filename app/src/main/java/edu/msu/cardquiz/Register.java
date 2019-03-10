package edu.msu.cardquiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {
    EditText fname, lname, email, phno, cnfpass,unn;
    Button submit;
    String firstname, lastname, mail, phone, pass,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        setContentView(R.layout.activity_register);
//Finds a view that was identified by the android
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        phno = (EditText) findViewById(R.id.phno);
        cnfpass = (EditText) findViewById(R.id.cnfpass);
        submit = (Button) findViewById(R.id.submit);
        unn = (EditText) findViewById(R.id.unn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
    }
    //checks if the information is validated, if validates outputs success message, if not a failed message.
    public void register() {
        initialize();
        if (!validate()) {
            //A toast is a view containing a quick little message for the user. The toast class helps you create and show those.
            Toast.makeText(this, "User Registration failed", Toast.LENGTH_SHORT).show();
        } else {
            onRegisterSuccess();
        }
    }
    public  void  onRegisterSuccess(){
        Toast.makeText(this, "User Registration successful", Toast.LENGTH_SHORT).show();
        firstname=lastname=phone=mail=pass="";
        //launches an activity, if validations are correct, goes to Main2Activity class (screen)
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
    //the list of validations
    public boolean validate(){
        boolean val=true;


//List of if conditions to check for specific things
        if(firstname.isEmpty()){
            fname.setError("First name can't be blank");
            fname.requestFocus();//Requests that this Component gets the input focus.
            val=false;
        }
        // checks if username field is empty
        if(username.isEmpty()){
            unn.setError("Username can't be blank");
            unn.requestFocus();
            val=false;
        }
//checks if last name field is empty
        if(lastname.isEmpty()){
            //if field is empty, gives user an error.
            lname.setError("Last name can't be blank");
            lname.requestFocus();
            val=false;
        }
        //checks if mail field is empty
        if(mail.isEmpty()){
            //if field is empty, gives user an error.
            email.setError("Email can't be blank");
            email.requestFocus();
            val=false;
        }
        if(pass.isEmpty()){
            //if field is empty, gives user an error.
            cnfpass.setError("Password can't be blank");
            cnfpass.requestFocus();
            val=false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email. setError("Please enter valid email address");
            email.requestFocus();
            val=false;
        }
        if(pass.length()<8){
            cnfpass.setError("Password can't be less than 8 characters ");
            cnfpass.requestFocus();
            val=false;
        }

        if(firstname.length()<3 ){
            fname.setError("First name can't be less than 3 characters");
            fname.requestFocus();
            val=false;
        }
        if(firstname.length()>30 ){
            fname.setError("First name can't be more than 30 characters");
            fname.requestFocus();
            val=false;
        }

        if(username.length()<3 ){
            unn.setError("Username can't be less than 3 characters");
            unn.requestFocus();
            val=false;
        }
        if(username.length()>30 ){
            unn.setError("Username can't be more than 30 characters");
            unn.requestFocus();
            val=false;
        }

        if(phone.isEmpty()){
            phno.setError("Date of Birth can't be blank");
            phno.requestFocus();
            val=false;
        }
        //gives error if date is not in dd/mm/yyyy format
        if(!phone.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
            phno.setError("Invalid date of birth. Format must be (dd/mm/yyyy)");
            phno.requestFocus();
            val=false;
        }

        return val;

    }
    public  void initialize() {
//gets value inside and converts
        username=unn.getText().toString().trim();
        firstname=fname.getText().toString().trim();
        lastname=lname.getText().toString().trim();
        mail=email.getText().toString().trim();
        phone=phno.getText().toString().trim();
        pass=cnfpass.getText().toString().trim();

    }
}
