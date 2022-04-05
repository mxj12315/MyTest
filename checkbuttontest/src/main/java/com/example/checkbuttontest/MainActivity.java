package com.example.checkbuttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取组件
        RadioGroup rg = findViewById(R.id.rg);
        TextView show = findViewById(R.id.show);

        // 为复选框添加事件
        rg.setOnCheckedChangeListener((group,checkId)->{
            // 根据用户选择的ID来设置tip的值
            String tip = checkId == R.id.male ? "你的性别是男":"你的性别是女";
            // 修改show textview的值
            show.setText(tip);
        });
    }
}
