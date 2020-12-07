package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceMatterContent extends AppCompatActivity {

    private TextView SoM;
    private TextView CM1;
    private TextView CM2;
    private Button btnQuiz1;
    private Button btnQuiz2;
    private Button btnQuiz3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_matter_content);
        //sliding left to parent activity
        Slidr.attach(this);

        SoM = (TextView) findViewById(R.id.textViewMatterStates);
        CM1 = (TextView) findViewById(R.id.textViewMatterChanges1);
        CM2 = (TextView) findViewById(R.id.textViewMatterChanges2);
        btnQuiz3 = (Button) findViewById(R.id.btnQuizMatterStates);
        btnQuiz1 = (Button) findViewById(R.id.btnQuizChanges1);
        btnQuiz2 = (Button) findViewById(R.id.btnQuizChanges2);

        SoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoM();
            }
        });

        CM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCM1();
            }
        });

        CM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCM2();
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSoM();
            }
        });

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCM1();
            }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCM2();
            }
        });

    }

    private void openSoM() {
        Intent intent = new Intent(this, ScienceMatterStates.class);
        startActivity(intent);
    }

    private void openCM1() {
        Intent intent = new Intent(this, ScienceMatterChanges1.class);
        startActivity(intent);
    }

    private void openCM2() {
        Intent intent = new Intent(this, ScienceMatterChanges2.class);
        startActivity(intent);
    }

    private void openQuizCM1(){
        Intent intent = new Intent(this, ScienceQuizChangesMatter1.class);
        startActivity(intent);
    }

    private void openQuizCM2(){
        Intent intent = new Intent(this, ScienceQuizChangesMatter2.class);
        startActivity(intent);
    }

    private void openQuizSoM(){
        Intent intent = new Intent(this, ScienceQuizMatterStates.class);
        startActivity(intent);
    }
}