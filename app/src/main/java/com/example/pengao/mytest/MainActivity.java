package com.example.pengao.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static int index = 0;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        ActivityManager.getInstance().putActivity("" + (index++), this);
        TextView btn = (TextView) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ActivityManager.getInstance().size() + "", Toast.LENGTH_LONG);
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EventBus.getDefault().post(new Events());
            }
        }, 0, 2000);
    }

    @Subscribe
    public void onEventBus(Events events) {

        Log.i("activityManager-Map", ActivityManager.getInstance().toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        timer.cancel();
    }
}
