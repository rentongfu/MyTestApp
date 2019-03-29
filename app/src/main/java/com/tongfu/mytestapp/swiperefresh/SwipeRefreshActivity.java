package com.tongfu.mytestapp.swiperefresh;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeRefreshActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        ButterKnife.bind(this);
        initCom();
    }

    private void initCom() {
        listView.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,new String[]{
                "广州","深圳","北京","上海","香港","澳门","天津",
                "广州","深圳","北京","上海","香港","澳门","天津",
                "广州","深圳","北京","上海","香港","澳门","天津",
                "广州","深圳","北京","上海","香港","澳门","天津",
                "广州","深圳","北京","上海","香港","澳门","天津",
                "广州","深圳","北京","上海","香港","澳门","天津"
        } ));

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Object,Object,Object>(){

                    @Override
                    protected void onPreExecute() {
                        swipeRefresh.setRefreshing(true);
                    }

                    @Override
                    protected Object doInBackground(Object... objects) {
                        try {
                            Thread.sleep(2000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        swipeRefresh.setRefreshing(false);
                    }
                }.execute();
            }
        });
    }
}
