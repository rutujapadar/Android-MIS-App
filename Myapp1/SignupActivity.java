package com.Myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName,signupEmail,signupUsername,signPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName=findViewById(R.id.signup_name);
        signupEmail=findViewById(R.id.signup_email);
        signupUsername=findViewById(R.id.signup_username);
        signPassword=findViewById(R.id.signup_password);
        loginRedirectText=findViewById(R.id.loginRedirectText);
        signupButton=findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");

                String name=signupName.getText().toString();
                String email=signupEmail.getText().toString();
                String username=signupUsername.getText().toString();
                String password=signPassword.getText().toString();

                HelperClass helperclass=new HelperClass(name,email,username,password);
                reference.child(name).setValue(helperclass);

                if(name.isEmpty()){
                    signupName.setError("enter name");

                } else if (email.isEmpty()) {
                    signupEmail.setError("enter name");

                }
                else if(username.isEmpty()){
                    signupUsername.setError("enter name");

                }
                else if(password.isEmpty()){
                    signPassword.setError("enter name");

                }
else{
                Toast.makeText(SignupActivity.this,"Success!",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }}
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}