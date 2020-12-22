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
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ScienceMatterContent extends AppCompatActivity {

    private TextView SoM;
    private TextView CM1;
    private TextView CM2;
    private Button btnQuiz1;
    private Button btnQuiz2;
    private Button btnQuiz3;
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
        setContentView(R.layout.activity_science_matter_content);
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Science of Matter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        SoM = (TextView) findViewById(R.id.textViewMatterStates);
        CM1 = (TextView) findViewById(R.id.textViewMatterChanges1);
        CM2 = (TextView) findViewById(R.id.textViewMatterChanges2);
        btnQuiz3 = (Button) findViewById(R.id.btnQuizMatterStates);
        btnQuiz1 = (Button) findViewById(R.id.btnQuizChanges1);
        btnQuiz2 = (Button) findViewById(R.id.btnQuizChanges2);

        SoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoM();
            }
        });

        CM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCM1();
            }
        });

        CM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCM2();
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSoM();
            }
        });

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCM1();
            }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizCM2();
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

    private void openSoM() {
        Intent intent = new Intent(this, ScienceMatterStates.class);
        startActivity(intent);
    }

    private void openCM1() {
        Intent intent = new Intent(this, ScienceMatterChanges1.class);
        startActivity(intent);
    }

    private void openCM2() {
        Intent intent = new Intent(this, ScienceMatterChanges2.class);
        startActivity(intent);
    }

    private void openQuizCM1(){
        Intent intent = new Intent(this, ScienceQuizChangesMatter1.class);
        startActivity(intent);
    }

    private void openQuizCM2(){
        Intent intent = new Intent(this, ScienceQuizChangesMatter2.class);
        startActivity(intent);
    }

    private void openQuizSoM(){
        Intent intent = new Intent(this, ScienceQuizMatterStates.class);
        startActivity(intent);
    }
}