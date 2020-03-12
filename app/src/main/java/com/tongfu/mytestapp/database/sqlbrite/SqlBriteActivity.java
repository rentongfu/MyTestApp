package com.tongfu.mytestapp.database.sqlbrite;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;

import com.squareup.sqlbrite3.BriteDatabase;
import com.squareup.sqlbrite3.SqlBrite;
import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.database.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SqlBriteActivity extends AppCompatActivity {

    private int selectedItemIndex;
    List<User> userList = new ArrayList<>();
    ArrayAdapter<User> arrayAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsqlite_open_helper);
        setTitle("SqlBrite");
        ButterKnife.bind(this);
        registerForContextMenu(lvContent);
        arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , userList);
        lvContent.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        compositeDisposable = new CompositeDisposable();
        subscribe();
    }
    CompositeDisposable compositeDisposable = null ;

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
    BriteDatabase briteDatabase = null ;
    private void init(){
        if(briteDatabase == null){
            SqlBrite sqlBrite = new SqlBrite.Builder().build();
            SupportSQLiteOpenHelper.Factory factory = new FrameworkSQLiteOpenHelperFactory();
            SupportSQLiteOpenHelper.Configuration configuration = SupportSQLiteOpenHelper.Configuration.builder(this)
                    .name("databasesqlbrite")
                    .callback(new MyCallback(1))
                    .build();
            briteDatabase = sqlBrite.wrapDatabaseHelper(factory.create(configuration) , Schedulers.io());
        }

    }

    private void add(User user) {
        init();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , user.getName());
        briteDatabase.insert("my_user" , SQLiteDatabase.CONFLICT_IGNORE, contentValues);
    }
    private void deleteById(int id){
        init();
        briteDatabase.delete("my_user" , "id = ?" , Integer.toString(id));
    }
    private void subscribe(){
        init();
        Observable<SqlBrite.Query> queryObservable = briteDatabase.createQuery("my_user" , "select id ,name from my_user");
        Disposable disposable = queryObservable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((SqlBrite.Query query) -> {
                Cursor cursor = query.run();
                List<User> userList = new ArrayList<>();
                while(cursor.moveToNext()){
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    User user = new User();
                    user.setId(id);
                    user.setName(name);
                    userList.add(user);
                }
                SqlBriteActivity.this.userList.clear();
                SqlBriteActivity.this.userList.addAll(userList);
                SqlBriteActivity.this.arrayAdapter.notifyDataSetChanged();
        });
        compositeDisposable.add(disposable);
    }
    private void update(User user){
        init();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , user.getName());
        briteDatabase.update("my_user" , SQLiteDatabase.CONFLICT_IGNORE ,contentValues ,"id = ? " ,new String[]{Integer.toString(user.getId())} );
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}
