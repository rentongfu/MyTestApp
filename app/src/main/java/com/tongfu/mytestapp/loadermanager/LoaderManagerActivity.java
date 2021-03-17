package com.tongfu.mytestapp.loadermanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

public class LoaderManagerActivity extends AppCompatActivity {
    LoaderManager loaderManager = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_manager);
//        LoaderManager.getInstance(this).initLoader( 1 , )
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader( 1 , new Bundle() , new LoaderManager.LoaderCallbacks<List<String>>() {
            @NonNull
            @Override
            public Loader<List<String>> onCreateLoader(int id, @Nullable Bundle args) {
                return new AsyncTaskLoader<List<String>>(LoaderManagerActivity.this) {
                    @Nullable
                    @Override
                    public List<String> loadInBackground() {
                        return Arrays.asList("Apple" , "Pear" , "Purple" , "Orange");
                    }
                };
            }

            @Override
            public void onLoadFinished(@NonNull Loader<List<String>> loader, List<String> data) {
                Toast.makeText(LoaderManagerActivity.this , "获取到" + data.size() + "条数据" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoaderReset(@NonNull Loader<List<String>> loader) {
                Toast.makeText(LoaderManagerActivity.this , "加载被重置" , Toast.LENGTH_SHORT).show();

            }
        }).forceLoad();

    }
}