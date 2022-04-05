package com.example.imageview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // 定义一个访问图片的数组
    private int[] images= new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };
    // 默认显示的图片
    private int currentImg = 2;
    // 定义图片显示的透明度
    private int ahpa = 255;
    private Button plus;
    private Button minus;
    private Button next;
    private ImageView image1;
    private ImageView image2;

    // 点击事件会跟OnTocuch事件冲突,抑制警告
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        next.setOnClickListener(this);
        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                // 获取第一个图片显示框中的位图
                Bitmap bitmap = bitmapDrawable.getBitmap();
                // 位图与当前image1中所显示的图片的一个缩放比
                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
                // 转换缩放坐标
                long x = Math.round(motionEvent.getX() * scale);
                long y = Math.round(motionEvent.getY() * scale);

                // 转换的坐标大于x  + 120
                if (x + 120 > bitmap.getWidth()){
                    x = bitmap.getWidth() - 120 ;
                }

                if (y > bitmap.getHeight())
                {
                    y = bitmap.getHeight() - 120 ;
                }

                image2.setImageBitmap(Bitmap.createBitmap(bitmap,(int)x,(int)y,120,120));
                image2.setImageAlpha(ahpa);
                return false;
            }
        });
    }

    /**
     * 初始化view,获取组件
     */
    private void initView(){
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        next = findViewById(R.id.next);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next:
                // 定义下一张图片
                image1.setImageResource(images[++currentImg%images.length]);
                break;
            case R.id.plus:
                ahpa+=20;
                setAhpa(ahpa);
                break;
            case R.id.minus:
                ahpa-=20;
                setAhpa(ahpa);
                break;
        }
    }

    /**
     * 检测ahpa透明度的值，并且设置值
     * @param ahpa 透明度
     */
    private void setAhpa(int ahpa) {
        if (ahpa>=255){
            ahpa = 255;
        }
        if (ahpa<=0){
            ahpa=0;
        }
        image1.setImageAlpha(ahpa);
    }
}
