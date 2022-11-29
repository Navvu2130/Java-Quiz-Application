package com.example.quizapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String[] questions = {
            "1. Which method can be defined only once in a program?",
            "2. Which of these is not a bitwise operator?",
            "3. Which keyword is used by method to refer to the object that invoked it?",
            "4. Which of these keywords is used to define interfaces in Java?",
            "5. Which of these access specifiers can be used for an interface?",
            "6. Which of the following is correct way of importing an entire package ‘pkg’?",
            "7. What is the return type of Constructors?",
            "8. Which of the following package stores all the standard java classes?",
            "9. Which of these method of class String is used to compare two String objects for their equality?",
            "10. An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String[] answers = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String[] opt = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = findViewById(R.id.textView4);
        TextView textView = findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals("")) {
            assert textView != null;
            textView.setText("Hello User");
        }
        else {
            assert textView != null;
            textView.setText("Hello " + name);
        }

        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);

        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(v -> {
            //int color = mBackgroundColor.getColor();
            //mLayout.setBackgroundColor(color);

            if(radio_g.getCheckedRadioButtonId()==-1)
            {
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            assert uans != null;
            String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
            if(ansText.equals(answers[flag])) {
                correct++;
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            }
            else {
                wrong++;
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (score != null)
                score.setText(""+correct);

            if(flag<questions.length)
            {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag*4]);
                rb2.setText(opt[flag*4 +1]);
                rb3.setText(opt[flag*4 +2]);
                rb4.setText(opt[flag*4 +3]);
            }
            else
            {
                marks=correct;
                Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),ResultActivity.class);
            startActivity(intent1);
        });
    }
}