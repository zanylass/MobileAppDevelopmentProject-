package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}