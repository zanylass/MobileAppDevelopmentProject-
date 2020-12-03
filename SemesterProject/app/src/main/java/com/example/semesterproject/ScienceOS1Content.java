package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOS1content extends AppCompatActivity {

    private TextView NS = findViewById(R.id.textViewNervousSystem);
    private TextView RS = findViewById(R.id.textViewRespiratorySystem);
    private TextView ES = findViewById(R.id.textViewExcretorySystem);
    private TextView CS = findViewById(R.id.textViewCirculatorySystem);
    private Button btnNS = findViewById(R.id.button);
    private Button btnRS = findViewById(R.id.button2);
    private Button btnES = findViewById(R.id.button3);
    private Button btnCS = findViewById(R.id.button4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_o_s1content);
        //sliding left to parent activity
        Slidr.attach(this);

        
    }
}