package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOS1Content extends AppCompatActivity {

    public TextView NS ;
    public TextView RS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_o_s1content);
        //sliding left to parent activity
        Slidr.attach(this);
        NS = (TextView) findViewById(R.id.textViewNervousSystem);
        RS = (TextView) findViewById(R.id.textViewRespiratorySystem);

        NS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNSContent();
            }
        });

        RS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRSContent();
            }
        });

    }

    private void openNSContent() {
        Intent intent = new Intent(this, ScienceOS1NervousSystem.class);
        startActivity(intent);
    }

    private void openRSContent() {
        Intent intent = new Intent(this, ScienceOS1RespiratorySystem.class);
        startActivity(intent);
    }
}