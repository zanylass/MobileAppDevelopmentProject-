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

public class MathArithOperationContentPage extends AppCompatActivity {
    private TextView arOper1;
    private TextView arOper2;
    private TextView arOper3;
    private Button ar1Button;
    private Button ar2Button;
    private Button ar3Button;
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
        setContentView(R.layout.activity_math_arith_operation_content_page);
        //sliding left to parent activity
        Slidr.attach(this);
        //toolbar back button and name
        getSupportActionBar().setTitle("Arithmetic Operations");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        arOper1=(TextView)findViewById(R.id.ArOperTextView1);
        arOper2=(TextView)findViewById(R.id.ArOperTextView2);
        arOper3=(TextView)findViewById(R.id.ArOperTextView3);
        ar1Button=(Button)findViewById(R.id.buttonAr1);
        ar2Button=(Button)findViewById(R.id.buttonAr2);
        ar3Button=(Button)findViewById(R.id.buttonAr3);
        ar1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Quiz();
            }
        });
        ar2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr2Quiz();
            }
        });
        ar3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr3Quiz();
            }
        });
        arOper1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr1Topic();
            }
        });
        arOper2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr2Topic();
            }
        });
        arOper3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAr3Topic();
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

     //music
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