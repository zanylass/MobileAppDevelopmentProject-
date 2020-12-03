package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

public class activity_science_content extends AppCompatActivity {
    public TextView matter;
    public TextView organSystems1;
    public TextView organSystems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_content);
        //sliding left to parent activity
        Slidr.attach(this);

        matter = (TextView) findViewById(R.id.textViewMatter);
        organSystems1 = (TextView) findViewById(R.id.textViewOS1);
        organSystems2 = (TextView) findViewById(R.id.textViewOS2);

        matter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceMatter();
            }
        });

        organSystems1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrganSystems1();
            }
        });

        organSystems2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrganSystems2();
            }
        });

    }

    public void openScienceMatter() {
        Intent intent = new Intent(this, activity_science_matter_content.class);
        startActivity(intent);
    }
    public void openOrganSystems1() {
        Intent intent = new Intent(this, activity_science_OS1_content.class);
        startActivity(intent);
    }
    public void openOrganSystems2() {
        Intent intent = new Intent(this, activity_science_OS2_content.class);
        startActivity(intent);
    }
}