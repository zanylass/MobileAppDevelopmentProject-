package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MathARQuiz1 extends AppCompatActivity {

    public static final String EXTRA_SCORE="extraScore";
    private static final long COUNTDOWN_IN_MILLIS=30000;

    private static final String KEY_SCORE="keyScore";
    private static final String KEY_QUESTION_COUNT="keyQuestionCount";
    private static final String KEY_MILLIS_LEFT="keyMillisLeft";
    private static final String KEY_ANSWERED="keyAnswered";
    private static final String KEY_QUESTION_LIST="keyQuestionList";

    private Button checkButton;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;



    private ArrayList<Question> questionList;
    private Switch switch1;
    //
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }
    //




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ratio_quiz1);
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Quiz 1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkButton=(Button)findViewById(R.id.buttonCheck);
        textViewQuestion=(TextView)findViewById(R.id.text_view_question1);
        textViewScore=(TextView)findViewById(R.id.text_view_score);
        textViewQuestionCount=(TextView)findViewById(R.id.text_view_question_count);
        textViewCountDown=(TextView)findViewById(R.id.text_view_countdown);
        rbGroup=(RadioGroup)findViewById(R.id.radio_group);
        rb1=(RadioButton)findViewById(R.id.radio_button1);
        rb2=(RadioButton)findViewById(R.id.radio_button2);
        rb3=(RadioButton)findViewById(R.id.radio_button3);
        rb4=(RadioButton)findViewById(R.id.radio_button4);

        textColorDefaultRb=rb1.getTextColors();
        textColorDefaultCd=textViewCountDown.getTextColors();

        if(savedInstanceState==null){
            QuizDbHelperAR1 dbHelper=new QuizDbHelperAR1(this);
            questionList= dbHelper.getAllQuestions();
            questionCountTotal=questionList.size();
            Collections.shuffle(questionList);

            showNextQuestion();
        }else {
            questionList=savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal=questionList.size();
            questionCounter=savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion=questionList.get(questionCounter-1);
            score=savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis=savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered=savedInstanceState.getBoolean(KEY_ANSWERED);

            if(!answered){
                startCountDown();
            }else{
                updateCountDownText();
                showSolution();
            }
        }
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rb1.isChecked()|| rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(MathARQuiz1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    showNextQuestion();
                }
                //openQuizPage2();
            }
        });
        //
        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);
        HomeWatcher mHomeWatcher;

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();
        switch1 =(Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked()){
                    mServ.pauseMusic();
                    switch1.setText("Music off");
                }else{
                    mServ.resumeMusic();
                    switch1.setText("Music on");
                }

            }
        });
    }
    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter<questionCountTotal){
            currentQuestion=questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: "+questionCounter+"/"+questionCountTotal);
            answered=false;
            checkButton.setText("Confirm");

            timeLeftInMillis=COUNTDOWN_IN_MILLIS;
            startCountDown();
        }else{
            finishQuiz();
        }
    }

    private void startCountDown(){
        countDownTimer=new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis=0;
                updateCountDownText();
                checkAnswer();

            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes=(int)(timeLeftInMillis/1000)/60;
        int seconds=(int)(timeLeftInMillis/1000)%60;

        String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis<10000){
            textViewCountDown.setTextColor(Color.RED);
        }else{
            textViewCountDown.setTextColor(textColorDefaultCd);
        }

    }

    private void checkAnswer(){
        answered=true;
        countDownTimer.cancel();
        RadioButton rbSelected=findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr=rbGroup.indexOfChild(rbSelected)+1;
        if (answerNr==currentQuestion.getAnswerNr()){
            score++;
            textViewScore.setText("Score: "+ score);
        }
        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 4 is correct");
                break;
        }
        if (questionCounter<questionCountTotal){
            checkButton.setText("Next");
        }else{
            checkButton.setText("Finish");
        }
    }


    private void finishQuiz(){
        Intent resultIntent= new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();

    }
    @Override
    //accidental leaving-saving the progress
    public void onBackPressed(){
        if (backPressedTime+2000> System.currentTimeMillis()){
            finishQuiz();
        }else{
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime=System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer!=null){
            countDownTimer.cancel();
        }


        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }



}