package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathRatioQuiz5pg extends AppCompatActivity {
    public Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ratio_quiz5pg);
        checkButton=(Button)findViewById(R.id.buttonCheck);
//        checkButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openQuizPage6();
//            }
//        });
    }
//    public void openQuizPage6() {
//        Intent intent = new Intent(this, MathRatioQuiz6Pg.class);
//        startActivity(intent);
//    }
}
