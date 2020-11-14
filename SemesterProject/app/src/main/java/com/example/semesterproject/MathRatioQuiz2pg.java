package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathRatioQuiz2pg extends AppCompatActivity {
    public Button checkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ratio_quiz2pg);
        checkButton=(Button)findViewById(R.id.buttonCheck);

        }
}
//    public void openQuizPage3() {
//        Intent intent = new Intent(this, MathRatioQuiz3pg.class);
//        startActivity(intent);
//    }


