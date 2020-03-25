package com.tongfu.mytestapp.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadcastReceiverActivity extends AppCompatActivity {

    MyDynamicReceiver dynamicReceiver = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_send_boradcast_for_dynamic)
    void onBtnSendBroadcastForDynamicClicked(){
        Intent intent = new Intent(MyDynamicReceiver.action);
        sendBroadcast(intent);
    }

    @OnClick(R.id.btn_send_boradcast_for_static)
    void onBtnSendBroadcastForDynamicForStaticClicked(){
        //Android比较新的版本中（8.0）禁止静态注册的广播接收到implicit类型的intent，所以必须要用explicit类型的intent。
        Intent intent = new Intent(this , MyStaticReceiver.class);
//        intent.setComponent(new ComponentName(getPackageName() , MyStaticReceiver.class.getName()));
        sendBroadcast(intent);
    }

    @OnClick(R.id.btn_register_receiver)
    void onBtnRegisterReceiverClicked(){
        if(dynamicReceiver == null){
            dynamicReceiver = new MyDynamicReceiver();
        }
        IntentFilter  intentFilter = new IntentFilter();
        intentFilter.addAction(MyDynamicReceiver.action);
        intentFilter.setPriority(1);
        registerReceiver(dynamicReceiver , intentFilter);
    }

    @OnClick(R.id.btn_unregister_receiver)
    void onBtnUnRegisterRecevierClicked(){
        try{
            unregisterReceiver(dynamicReceiver);
        }catch (Exception e){
            Toast.makeText(this , "反注册失败。原因是："+ e.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_send_sticky_broad_for_dynamic)
    void onBtnSendStickyBroadcastClicked(){
        Intent intent = new Intent(MyDynamicReceiver.action);
        sendStickyBroadcast(intent);
//        sendBroadcast(intent);
    }
}
