package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class ScienceOs2Skeletalsystem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_os2_skeletalsystem);
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Skeletal system");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}