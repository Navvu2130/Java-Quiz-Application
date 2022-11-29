package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class DeveloperActivity extends AppCompatActivity {
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        btnBack = findViewById(R.id.button4);
    }

    public void btnBack(View view) {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
    }
}