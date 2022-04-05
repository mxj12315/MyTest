package com.example.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ToggleButton tg = findViewById(R.id.toggle);
        Switch sw   = findViewById(R.id.switcher);
        LinearLayout test = findViewById(R.id.test);

        CompoundButton.OnCheckedChangeListener listener = (compoundButton, isChecked) -> {
                      if (isChecked){
                          test.setOrientation(LinearLayout.VERTICAL);
                          tg.setChecked(true);
                          sw.setChecked(true);
                      }else {
                          test.setOrientation(LinearLayout.HORIZONTAL);
                          tg.setChecked(false);
                          sw.setChecked(false);
                      }
            };
        tg.setOnCheckedChangeListener(listener);
        sw.setOnCheckedChangeListener(listener);

    }
}
