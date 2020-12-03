package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class ScienceOS1content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_o_s1content);
        //sliding left to parent activity
        Slidr.attach(this);
    }
}