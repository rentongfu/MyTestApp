package com.tongfu.mytestapp.uiwidget.surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurfaceViewActivity extends AppCompatActivity {

    @BindView(R.id.surfaceView)
    SurfaceView surfaceView ;

    private Thread refreshThread = null ;
    private long lastRefreshTime = 0 ;
    private boolean isGoingOn = true ;

    private int surfaceWidth = 0;
    private int surfaceHeight = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        ButterKnife.bind(this);
        surfaceWidth = surfaceView.getWidth();
        surfaceHeight = surfaceView.getHeight() ;
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if(refreshThread==null){
                    refreshThread = new Thread(){
                        private int currentX = 0 , currentY = 0 ;
                        private boolean rightMove = true , downMove = true ;
                        @Override
                        public void run() {
                            while(isGoingOn ){
                                if(System.currentTimeMillis() - lastRefreshTime<16){
                                    continue;
                                }
                                lastRefreshTime = System.currentTimeMillis();
                                if(currentX == 0)rightMove = true;
                                else if(currentX+100 == surfaceWidth) rightMove = false ;
                                if(currentY == 0) downMove = true ;
                                else if(currentY +100 == surfaceHeight) downMove = false;
                                if(rightMove) currentX++;
                                else currentX--;
                                if(downMove) currentY++;
                                else currentY--;

                                Canvas canvas = surfaceView.getHolder().lockCanvas();
                                canvas.drawColor(Color.BLUE);
                                Paint paint = new Paint();
                                paint.setColor(Color.BLACK);
                                canvas.drawRect(new Rect( currentX , currentY , currentX + 100  , currentY + 100) , paint);
//        surfaceView.draw(canvas);
                                surfaceView.getHolder().unlockCanvasAndPost(canvas);
                            }
                        }
                    };
                }
                refreshThread.start();

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                surfaceHeight = height;
                surfaceWidth = width;
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                isGoingOn = false;
                refreshThread = null ;
            }
        });

    }
}
