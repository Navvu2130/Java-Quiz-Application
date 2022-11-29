package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    EditText mEmail1, mPassword1;
    Button mLoginBtn1;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        mEmail1 = findViewById(R.id.email1);
        mPassword1 = findViewById(R.id.password1);
        mLoginBtn1 = findViewById(R.id.loginbtn1);

    }
    public void loginbtn1 (View view) {
        String email1 = mEmail1.getText().toString().trim();
        String password1 = mPassword1.getText().toString().trim();

        if (TextUtils.isEmpty(email1)) {
            mEmail1.setError("Email is Required.");
            return;
        }
        else if (TextUtils.isEmpty(password1)) {
            mPassword1.setError("Password is Required.");
            return;
        }
        else if (password1.length()<6) {
            mPassword1.setError("Password Must be >= 6 Characters");
        }

        auth.signInWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), StartActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}