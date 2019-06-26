package com.tongfu.mytestapp.uiwidget.surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurfaceViewActivity extends AppCompatActivity {

    @BindView(R.id.surfaceView)
    SurfaceView surfaceView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        ButterKnife.bind(this);

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas canvas = surfaceView.getHolder().lockCanvas();
                canvas.drawColor(Color.BLUE);
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                canvas.drawRect(new Rect( 0 , 0 , 100 , 100) , paint);
//        surfaceView.draw(canvas);
                surfaceView.getHolder().unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }
}
