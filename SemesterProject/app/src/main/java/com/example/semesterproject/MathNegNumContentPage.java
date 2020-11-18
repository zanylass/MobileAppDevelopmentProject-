package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathNegNumContentPage extends AppCompatActivity {
    private TextView nnOper1;

    private TextView nnOper3;
    private TextView nnOper2;
    private Button nn1Button;
    private Button nn2Button;
    private Button nn3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_neg_num_content_page);
        nnOper1=(TextView)findViewById(R.id.NNumTextView1);
        nnOper3=(TextView)findViewById(R.id.NNumTextView3);
        nnOper2=(TextView)findViewById(R.id.NN2TextView);
        nn1Button=(Button)findViewById(R.id.buttonNN1);
        nn2Button=(Button)findViewById(R.id.buttonNN2);
        nn3Button=(Button)findViewById(R.id.buttonNN3);
        nn1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN1Quiz();
            }
        });
        nn2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN2Quiz();
            }
        });
        nn3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN3Quiz();
            }
        });
        nnOper1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN1Topic();
            }
        });
        nnOper3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN3Topic();
            }
        });
        nnOper2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNN2Topic();
            }
        });
    }
    public void openNN1Topic(){
        Intent intent = new Intent(this, MathNN1.class);
        startActivity(intent);
    }
    public void openNN2Topic(){
        Intent intent = new Intent(this, MathNN2.class);
        startActivity(intent);
    }

    public void openNN3Topic(){
        Intent intent = new Intent(this, MathNN3.class);
        startActivity(intent);
    }
    public void openNN1Quiz(){
        Intent intent = new Intent(this, MathNNQuiz1.class);
        startActivity(intent);
    }
    public void openNN2Quiz(){
        Intent intent = new Intent(this, MathNNQuiz2.class);
        startActivity(intent);
    }
    public void openNN3Quiz(){
        Intent intent = new Intent(this, MathNNQuiz3.class);
        startActivity(intent);
    }


}