package com.example.analogcclockandtextclock;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Chronometer chronometer;
    Button start;
    Button stop;
    Button re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        re = findViewById(R.id.re);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("已用时间:%s");
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        re.setOnClickListener(this);
        


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.re:
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.stop:
                chronometer.stop();
                break;
            case R.id.start:
                chronometer.start();
                break;
        }
    }
}
