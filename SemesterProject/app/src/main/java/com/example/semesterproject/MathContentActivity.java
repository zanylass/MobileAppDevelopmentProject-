package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class MathContentActivity extends AppCompatActivity {
    public TextView ratios;
    public TextView operatios;
    public TextView negNumbers;
    public TextView propNumbers;

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
        setContentView(R.layout.activity_math_content);
        //sliding left to parent activity
        Slidr.attach(this);

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

        //
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
        startActivity(intent);
    }
    //
    @Override
    protected void onDestroy() {
        super.onDestroy();


        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);
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