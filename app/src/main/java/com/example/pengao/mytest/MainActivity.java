package com.example.pengao.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    //    Timer timer;
    public static int index = 0;
    //    private RecyclerView recyclerView;
//    private LinearLayoutManager mLayoutManager;
//    private TestRecyclerAdapter adapter;
    TextView aaaTv;
    ScrollView scroll_arena;

    @Override
    protected void onStart() {
        super.onStart();
        scroll_arena.measure(0, 0);
        aaaTv.setText("" + scroll_arena.getMeasuredHeight());
        scroll_arena.post(new Runnable() {
            @Override
            public void run() {
                aaaTv.setText("" + scroll_arena.getLayoutParams().height);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nosrollview);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
//        recyclerView.setLayoutManager(mLayoutManager);
//        adapter = new TestRecyclerAdapter();
//        recyclerView.setAdapter(adapter);

//        EventBus.getDefault().register(this);
//        ActivityManager.getInstance().putActivity("" + (index++), this);
        TextView btn = (TextView) findViewById(R.id.btn);
        final TextView bbbTv = (TextView) findViewById(R.id.bbbTv);
        final TextView cccTv = (TextView) findViewById(R.id.cccTv);
        aaaTv = (TextView) findViewById(R.id.aaaTv);
        scroll_arena = (ScrollView) findViewById(R.id.scroll_arena);
        aaaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaaTv.setText("aaaTv");
                ObjectAnimator.ofFloat(bbbTv, "translationY", 0).setDuration(150).start();
                ObjectAnimator.ofFloat(cccTv, "translationY", 0).setDuration(150).start();
            }
        });

        bbbTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bbbTv.setText("bbbTv");
            }
        });

        cccTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cccTv.setText("cccTv");
                ObjectAnimator.ofFloat(aaaTv, "translationY", -500).setDuration(150).start();
                ObjectAnimator.ofFloat(bbbTv, "translationY", -500).setDuration(150).start();
                ObjectAnimator.ofFloat(cccTv, "translationY", -500).setDuration(150).start();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, ActivityManager.getInstance().size() + "", Toast.LENGTH_LONG);
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));

//                ObjectAnimator.ofFloat(aaaTv, "translationY", 300).setDuration(150).start();
                ObjectAnimator.ofFloat(bbbTv, "translationY", 2000).setDuration(150).start();
                ObjectAnimator.ofFloat(cccTv, "translationY", 2000).setDuration(150).start();


            }
        });
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                EventBus.getDefault().post(new Events());
//            }
//        }, 0, 2000);


    }

    @Subscribe
    public void onEventBus(Events events) {

        Log.i("activityManager-Map", ActivityManager.getInstance().toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
//        timer.cancel();
    }
}
