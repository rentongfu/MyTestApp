package com.tongfu.mytestapp.bigimage;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

public class BigImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);
        Rect rect = new Rect( 0 , 0 , 100 , 100);
        BitmapFactory.Options options = new BitmapFactory.Options();
//        BitmapRegionDecoder.newInstance("" , false).decodeRegion(rect ,options );

    }
}
