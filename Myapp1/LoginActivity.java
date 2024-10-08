package com.Myapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsername,loginPassword;
    Button loginButton;
    TextView signupRedirectText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername=findViewById(R.id.login_username);
        loginPassword=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.login_button);
        signupRedirectText=findViewById(R.id.signupRedirectText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateUsername() | !validatePassword()){

                }
                else{
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if(val.isEmpty()){
            loginUsername.setError("enter username baccha");
            return false;
    }
        else{
            loginUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = loginPassword.getText().toString();
        if(val.isEmpty()){
            loginPassword.setError("enter password baccha");
            return false;
        }
        else{
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkuser(){
        String uUsername=loginUsername.getText().toString().trim();
        String uPassword=loginPassword.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase= reference.orderByChild("username").equalTo(uUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB=snapshot.child(uPassword).child("password").getValue(String.class);

                    if(!Objects.equals(passwordFromDB,uPassword)){


                    }
                    else{
                        loginPassword.setError("invalid baccha");
                        loginPassword.requestFocus();
                    }
                }
                else{
                    loginUsername.setError("Username not existing baccha");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

