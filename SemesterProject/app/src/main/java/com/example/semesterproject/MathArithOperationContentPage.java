package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathArithOperationContentPage extends AppCompatActivity {
    private TextView arOper1;
    private TextView arOper2;
    private TextView arOper3;
    private Button ar1Button;
    private Button ar2Button;
    private Button ar3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_arith_operation_content_page);
        arOper1=(TextView)findViewById(R.id.ArOperTextView1);
        arOper2=(TextView)findViewById(R.id.ArOperTextView2);
        arOper3=(TextView)findViewById(R.id.ArOperTextView3);
        ar1Button=(Button)findViewById(R.id.buttonAr1);
        ar2Button=(Button)findViewById(R.id.buttonAr1);
        ar3Button=(Button)findViewById(R.id.buttonAr1);
        ar1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Quiz();
            }
        });
        ar2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Quiz();
            }
        });
        ar3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Quiz();
            }
        });
        arOper1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Topic();
            }
        });
        arOper2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Topic();
            }
        });
        arOper3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Topic();
            }
        });
    }
    public void openAr1Topic(){
        Intent intent = new Intent(this, MathAR1.class);
        startActivity(intent);
         }
    public void openAr2Topic(){
        Intent intent = new Intent(this, MathAR2.class);
        startActivity(intent);
         }
    public void openAr3Topic(){
        Intent intent = new Intent(this, MathAR3.class);
        startActivity(intent);
         }
    public void openAr1Quiz(){
      Intent intent = new Intent(this, MathARQuiz1.class);
      startActivity(intent);
     }
    public void openAr2Quiz(){
      Intent intent = new Intent(this, MathARQuiz2.class);
      startActivity(intent);
     }
    public void openAr3Quiz(){
      Intent intent = new Intent(this, MathARQuiz3.class);
      startActivity(intent);
     }

}