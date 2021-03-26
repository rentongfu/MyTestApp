package com.tongfu.mytestapp.video;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import com.tongfu.mytestapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoPlayEntryActivity extends AppCompatActivity {
    LoaderManager loaderManager = null ;

//    @BindView(R.id.et_url)
//    EditText etUrl ;
    List<String> viewUrls = new ArrayList<>();

    @BindView(R.id.lv_main)
    ListView lvMain;

    BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return viewUrls.size();
        }

        @Override
        public Object getItem(int position) {
            return viewUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.layout_video_list_view_item , parent , false) ;
            }
            TextView tvName = convertView.findViewById(R.id.tv_name);
            tvName.setText(viewUrls.get(position));
            return convertView;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_entry);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1 );
            }
        }
        loaderManager = LoaderManager.getInstance(this);

        loaderManager.initLoader( 1 , new Bundle() , new LoaderManager.LoaderCallbacks<Cursor>() {
            @NonNull
            @Override
            public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                return new CursorLoader(VideoPlayEntryActivity.this ,
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI ,
                        new String[]{MediaStore.Video.Thumbnails.DATA}, null ,null , null);
            }

            @Override
            public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
//                Toast.makeText(LoaderManagerActivity.this , "获取到" + data.size() + "条数据" , Toast.LENGTH_SHORT).show();
                while(data.moveToNext()){
                    viewUrls.add(data.getString(data.getColumnIndex(MediaStore.Video.Thumbnails.DATA)));

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoaderReset(@NonNull Loader<Cursor> loader) {
                viewUrls.clear();
                adapter.notifyDataSetChanged();
//                Toast.makeText(LoaderManagerActivity.this , "加载被重置" , Toast.LENGTH_SHORT).show();

            }
        }).forceLoad();
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = viewUrls.get(position);
                Intent intent = new Intent(VideoPlayEntryActivity.this , VideoPlayActivity.class);
                intent.putExtra("url" , url );
                startActivity(intent);
            }
        });
    }

//    @OnClick(R.id.btn_play)
//    public void onClick(){
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1 );
//            }else{
//                checkAndToPlayActivity();
//            }
//        }else {
//            checkAndToPlayActivity();
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                checkAndToPlayActivity();
            }
        }
    }

//    void checkAndToPlayActivity(){
//        if(etUrl.getText().length() == 0){
//            Toast.makeText(this , "请输入视频文件路径" ,Toast.LENGTH_SHORT).show();
//            return ;
//        }
//        String url = etUrl.getText().toString();
//        File file = new File(url);
//        if(!file.exists()){
//            Toast.makeText(this , "视频文件不存在" ,Toast.LENGTH_SHORT).show();
//            return ;
//        }
//        Intent intent = new Intent(this , VideoPlayActivity.class);
//        intent.putExtra("url" , url );
//        startActivity(intent);
//    }
}
