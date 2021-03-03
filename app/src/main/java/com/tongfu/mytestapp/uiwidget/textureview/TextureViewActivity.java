package com.tongfu.mytestapp.uiwidget.textureview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.TextureView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextureViewActivity extends AppCompatActivity {
    @BindView(R.id.textureView)
    TextureView textureView ;

    private Thread refreshThread = null ;
    private long lastRefreshTime = 0 ;
    private boolean isGoingOn = true ;

    private int surfaceWidth = 0;
    private int surfaceHeight = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_view);
        ButterKnife.bind(this);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                surfaceWidth = textureView.getWidth();
                surfaceHeight = textureView.getHeight() ;
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

                                Canvas canvas = textureView.lockCanvas();
                                canvas.drawColor(Color.BLUE);
                                Paint paint = new Paint();
                                paint.setColor(Color.BLACK);
                                canvas.drawRect(new Rect( currentX , currentY , currentX + 100  , currentY + 100) , paint);
//        surfaceView.draw(canvas);
                                textureView.unlockCanvasAndPost(canvas);
                            }
                        }
                    };
                }
                refreshThread.start();
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {

                isGoingOn = false;
                refreshThread = null ;
                return true;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            }
        });
    }
}