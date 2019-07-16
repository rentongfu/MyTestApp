package com.tongfu.mytestapp.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.database.dbsqliteopenhelper.SQLiteOpenHelperActivity;
import com.tongfu.mytestapp.database.greendao.GreenDaoActivity;
import com.tongfu.mytestapp.database.ormlite.OrmLiteActivity;
import com.tongfu.mytestapp.database.room.RoomActivity;
import com.tongfu.mytestapp.database.sqlbrite.SqlBriteActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatabaseMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_sqlite_db_helper,R.id.btn_room,R.id.btn_sql_brite,R.id.btn_orm_lite,R.id.btn_green_dao})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_sqlite_db_helper:{
                Intent intent = new Intent(this , SQLiteOpenHelperActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_room:{
                Intent intent = new Intent(this , RoomActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_sql_brite:{
                Intent intent = new Intent(this , SqlBriteActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_orm_lite:{
                Intent intent = new Intent(this , OrmLiteActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_green_dao:{
                Intent intent = new Intent(this , GreenDaoActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
