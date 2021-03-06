package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class MathAR2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_a_r2);
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Exponents");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}