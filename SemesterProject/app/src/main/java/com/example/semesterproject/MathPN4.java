package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class MathPN4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_p_n4);
        //sliding left to parent activity
        Slidr.attach(this);
    }
}