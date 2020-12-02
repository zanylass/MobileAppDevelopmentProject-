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
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

public class MathPropNumContentPage extends AppCompatActivity {
    private TextView pn1topic;
    private TextView pn2topic;
    private TextView pn3topic;
    private TextView lcm;
    private Button pn1quiz;
    private Button pn2quiz;
    private Button pn3quiz;
    private TextView pntopicx;


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
        setContentView(R.layout.activity_math_prop_num_content_page);
        //sliding left to parent activity
        Slidr.attach(this);
        pn1topic=(TextView)findViewById(R.id.textViewPN1);
        pn2topic=(TextView)findViewById(R.id.textViewPN2);
        pn3topic=(TextView)findViewById(R.id.textViewPN3);
        pntopicx=(TextView)findViewById(R.id.textViewPNx);
        pn1quiz=(Button)findViewById(R.id.buttonPN1);
        pn2quiz=(Button) findViewById(R.id.buttonPN2);
        pn3quiz=(Button) findViewById(R.id.buttonPN3);
        lcm=(TextView)findViewById(R.id.LCM);


        lcm.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN4topic();
            }
        });
        pn1topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1topic();
            }
        });
        pn2topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2topic();
            }
        });
        pn3topic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3topic();
            }
        });
        pntopicx.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPNxtopic();
            }
        });
        pn1quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN1quiz();
            }
        });
        pn2quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN2quiz();
            }
        });
        pn3quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPN3quiz();
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



    }
    public void openPN1topic(){
        Intent intent = new Intent(this, MathPN1.class);
        startActivity(intent);
    }
    public void openPN2topic(){
        Intent intent = new Intent(this, MathPN2.class);
        startActivity(intent);
    }
    public void openPN3topic(){
        Intent intent = new Intent(this, MathPN3.class);
        startActivity(intent);
    }
    public void openPN4topic(){
        Intent intent = new Intent(this, MathPN4.class);
        startActivity(intent);
    }
    public void openPNxtopic(){
        Intent intent = new Intent(this, MathPNx.class);
        startActivity(intent);
    }
    public void openPN1quiz(){
        Intent intent = new Intent(this, MathPropN1Quiz.class);
        startActivity(intent);
    }
    public void openPN2quiz(){
        Intent intent = new Intent(this, MathPropN2Quiz.class);
        startActivity(intent);
    }
    public void openPN3quiz(){
        Intent intent = new Intent(this, MathPropN3Quiz.class);
        startActivity(intent);
    }

    //
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