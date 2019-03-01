package com.tongfu.mytestapp.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentProviderActivity extends AppCompatActivity {

    List<UserInfo> userInfoList = new ArrayList<>();
    @BindView(R.id.lv_user_info)
    ListView lvUserinfo ;

    static class LVUserInfoItemHolder{
        @BindView(R.id.tv_name)
        TextView tvName ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        ButterKnife.bind(this);
//
        ContentValues cv = new ContentValues();
        cv.put("name" , "rentongfu ");
        cv.put("age" , 25 );
        getContentResolver().insert(Uri.parse("content://com.tongfu.providertest/userinfo") ,cv );
//
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.tongfu.providertest/userinfo" ) ,  new String[]{ "id" , "name" , "age"} , "id >= ?" , new String[]{"1"} , "name" );
        while(cursor.moveToNext()){
            UserInfo userInfo = new UserInfo();
            userInfo.id = cursor.getInt(0);
            userInfo.name = cursor.getString(1);
            userInfo.age = cursor.getInt(2);
            userInfoList.add(userInfo);
        }
        cursor.close();


        lvUserinfo.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return userInfoList.size();
            }

            @Override
            public Object getItem(int position) {
                return userInfoList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = LayoutInflater.from(ContentProviderActivity.this).inflate(R.layout.layout_user_info_lv_item , parent , false );
                    LVUserInfoItemHolder holder = new LVUserInfoItemHolder();
                    ButterKnife.bind( holder , convertView );
                    convertView.setTag(holder);
                }
                LVUserInfoItemHolder holder = (LVUserInfoItemHolder) convertView.getTag();
                UserInfo userInfo = userInfoList.get(position);
                holder.tvName.setText(userInfo.id + " 号选手" + userInfo.name + "的年龄为：" + userInfo.age);

                return convertView;
            }
        });

        Log.i("MainActivity" , "线程id：" +Thread.currentThread().getId() );
    }
}
