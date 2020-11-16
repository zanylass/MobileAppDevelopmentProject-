package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathPropNumContentPage extends AppCompatActivity {
    private TextView pn1topic;
    private TextView pn2topic;
    private TextView pn3topic;
    private Button pn1quiz;
    private Button pn2quiz;
    private Button pn3quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_prop_num_content_page);
        pn1topic=(TextView)findViewById(R.id.textViewPN1);
        pn2topic=(TextView)findViewById(R.id.textViewPN2);
        pn3topic=(TextView)findViewById(R.id.textViewPN3);
        pn1quiz=(Button)findViewById(R.id.buttonPN1);
        pn2quiz=(Button) findViewById(R.id.buttonPN2);
        pn3quiz=(Button) findViewById(R.id.buttonPN3);
        pn1topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1topic();
            }
        });
        pn2topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2topic();
            }
        });
        pn3topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3topic();
            }
        });
        pn1quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1quiz();
            }
        });
        pn2quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2quiz();
            }
        });
        pn3quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3quiz();
            }
        });
    }
    public void openPN1topic(){
        Intent intent = new Intent(this, MathPN1.class);
        startActivity(intent);
    }
    public void openPN2topic(){
        Intent intent = new Intent(this, MathPN2.class);
        startActivity(intent);
    }
    public void openPN3topic(){
        Intent intent = new Intent(this, MathPN3.class);
        startActivity(intent);
    }
    public void openPN1quiz(){
        Intent intent = new Intent(this, MathPropN1Quiz.class);
        startActivity(intent);
    }
    public void openPN2quiz(){
        Intent intent = new Intent(this, MathPropN2Quiz.class);
        startActivity(intent);
    }
    public void openPN3quiz(){
        Intent intent = new Intent(this, MathPropN3Quiz.class);
        startActivity(intent);
    }
}