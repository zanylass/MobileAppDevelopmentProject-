package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_science_matter_content extends AppCompatActivity {

    private TextView solids = (TextView) findViewById(R.id.textViewSolids);
    private TextView liquids = (TextView) findViewById(R.id.textViewLiquids);
    private TextView gases = (TextView) findViewById(R.id.textViewGases);
    private Button btnSolids = (Button) findViewById(R.id.btnQuizSolids);
    private Button btnLiquids = (Button) findViewById(R.id.btnQuizLiquids);
    private Button btnGases = (Button) findViewById(R.id.btnQuizGases);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_matter_content);
        solids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMatterSolids();
            }
        });

        btnSolids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSolids();
            }
        });

        liquids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMatterLiquids();
            }
        });

        btnLiquids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizLiquids();
            }
        });

        gases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMatterGases();
            }
        });

        btnGases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizGases();
            }
        });
    }

    private void openMatterSolids() {
        Intent intent = new Intent(this, activity_science_matter_solids.class);
        startActivity(intent);
    }
    private void openQuizSolids() {
        Intent intent = new Intent(this, activity_science_matter_quiz_solids.class);
        startActivity(intent);
    }
    private void openMatterLiquids() {
        Intent intent = new Intent(this, activity_science_matter_liquids.class);
        startActivity(intent);
    }
    private void openQuizLiquids() {
        Intent intent = new Intent(this, activity_science_matter_quiz_liquids.class);
        startActivity(intent);
    }
    private void openMatterGases() {
        Intent intent = new Intent(this, activity_science_matter_gases.class);
        startActivity(intent);
    }
    private void openQuizGases() {
        Intent intent = new Intent(this, activity_science_matter_quiz_gases.class);
        startActivity(intent);
    }
}