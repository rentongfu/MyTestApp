package com.tongfu.mytestapp.smoothexit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SwipeBackLayoutActivity extends SwipeBackActivity {
    @BindView(R.id.listView)
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_exit);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        ButterKnife.bind(this);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
            }
            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_user_info_lv_item , parent ,false);
                }
                return convertView;
            }
        });
        String[] list  = new String[20];
        for( int i = 0 ; i < list.length ; i++){
            list[i] = "列表项：" + i ;
        }

        listView.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , list ));
    }
}
