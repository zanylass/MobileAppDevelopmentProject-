package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class activity_science_OS1_content extends AppCompatActivity {

    private TextView MS = (TextView) findViewById(R.id.textViewMuscularSystem);
    private TextView DS = (TextView) findViewById(R.id.textViewDigestiveSystem);
    private TextView SS = (TextView) findViewById(R.id.textViewSkeletalSystem);
    private Button btnM = (Button) findViewById(R.id.btnQuizMuscular);
    private Button btnD = (Button) findViewById(R.id.btnQuizDigestive);
    private Button btnS = (Button) findViewById(R.id.btnQuizSkeletal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science__o_s1_content);
    }
}