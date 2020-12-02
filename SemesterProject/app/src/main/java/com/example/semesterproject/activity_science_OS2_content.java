package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_science_OS2_content extends AppCompatActivity {

    private TextView NS = (TextView) findViewById(R.id.textViewNervous);
    private TextView RS = (TextView) findViewById(R.id.textViewRespiratory);
    private TextView CS = (TextView) findViewById(R.id.textViewCirculatory);
    private TextView ES = (TextView) findViewById(R.id.textViewExcretory);
    private Button btnN = (Button) findViewById(R.id.btnQuizNervous);
    private Button btnR = (Button) findViewById(R.id.btnQuizRespiratory);
    private Button btnC = (Button) findViewById(R.id.btnQuizCirculatory);
    private Button btnE = (Button) findViewById(R.id.btnQuizExcretory);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science__o_s2_content);

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

        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCS();
            }
        });

        ES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openES();
            }
        });

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizNS();
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizRS();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCS();
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizES();
            }
        });
    }

    private void openNS() {
        Intent intent = new Intent(this, activity_science_os2_nervous_system.class);
        startActivity(intent);
    }

    private void openQuizNS() {
        Intent intent = new Intent(this, activity_science_os2_quiz_nervous_system.class);
        startActivity(intent);
    }

    private void openRS() {
        Intent intent = new Intent(this, activity_science_os2_respiratory_system.class);
        startActivity(intent);
    }

    private void openQuizRS() {
        Intent intent = new Intent(this, activity_science_os2_quiz_respiratory_system.class);
        startActivity(intent);
    }

    private void openCS() {
        Intent intent = new Intent(this, activity_science_os2_circulatory_system.class);
        startActivity(intent);
    }

    private void openQuizCS() {
        Intent intent = new Intent(this, activity_science_os2_quiz_circulatory_system.class);
        startActivity(intent);
    }

    private void openES() {
        Intent intent = new Intent(this, activity_science_os2_excretory_system.class);
        startActivity(intent);
    }

    private void openQuizES() {
        Intent intent = new Intent(this, activity_science_os2_quiz_excretory_system.class);
        startActivity(intent);
    }
}