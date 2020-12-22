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

public class ScienceOs2Content extends AppCompatActivity {

    private TextView MS;
    private TextView SS;
    private TextView DS;
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
        setContentView(R.layout.activity_science_os2_content);
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Organ Systems part 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MS = (TextView) findViewById(R.id.textViewMuscularsystem);
        SS = (TextView) findViewById(R.id.textViewSkeletalsystem);
        DS = (TextView) findViewById(R.id.textViewDigestivesystem);
        btnQuiz1 = (Button) findViewById(R.id.btnQuizMuscular);
        btnQuiz2 = (Button) findViewById(R.id.btnQuizSkeletal);
        btnQuiz3 = (Button) findViewById(R.id.btnQuizDigestive);

        MS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMS();
            }
        });
        SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSS();
            }
        });
        DS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDS();
            }
        });

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizMS();
            }
        });
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizSS();
            }
        });
        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizDS();
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

    private void openMS(){
        Intent intent = new Intent(this, ScienceOs2Muscularsystem.class);
        startActivity(intent);
    }

    private void openSS() {
        Intent intent = new Intent(this, ScienceOs2Skeletalsystem.class);
        startActivity(intent);
    }

    private void openDS() {
        Intent intent = new Intent(this, ScienceOs2Digestivesystem.class);
        startActivity(intent);
    }

    private void openQuizMS(){
        Intent intent = new Intent(this, ScienceQuizOS2Muscular.class);
        startActivity(intent);
    }

    private void openQuizSS(){
        Intent intent = new Intent(this, ScienceQuizOS2Skeletal.class);
        startActivity(intent);
    }

    private void openQuizDS() {
        Intent intent = new Intent(this, ScienceQuizOS2Digestive.class);
        startActivity(intent);
    }
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