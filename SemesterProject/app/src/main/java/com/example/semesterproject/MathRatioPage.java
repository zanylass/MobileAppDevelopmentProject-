package com.example.semesterproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathRatioPage extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ=1;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String KEY_HIGHSCORE="keyHighscore";
    private TextView ratioPage;
    private TextView ratePage;
    private TextView percentPage;

    private int highscore;

    public Button quiz1;
    public Button quiz2;
    public Button quiz3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ratio_page);
        quiz1=(Button) findViewById(R.id.buttonQuiz1);
        quiz2=(Button) findViewById(R.id.buttonQuiz2);
        quiz3=(Button) findViewById(R.id.buttonQuiz3);
        ratioPage=(TextView)findViewById(R.id.RatioContent);
        ratePage=(TextView)findViewById(R.id.ratesContent);
        percentPage=(TextView)findViewById(R.id.textViewPercentage);

        loadHighscore();
        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz1();
            }
        });
        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz2();
            }
        });
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz3();
            }
        });
        ratioPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openRatioTopic();
            }
        });
        ratePage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openRateTopic();
            }
        });
        percentPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPercentageTopic();
            }
        });
    }

    public void openRatioTopic(){
        Intent intent = new Intent(this, RatioContentPage.class);
        startActivity(intent);

    }
    public void openRateTopic(){
        Intent intent = new Intent(this, RateContentPage.class);
        startActivity(intent);

    }
    public void openPercentageTopic(){
        Intent intent = new Intent(this, MathPercentageContent.class);
        startActivity(intent);

    }

    public void openQuiz1() {
        Intent intent = new Intent(this, MathRatioQuiz1.class);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_QUIZ){
            if (resultCode==RESULT_OK){
                int score=data.getIntExtra(MathRatioQuiz1.EXTRA_SCORE,0);
                if (score>highscore){
                    updateHighScore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        //textViewHighScore.setText("Highscore: " + highscore);
    }

    private void updateHighScore(int highscoreNew){
        highscore=highscoreNew;
        //textViewHighScore.setText("Highscore: "+ highscore);

        SharedPreferences prefs=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }

    public void openQuiz2() {
        Intent intent = new Intent(this, MathRateQuiz.class);
        startActivity(intent);
    }
    public void openQuiz3() {
        Intent intent = new Intent(this, MathQuizPercentage.class);
        startActivity(intent);
    }
}