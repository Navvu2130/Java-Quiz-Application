package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    EditText mEmail, mPassword;
    FirebaseAuth auth;
    FirebaseFirestore store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.UserPassword);
        auth = FirebaseAuth.getInstance();  //Start Authentication Service
        store = FirebaseFirestore.getInstance();

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    public void signupbtn(View view) {
        String emailtxt = mEmail.getText().toString().trim();
        String passwordtxt = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(emailtxt)) {
            mEmail.setError("Email is Required.");
            return;
        }

        else if (TextUtils.isEmpty(passwordtxt)) {
            mPassword.setError("Password is Required.");
            return;
        }

        else if (passwordtxt.length()<6) {
            mPassword.setError("Password Must be >= 6 Characters");
        }

        auth.createUserWithEmailAndPassword(emailtxt, passwordtxt).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        startActivity(new Intent(getApplicationContext(), StartActivity.class));
    }

    public void loginbtn(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}