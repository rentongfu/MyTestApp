package com.tongfu.mytestapp.database.greendao;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.database.User;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreenDaoActivity extends AppCompatActivity {

    private int selectedItemIndex;
    List<User> userList = new ArrayList<>();
    ArrayAdapter<User> arrayAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsqlite_open_helper);
        setTitle("GreenDao");
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
                        GreenDaoActivity.this.userList.clear();
                        GreenDaoActivity.this.userList.addAll(userList);
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
                        GreenDaoActivity.this.userList.clear();
                        GreenDaoActivity.this.userList.addAll(userList);
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
    DaoSession daoSession ;

    private void initGreenDao(){
        if(daoSession == null){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "database_greendao");
            Database db = devOpenHelper.getWritableDb() ;
            DaoMaster daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession() ;
        }
    }

    private void add(User user) {
        initGreenDao();
        GreenDaoUser greenDaoUser = new GreenDaoUser();
        greenDaoUser.setName(user.getName());
        daoSession.getGreenDaoUserDao().insert(greenDaoUser);
        daoSession.clear();
    }
    private void deleteById(int id){
        initGreenDao();
        daoSession.getGreenDaoUserDao().deleteByKey(new Long(id));
        daoSession.clear();
    }
    private List<User> select(){
        List<User> userList = new ArrayList<>();
        initGreenDao();
        List<GreenDaoUser> greenDaoUserList = daoSession.getGreenDaoUserDao().loadAll();
        for(GreenDaoUser greenDaoUser:greenDaoUserList){
            User user = new User();
            user.setId(greenDaoUser.getId().intValue());
            user.setName(greenDaoUser.getName());
            userList.add(user);
        }
        daoSession.clear();
        return userList;
    }
    private void update(User user){
        GreenDaoUser greenDaoUser = new GreenDaoUser();
        greenDaoUser.setId((long)user.getId());
        greenDaoUser.setName(user.getName());
        initGreenDao();
        daoSession.getGreenDaoUserDao().update(greenDaoUser);
        daoSession.clear();
    }
}
