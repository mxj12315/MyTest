package com.example.zoombutton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    private float scaleWidth = 1;
    private float scaleHeight = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView img = findViewById(R.id.img);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lijiang);
        ZoomControls zoomControls = findViewById(R.id.zoomControls1);
        zoomControls.setIsZoomInEnabled(true);
        zoomControls.setIsZoomOutEnabled(true);
        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                // 设置缩放比例
                double scale = 1.25;
                scaleWidth  = (float)(scaleWidth*scale);
                scaleHeight = (float)(scaleHeight*scale);
                Matrix matrix  = new Matrix();
               	matrix.postScale(scaleWidth, scaleHeight);
                Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0,0,width, height, matrix,true);
                img.setImageBitmap(bitmap1);

            }
        });
    }
}
