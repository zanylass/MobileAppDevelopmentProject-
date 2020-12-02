package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class activity_science_OS2_content extends AppCompatActivity {

    private TextView NS = (TextView) findViewById(R.id.textViewNervous);
    private TextView RS = (TextView) findViewById(R.id.textViewRespiratory);
    private TextView CS = (TextView) findViewById(R.id.textViewCirculatory);
    private TextView ES = (TextView) findViewById(R.id.textViewExcretory);
    private Button btnN = (Button) findViewById(R.id.btnQuizNervous);
    private Button btnR = (Button) findViewById(R.id.btnQuizRespiratory);
    private Button btnC = (Button) findViewById(R.id.btnQuizCirculatory);
    private Button btnE = (Button) findViewById(R.id.btnQuizExcretory);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science__o_s2_content);
    }
}