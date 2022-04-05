/*
package com.example.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity图片浏览工具 extends AppCompatActivity {
    // 资源图片名字必须是小写，并且png格式
    private int[] images = new int[] {
            R.drawable.dscn1868,
            R.drawable.dscn1866,
            R.drawable.dscn1865,
            R.drawable.dscn1846,
            R.drawable.dscn1845};
    private int currentImg  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);  // 设定布局文件为哪一个

        // 获取布局管理器LinearLayout
        LinearLayout linearLayout = findViewById(R.id.root);
        // 使用代码创建ImageView
        final ImageView imageView = new ImageView(this);
        // 将ImageView组件添加到LinearLayout布局中
        linearLayout.addView(imageView);
        // 设置默认的第一张图片
        imageView.setImageResource(images[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                int resId = ++currentImg % images.length;
                imageView.setImageResource(images[++currentImg]);
                if (currentImg == images.length - 1) currentImg = 0 ;

            }
        });
    }


    public void clickHandler(View view) {
//       final   TextView tv = findViewById(R.id.show);  // 找到视图元素
//         Date date =   new Date();
//        tv.setText(String.format("Hello Android-%s", date));

    }
}
*/