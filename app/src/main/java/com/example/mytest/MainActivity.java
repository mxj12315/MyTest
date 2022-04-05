package com.example.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    int[] names = new int[]{
            R.id.v01, R.id.v02, R.id.v03, R.id.v04, R.id.v05, R.id.v06
    };

    // 创建TextView数组，长度等于names数组长度
    TextView[] textViews = new TextView[names.length];

    class MyHandler extends Handler {
        private WeakReference<MainActivity> activity;

        public MyHandler(WeakReference<MainActivity> activity) {
            this.activity = activity;
        }

        private int currentColor = 0;
        // 定义颜色数组
        int[] colors = new int[]{
                R.color.红色, R.color.绿色, R.color.蓝色, R.color.黄色, R.color.粉色, R.color.浅蓝
        };

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                for (int i = 0, len = activity.get().names.length; i < len; i++) {
                    activity.get().textViews[i].setBackgroundResource(colors[(i + currentColor) % colors.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }

    }

    private Handler handler = new MyHandler(new WeakReference(this));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < names.length; i++) {
            textViews[i] = findViewById(names[i]);
        }
        // 定义周期性改变currentColor的变量值,每0.2s发送一次
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // 发送一条空消息周期性改变6个TextView的组件背景
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 200);
    }
}



