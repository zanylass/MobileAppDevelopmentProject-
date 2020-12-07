package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOs1Content extends AppCompatActivity {

    private TextView NS;
    private TextView RS;
    private TextView ES;
    private TextView CS;
    private Button btnQuiz1;
    private Button btnQuiz2;
    private Button btnQuiz3;
    private Button btnQuiz4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_os1_content);
        //sliding left to parent activity
        Slidr.attach(this);

        NS = (TextView) findViewById(R.id.textViewNervous);
        RS = (TextView) findViewById(R.id.textViewRespiratory);
        ES = (TextView) findViewById(R.id.textViewExcretory);
        CS = (TextView) findViewById(R.id.textViewCirculatory);
        btnQuiz1 = (Button) findViewById(R.id.btnQuizNervous);
        btnQuiz2 = (Button) findViewById(R.id.btnQuizRespiratory);
        btnQuiz3 = (Button) findViewById(R.id.btnQuizExcretory);
        btnQuiz4 = (Button) findViewById(R.id.btnQuizCirculatory);

        NS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNS();
            }
        });

        RS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRS();
            }
        });

        ES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openES();
            }
        });

        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCS();
            }
        });

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizNS();
            }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizRS();
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizES();
            }
        });

        btnQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCS();
            }
        });

    }

    private void openNS() {
        Intent intent = new Intent(this, ScienceOs1Nervoussystem.class);
        startActivity(intent);
    }

    private void openRS() {
        Intent intent = new Intent(this, ScienceOs1Respiratorysystem.class);
        startActivity(intent);
    }

    private void openES() {
        Intent intent = new Intent(this, ScienceOs1Excretorysystem.class);
        startActivity(intent);
    }

    private void openCS() {
        Intent intent = new Intent(this, ScienceOs1Circulatorysystem.class);
        startActivity(intent);
    }

    private void openQuizNS(){
        Intent intent = new Intent(this, ScienceQuizOS1Nervous.class);
        startActivity(intent);
    }

    private void openQuizRS(){
        Intent intent = new Intent(this, ScienceQuizOS1Respiratory.class);
        startActivity(intent);
    }

    private void openQuizES(){
        Intent intent = new Intent(this, SienceQuizOS1Excretory.class);
        startActivity(intent);
    }
    private void openQuizCS(){
        Intent intent = new Intent(this, ScienceQuizOS1Circulatory.class);
        startActivity(intent);
    }

}