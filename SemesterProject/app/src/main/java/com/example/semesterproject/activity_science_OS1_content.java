package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_science_OS1_content extends AppCompatActivity {

    private TextView MS = (TextView) findViewById(R.id.textViewMuscularSystem);
    private TextView DS = (TextView) findViewById(R.id.textViewDigestiveSystem);
    private TextView SS = (TextView) findViewById(R.id.textViewSkeletalSystem);
    private Button btnM = (Button) findViewById(R.id.btnQuizMuscular);
    private Button btnD = (Button) findViewById(R.id.btnQuizDigestive);
    private Button btnS = (Button) findViewById(R.id.btnQuizSkeletal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science__o_s1_content);

        MS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMS();
            }
        });
        DS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDS();
            }
        });
        SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSS();
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizMS();
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizDS();
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSS();
            }
        });

    }

    private void openMS() {
        Intent intent = new Intent(this, activity_science_os1_muscular_system.class);
        startActivity(intent);
    }
    private void openQuizMS() {
        Intent intent = new Intent(this, activity_science_os1_quiz_muscular_system.class);
        startActivity(intent);
    }
    private void openDS() {
        Intent intent = new Intent(this, activity_science_os1_digestive_system.class);
        startActivity(intent);
    }
    private void openQuizDS() {
        Intent intent = new Intent(this, activity_science_os1_quiz_digestive_system.class);
        startActivity(intent);
    }
    private void openSS() {
        Intent intent = new Intent(this, activity_science_os1_skeletal_system.class);
        startActivity(intent);
    }
    private void openQuizSS() {
        Intent intent = new Intent(this, activity_science_os1_quiz_skeletal_system.class);
        startActivity(intent);
    }

}