package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceMatterContent extends AppCompatActivity {

    private TextView SoM;
    private TextView CM1;
    private TextView CM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_matter_content);
        //sliding left to parent activity
        Slidr.attach(this);

        SoM = (TextView) findViewById(R.id.textViewMatterStates);
        CM1 = (TextView) findViewById(R.id.textViewMatterChanges1);
        CM2 = (TextView) findViewById(R.id.textViewMatterChanges2);

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


}