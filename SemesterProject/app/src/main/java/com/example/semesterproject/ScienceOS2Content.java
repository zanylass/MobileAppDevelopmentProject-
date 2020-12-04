package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceOs2Content extends AppCompatActivity {

    private TextView MS;
    private TextView SS;
    private TextView DS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_os2_content);
        //sliding left to parent activity
        Slidr.attach(this);

        MS = (TextView) findViewById(R.id.textViewMuscularsystem);
        SS = (TextView) findViewById(R.id.textViewSkeletalsystem);
        DS = (TextView) findViewById(R.id.textViewDigestivesystem);

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
}