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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public Button mathButton;
<<<<<<< HEAD
    public Button scienceButton;
=======

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
>>>>>>> 3fb6893e8012257227b1309295f4dc06fb4ffede
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mathButton=(Button)findViewById(R.id.MathButton);
        scienceButton = (Button) findViewById(R.id.ScienceButton);

        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMathContent();
            }
        });

<<<<<<< HEAD
        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceContent();
            }
        });
=======


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

>>>>>>> 3fb6893e8012257227b1309295f4dc06fb4ffede
    }

    public void openMathContent() {
        Intent intent = new Intent(this, MathContentActivity.class);
        startActivity(intent);
    }
<<<<<<< HEAD

    public void openScienceContent(){
        Intent intent = new Intent(this, activity_science_content.class);
        startActivity(intent);
    }
=======
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

>>>>>>> 3fb6893e8012257227b1309295f4dc06fb4ffede
}
