package com.example.mytest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

    private float currentX = 40f;
    private float currentY = 50f;
    // 定义并创建画笔
    private Paint paint = new Paint();



    public DrawView(Context context) {
        super(context);

    }




    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画笔的颜色
        paint.setColor(Color.BLUE);
        // 绘制一个圆形
        canvas.drawCircle(currentX,currentY,15f,paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 修改当前两个成员变量
        currentX = event.getX();
        currentY = event.getY();

        // 通知组件重绘自己
        invalidate();

        // 返回true表面该方法处理该事件
        return true;

    }
}
