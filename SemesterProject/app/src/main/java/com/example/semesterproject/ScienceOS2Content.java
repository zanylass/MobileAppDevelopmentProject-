package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOs2Content extends AppCompatActivity {

    private TextView MS;
    private TextView SS;
    private TextView DS;
    private Button btnQuiz1;
    private Button btnQuiz2;
    private Button btnQuiz3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_os2_content);
        //sliding left to parent activity
        Slidr.attach(this);

        MS = (TextView) findViewById(R.id.textViewMuscularsystem);
        SS = (TextView) findViewById(R.id.textViewSkeletalsystem);
        DS = (TextView) findViewById(R.id.textViewDigestivesystem);
        btnQuiz1 = (Button) findViewById(R.id.btnQuizMuscular);
        btnQuiz2 = (Button) findViewById(R.id.btnQuizSkeletal);
        btnQuiz3 = (Button) findViewById(R.id.btnQuizDigestive);

        MS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMS();
            }
        });
        SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSS();
            }
        });
        DS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDS();
            }
        });

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizMS();
            }
        });
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSS();
            }
        });
        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizDS();
            }
        });

    }

    private void openMS(){
        Intent intent = new Intent(this, ScienceOs2Muscularsystem.class);
        startActivity(intent);
    }

    private void openSS() {
        Intent intent = new Intent(this, ScienceOs2Skeletalsystem.class);
        startActivity(intent);
    }

    private void openDS() {
        Intent intent = new Intent(this, ScienceOs2Digestivesystem.class);
        startActivity(intent);
    }

    private void openQuizMS(){
        Intent intent = new Intent(this, ScienceQuizOS2Muscular.class);
        startActivity(intent);
    }

    private void openQuizSS(){
        Intent intent = new Intent(this, ScienceQuizOS2Skeletal.class);
        startActivity(intent);
    }

    private void openQuizDS() {
        Intent intent = new Intent(this, ScienceQuizOS2Digestive.class);
        startActivity(intent);
    }
}