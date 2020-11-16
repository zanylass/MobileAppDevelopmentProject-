package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathPropNumContentPage extends AppCompatActivity {
    private TextView pnOper1;
    private TextView pnOper2;
    private TextView pnOper3;
    private Button pn1Button;
    private Button pn2Button;
    private Button pn3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_prop_num_content_page);
        pnOper1=(TextView)findViewById(R.id.PNumTextView1);
        pnOper2=(TextView)findViewById(R.id.PNumTextView2);
        pnOper3=(TextView)findViewById(R.id.PNumTextView3);
        pn1Button=(Button)findViewById(R.id.buttonPN1);
        pn2Button=(Button)findViewById(R.id.buttonPN2);
        pn3Button=(Button)findViewById(R.id.buttonNN3);
        pn1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1Quiz();
            }
        });
        pn2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2Quiz();
            }
        });
        pn3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3Quiz();
            }
        });
        pnOper1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1Topic();
            }
        });
        pnOper2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2Topic();
            }
        });
        pnOper3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3Topic();
            }
        });

    }
    public void openPN1Topic(){
        Intent intent = new Intent(this, MathPN1.class);
        startActivity(intent);
    }
    public void openPN2Topic(){
        Intent intent = new Intent(this, MathPN2.class);
        startActivity(intent);
    }
    public void openPN3Topic(){
        Intent intent = new Intent(this, MathPN3.class);
        startActivity(intent);
    }
    public void openPN1Quiz(){
        Intent intent = new Intent(this, MathPropN1Quiz.class);
        startActivity(intent);
    }
    public void openPN2Quiz(){
        Intent intent = new Intent(this, MathPropN2Quiz.class);
        startActivity(intent);
    }
    public void openPN3Quiz(){
        Intent intent = new Intent(this, MathPropN3Quiz.class);
        startActivity(intent);
    }
}