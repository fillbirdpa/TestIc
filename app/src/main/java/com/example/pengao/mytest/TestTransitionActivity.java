package com.example.pengao.mytest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.pengao.mytest.fragment.FragmentTransitionLauncher;


public class TestTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView aTv;
    TextView bTv;
    TextView cTv;
    TextView dTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_transition);
        aTv = (TextView) findViewById(R.id.aTv);
        bTv = (TextView) findViewById(R.id.bTv);
        cTv = (TextView) findViewById(R.id.cTv);
        dTv = (TextView) findViewById(R.id.dTv);
        aTv.setOnClickListener(this);
        bTv.setOnClickListener(this);
        cTv.setOnClickListener(this);
        dTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final Fragment toFragment = new SubFragment();
        //init your bundle first!!
        Bundle bundle = new Bundle();
        bundle.putString("Test", "Test");
        toFragment.setArguments(bundle);
        //You should call this method after init your argumentsBundle.
        FragmentTransitionLauncher
                .with(view.getContext())
                .from(view)
                .prepare(toFragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.parent_container, toFragment).addToBackStack(null).commit();
    }
}
