package com.tongfu.mytestapp.eventbus;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_send_message)
    public void onBtnSendMessageClicked(){
        EventBus.getDefault().post(new MessageEvent());
    }

    /**
     * 运行在主线程，如果post线程为主线程，那么在post过程中会直接调用
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMain( MessageEvent messageEvent){
        Log.i(this.getClass().getName() , "onEventMain：" + Thread.currentThread().getId());
    }
    /**
     * 运行在主线程，如果post线程为主线程，在post过程中不会调用。其内部应该是通过在messageQueue中加了一个事件实现的。
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onEventMainOrdered(MessageEvent messageEvent){

        Log.i(this.getClass().getName() , "onEventMainOrdered："+ Thread.currentThread().getId());
    }

    /**
     * 在不同于主线程和post线程之外的线程中调用执行。
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(MessageEvent messageEvent){
        Log.i(this.getClass().getName() , "onEventAsync："+ Thread.currentThread().getId());
    }

    /**
     * 在后台线程中执行，如果post线程是主线程，在一个新的线程中调用，如果post线程不是主线程，直接调用
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackground(MessageEvent messageEvent){

        Log.i(this.getClass().getName() , "onEventBackground：" + Thread.currentThread().getId());
    }

    /**
     * 在post是直接调用
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventPosting( MessageEvent messageEvent){

        Log.i(this.getClass().getName() , "onEventPosting：" + Thread.currentThread().getId());
    }


}
