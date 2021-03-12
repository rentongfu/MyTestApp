package com.tongfu.mytestapp.uiwidget.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupActivity extends AppCompatActivity {

    @BindView(R.id.btn_show_popup_window)
    Button btnShowPopupWindow ;
    @BindView(R.id.btn_show_popup_menu)
    Button btnShowPopupMenu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);
    }
    PopupWindow popupWindow = null ;
    @OnClick({R.id.btn_show_popup_menu , R.id.btn_show_popup_window})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_show_popup_window:{
                if(popupWindow == null){
                    popupWindow =  new PopupWindow(getLayoutInflater().inflate(R.layout.layout_view_pager2_item , null , false)  , 100 , 200);
                }
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }else
                    popupWindow.showAsDropDown(btnShowPopupWindow);

                break;
            }
            case R.id.btn_show_popup_menu:{
                PopupMenu menu = new PopupMenu(this , btnShowPopupMenu);
                menu.inflate(R.menu.menu_lifecycle_test);
                menu.show();
                break;
            }
        }
    }
}