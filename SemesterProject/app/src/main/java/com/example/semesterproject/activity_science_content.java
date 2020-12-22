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
import android.widget.Switch;
import android.widget.TextView;
import com.r0adkll.slidr.Slidr;
import org.w3c.dom.Text;
public class activity_science_content extends AppCompatActivity {
    public TextView matter;
    public TextView organSystems1;
    public TextView organSystems2;
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
        setContentView(R.layout.activity_science_content);
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
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Science");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        matter = (TextView) findViewById(R.id.textViewMatter);
        organSystems1 = (TextView) findViewById(R.id.textViewOS1);
        organSystems2 = (TextView) findViewById(R.id.textViewOS2);
        matter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceMatter();
            }
        });
        organSystems1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrganSystems1();
            }
        });
        organSystems2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrganSystems2();
            }
        });


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
    private void openScienceMatter() {
        Intent intent = new Intent(this, ScienceMatterContent.class);
        startActivity(intent);
    }

    private void openOrganSystems1() {
        Intent intent = new Intent(this, ScienceOs1Content.class);
        startActivity(intent);
    }

    private void openOrganSystems2() {
        Intent intent = new Intent(this, ScienceOs2Content.class);
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