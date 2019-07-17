package com.tongfu.mytestapp.database.ormlite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;
import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.database.User;
import com.tongfu.mytestapp.database.greendao.GreenDaoActivity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrmLiteActivity extends AppCompatActivity {
    private int selectedItemIndex;
    List<User> userList = new ArrayList<>();
    ArrayAdapter<User> arrayAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsqlite_open_helper);
        setTitle("OrmLite");
        ButterKnife.bind(this);
        registerForContextMenu(lvContent);
        arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , userList);
        lvContent.setAdapter(arrayAdapter);
        List<User> userList = select();
        this.userList.clear();
        this.userList.addAll(userList);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedItemIndex = info.position ;
//        menu.setHeaderTitle("操作:" + mSources.get(selectedItemIndex).getName());
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_database_list , menu );
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_delete:{
                deleteById(userList.get(selectedItemIndex).getId());
                List<User> userList = select();
                this.userList.clear();
                this.userList.addAll(userList);
                arrayAdapter.notifyDataSetChanged();
                break;
            }
            case R.id.item_update:{
                EditText editText = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(editText);
                builder.setTitle("更新用户");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        User user = userList.get(selectedItemIndex) ;
                        user.setName(editText.getText().toString());
                        update(user);
                        List<User> userList = select();
                        OrmLiteActivity.this.userList.clear();
                        OrmLiteActivity.this.userList.addAll(userList);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            }
        }

        return super.onContextItemSelected(item);
    }

    @BindView(R.id.lv_content)
    ListView lvContent;

    @OnClick({R.id.btn_add })
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_add:{
                EditText editText = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(editText);
                builder.setTitle("添加用户");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        User user = new User();
                        user.setName(editText.getText().toString());
                        add(user);
                        List<User> userList = select();
                        OrmLiteActivity.this.userList.clear();
                        OrmLiteActivity.this.userList.addAll(userList);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            }
        }
    }

    OrmliteHelper ormliteHelper ;
    private void initHelper(){
        if(ormliteHelper ==null){
            ormliteHelper = new OrmliteHelper(this);
        }
    }
    private void add(User user) {
        try {
            initHelper();
            OrmLiteUser ormLiteUser = new OrmLiteUser();
            ormLiteUser.setName(user.getName());
            Dao<OrmLiteUser,Integer> userDao = ormliteHelper.getDao(OrmLiteUser.class);
            userDao.create(ormLiteUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteById(int id){
        initHelper();
        try {
            Dao<OrmLiteUser,Integer> userDao = ormliteHelper.getDao(OrmLiteUser.class);
            userDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private List<User> select(){
        List<User> userList = new ArrayList<>();
        initHelper();
        try {
            Dao<OrmLiteUser,Integer> userDao = ormliteHelper.getDao(OrmLiteUser.class);
            List<OrmLiteUser> ormLiteUserList = userDao.queryForAll();
            for(OrmLiteUser ormLiteUser:ormLiteUserList){
                User user = new User();
                user.setId(ormLiteUser.getId());
                user.setName(ormLiteUser.getName());
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    private void update(User user){
        initHelper();
        try {
            Dao<OrmLiteUser,Integer> userDao = ormliteHelper.getDao(OrmLiteUser.class);
            OrmLiteUser ormLiteUser = new OrmLiteUser();
            ormLiteUser.setName(user.getName());
            ormLiteUser.setId(user.getId());
            userDao.update(ormLiteUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
