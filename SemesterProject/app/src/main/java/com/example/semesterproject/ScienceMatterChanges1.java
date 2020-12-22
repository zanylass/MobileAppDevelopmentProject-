package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class ScienceMatterChanges1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_matter_changes1);
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Changes in states of matter 1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}