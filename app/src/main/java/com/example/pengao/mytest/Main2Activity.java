package com.example.pengao.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.pengao.mytest.MainActivity.index;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView newTv = (TextView) findViewById(R.id.newTv);
        TextView close = (TextView) findViewById(R.id.close);
        ActivityManager.getInstance().putActivity("" + (index++), this);
        newTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main2Activity.class));
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager.getInstance().removeActivity("2");
            }
        });
    }
}
