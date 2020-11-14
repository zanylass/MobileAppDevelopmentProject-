package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button mathButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mathButton=(Button)findViewById(R.id.MathButton);
        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMathContent();
            }
        });
    }
    public void openMathContent() {
        Intent intent = new Intent(this, MathContentActivity.class);
        startActivity(intent);
    }
}
