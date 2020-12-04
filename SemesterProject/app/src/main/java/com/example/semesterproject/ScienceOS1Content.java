package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOs1Content extends AppCompatActivity {

    private TextView NS;
    private TextView RS;
    private TextView ES;
    private TextView CS;


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


}