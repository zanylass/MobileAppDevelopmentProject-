package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathContentActivity extends AppCompatActivity {
    public TextView ratios;
    public TextView operatios;
    public TextView negNumbers;
    public TextView propNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_content);
        ratios=(TextView) findViewById(R.id.textViewRatios);
        operatios=(TextView) findViewById(R.id.textViewArOperations);
        negNumbers=(TextView) findViewById(R.id.textViewNegNum);
        propNumbers=(TextView) findViewById(R.id.textViewPropNum);


        //hyperlink from textviews to separate content pages

        ratios.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openMathRatio();
            }
        });
        operatios.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openMathOperations();
            }
        });
        negNumbers.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openMathNegNumbers();
            }
        });
        propNumbers.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openMathPropNumbers();
            }
        });



    }
    //opening all pages
    public void openMathRatio(){
        Intent intent = new Intent(this, MathRatioPage.class);
        startActivity(intent);
    }
    public void openMathOperations(){
        Intent intent = new Intent(this, MathArithOperationContentPage.class);
        startActivity(intent);
    }
    public void openMathNegNumbers(){
        Intent intent = new Intent(this, MathNegNumContentPage.class);
        startActivity(intent);
    }
    public void openMathPropNumbers() {
        Intent intent = new Intent(this, MathPropNumContentPage.class);
        startActivity(intent);}


}