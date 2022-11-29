package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button startbutton = findViewById(R.id.button);
        Button aboutbutton = findViewById(R.id.button2);
        final EditText nametext = findViewById(R.id.editName);

        assert startbutton != null;
        startbutton.setOnClickListener(v -> {
            assert nametext != null;
            String name=nametext.getText().toString();
            Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
            intent.putExtra("myname",name);
            startActivity(intent);
        });

        assert aboutbutton != null;
        aboutbutton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),DeveloperActivity.class);
            startActivity(intent);
        });
    }
}