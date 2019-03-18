package com.tongfu.mytestapp.animation.shareelement;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShareElementActivity1 extends AppCompatActivity {
    @BindView(R.id.image1)
    ImageView iv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image1)
    public void onImageClicked(){
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this,iv,"mainImage" ).toBundle();
        Intent intent = new Intent(this , ShareElementActivity2.class);
        startActivity(intent , bundle);
    }
}
