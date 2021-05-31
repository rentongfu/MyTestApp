<<<<<<< HEAD
<<<<<<< HEAD
package com.tongfu.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.advertise.AdvertiseActivity;
import com.tongfu.mytestapp.animation.AnimationEntryActivity;
import com.tongfu.mytestapp.architecture.ArchitectureActivity;
import com.tongfu.mytestapp.bitmap.BitmapTransformActivity;
import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;
import com.tongfu.mytestapp.chart.MPAndroidChartActivity;
import com.tongfu.mytestapp.contact.ContactActivity;
import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;
import com.tongfu.mytestapp.coroutine.CoroutineActivity;
import com.tongfu.mytestapp.crashrecord.CrashRecordActivity;
import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;
import com.tongfu.mytestapp.dagger2.Dagger2TestActivity;
import com.tongfu.mytestapp.database.DatabaseMenuActivity;
import com.tongfu.mytestapp.databinding.DataBindingActivity;
import com.tongfu.mytestapp.eventbus.EventBusActivity;
import com.tongfu.mytestapp.eventdispatch.EventDispatchTestActivity;
import com.tongfu.mytestapp.hook.HookMenuActivity;
import com.tongfu.mytestapp.hotupdate.HotUpdateMenuActivity;
import com.tongfu.mytestapp.imageload.ImageLoadEntryActivity;
import com.tongfu.mytestapp.lifecycle.LifecycleActivity;
import com.tongfu.mytestapp.loadermanager.LoaderManagerActivity;
import com.tongfu.mytestapp.managerservice.ManagerServiceActivity;
import com.tongfu.mytestapp.mediastore.MediaStoreActivity;
import com.tongfu.mytestapp.memory.MemoryCheckActivity;
import com.tongfu.mytestapp.multidialog.MultiDialogActivity;
import com.tongfu.mytestapp.multiprocess.MultiProcessActivity;
import com.tongfu.mytestapp.ndk.NdkMenuActivity;
import com.tongfu.mytestapp.network.NetworkActivity;
import com.tongfu.mytestapp.nonification.NotificationActivity;
import com.tongfu.mytestapp.permission.PermissionActivity;
import com.tongfu.mytestapp.renderscript.RenderScriptActivity;
import com.tongfu.mytestapp.rxjava.RxJavaActivity;
import com.tongfu.mytestapp.saf.SAFActivity;
import com.tongfu.mytestapp.sampleactivity.SampleMenuActivity;
import com.tongfu.mytestapp.service.MusicPlayActivity;
import com.tongfu.mytestapp.shell.ShellActivity;
import com.tongfu.mytestapp.signature.SignatureActivity;
import com.tongfu.mytestapp.smoothexit.SmoothExitMenuActivity;
import com.tongfu.mytestapp.statusbar.StatusBarActivity;
import com.tongfu.mytestapp.swiperefresh.SwipeRefreshActivity;
import com.tongfu.mytestapp.systeminfo.SystemInfoActivity;
import com.tongfu.mytestapp.topactivity.TopMenuActivity;
import com.tongfu.mytestapp.transition.TransitionActivity;
import com.tongfu.mytestapp.transition.TransitionMenuActivity;
import com.tongfu.mytestapp.uiwidget.UIWidgetMenuActivity;
import com.tongfu.mytestapp.video.VideoPlayEntryActivity;
import com.tongfu.mytestapp.volatiletest.VolatileTestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @OnClick({R.id.btnCustomViewOnTouchEvent,R.id.btn_memory,R.id.btn_content_provider,R.id.btn_music_service,
            R.id.btn_broadcast_receiver,R.id.btn_network,R.id.btn_database,R.id.btn_notification,R.id.btn_video,
            R.id.btn_smooth_exit,R.id.btn_image,R.id.btn_anim,R.id.btn_crash_record,
            R.id.btn_swipe_refresh,R.id.btn_multiple_process,R.id.btn_event_bus,R.id.btn_permissoin,R.id.btn_lifecycle,
            R.id.btn_activity_sample,R.id.btn_ui_widget,R.id.btn_ndk,R.id.btn_dagger2,R.id.btn_data_binding,
            R.id.btn_hot_update , R.id.btn_hook , R.id.btn_status_bar , R.id.btn_manager_service ,
            R.id.btn_top_activity , R.id.btn_multi_dialog , R.id.btn_system_info , R.id.btn_dispatch_event , R.id.btn_console,
            R.id.btn_chart,R.id.btn_transition , R.id.btn_architecture , R.id.btn_advertise , R.id.btn_rxjava,
            R.id.btn_saf,R.id.btn_media_store,R.id.btn_signature_check , R.id.btn_bitmap_transform ,
            R.id.btn_contact , R.id.btn_loader_manager,R.id.btn_coroutine , R.id.btn_volatile , R.id.btn_view_binding ,
            R.id.btn_web_view , R.id.btn_render_script})
    void onClick(View v){
        switch (v.getId()){
            case R.id.btn_memory:{
                Intent intent = new Intent(this , MemoryCheckActivity.class);
                startActivity(intent) ;
                break;
            }
            case R.id.btnCustomViewOnTouchEvent:{
                Intent intent = new Intent(this ,OnTouchEventTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_content_provider:{
                Intent intent = new Intent( this , ContentProviderActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_music_service:{
                Intent intent = new Intent(this , MusicPlayActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_broadcast_receiver:{
                Intent intent = new Intent(this , BroadcastReceiverActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_network:{
                Intent intent = new Intent(this , NetworkActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_database:{
                Intent intent = new Intent(this , DatabaseMenuActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_notification:{
                Intent intent = new Intent(this , NotificationActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_video:{
                Intent intent = new Intent(this , VideoPlayEntryActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_smooth_exit:{
                Intent intent = new Intent(this , SmoothExitMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_image:{
                Intent intent = new Intent(this , ImageLoadEntryActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_anim:{
                Intent intent = new Intent(this , AnimationEntryActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_crash_record:{
                Intent intent = new Intent(this , CrashRecordActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_swipe_refresh:{
                Intent intent = new Intent(this , SwipeRefreshActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_multiple_process:{
                Intent intent = new Intent(this , MultiProcessActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_event_bus:{
                Intent intent = new Intent(this , EventBusActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_permissoin:{
                Intent intent = new Intent(this , PermissionActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_lifecycle:{
                Intent intent = new Intent(this , LifecycleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_activity_sample:{
                Intent intent = new Intent(this , SampleMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_ui_widget:{
                Intent intent = new Intent(this , UIWidgetMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_ndk:{
                Intent intent = new Intent(this , NdkMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_dagger2:{
                Intent intent = new Intent(this , Dagger2TestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_data_binding:{
                Intent intent = new Intent(this , DataBindingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_hot_update:{
                Intent intent = new Intent(this, HotUpdateMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_hook:{
                Intent intent = new Intent(this , HookMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_status_bar:{
                Intent intent = new Intent(this , StatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_manager_service:{
                Intent intent = new Intent(this , ManagerServiceActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_top_activity:{
                Intent intent = new Intent(this , TopMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_multi_dialog:{
                Intent intent = new Intent(this , MultiDialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_system_info:{
                Intent intent = new Intent(this , SystemInfoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_dispatch_event:{
                Intent intent = new Intent(this , EventDispatchTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_console:{
                Intent intent = new Intent(this , ShellActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_chart:{
                Intent intent = new Intent(this , MPAndroidChartActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_transition:{
                Intent intent = new Intent(this, TransitionMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_architecture:{
                Intent intent = new Intent(this , ArchitectureActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_advertise:{
                Intent intent = new Intent(this , AdvertiseActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_rxjava:{
                Intent intent = new Intent(this , RxJavaActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_saf:{
                Intent intent = new Intent(this , SAFActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_media_store:{
                Intent intent = new Intent(this , MediaStoreActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_signature_check:{
                Intent intent = new Intent(this , SignatureActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_bitmap_transform:{
                Intent intent = new Intent(this , BitmapTransformActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_contact:{
                Intent intent = new Intent(this , ContactActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_loader_manager:{
                Intent intent = new Intent(this , LoaderManagerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_coroutine:{
                startActivity(new Intent(this , CoroutineActivity.class));
                break;
            }
            case R.id.btn_view_binding:{
                startActivity(new Intent(this , ViewBindingActivity.class));
                break;
            }
            case R.id.btn_web_view:{
                startActivity(new Intent(this , WebViewActivity.class));
                break;
            }
            case R.id.btn_render_script:{
                startActivity(new Intent(this , RenderScriptActivity.class));
                break;
            }
            case R.id.btn_volatile:{
                startActivity(new Intent(this , VolatileTestActivity.class));
                break;
            }

        }
    }
}
=======
package com.tongfu.mytestapp;import android.content.Intent;import android.os.Bundle;import android.provider.MediaStore;import android.view.View;import androidx.appcompat.app.AppCompatActivity;import com.tongfu.mytestapp.advertise.AdvertiseActivity;import com.tongfu.mytestapp.animation.AnimationEntryActivity;import com.tongfu.mytestapp.architecture.ArchitectureActivity;import com.tongfu.mytestapp.bitmap.BitmapTransformActivity;import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;import com.tongfu.mytestapp.chart.MPAndroidChartActivity;import com.tongfu.mytestapp.contact.ContactActivity;import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;import com.tongfu.mytestapp.coroutine.CoroutineActivity;import com.tongfu.mytestapp.crashrecord.CrashRecordActivity;import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;import com.tongfu.mytestapp.dagger2.Dagger2TestActivity;import com.tongfu.mytestapp.database.DatabaseMenuActivity;import com.tongfu.mytestapp.databinding.DataBindingActivity;import com.tongfu.mytestapp.eventbus.EventBusActivity;import com.tongfu.mytestapp.eventdispatch.EventDispatchTestActivity;import com.tongfu.mytestapp.hook.HookMenuActivity;import com.tongfu.mytestapp.hotupdate.HotUpdateMenuActivity;import com.tongfu.mytestapp.imageload.ImageLoadEntryActivity;import com.tongfu.mytestapp.lifecycle.LifecycleActivity;import com.tongfu.mytestapp.loadermanager.LoaderManagerActivity;import com.tongfu.mytestapp.managerservice.ManagerServiceActivity;import com.tongfu.mytestapp.mediastore.MediaStoreActivity;import com.tongfu.mytestapp.memory.MemoryCheckActivity;import com.tongfu.mytestapp.multidialog.MultiDialogActivity;import com.tongfu.mytestapp.multiprocess.MultiProcessActivity;import com.tongfu.mytestapp.ndk.NdkMenuActivity;import com.tongfu.mytestapp.network.NetworkActivity;import com.tongfu.mytestapp.nonification.NotificationActivity;import com.tongfu.mytestapp.permission.PermissionActivity;import com.tongfu.mytestapp.rxjava.RxJavaActivity;import com.tongfu.mytestapp.saf.SAFActivity;import com.tongfu.mytestapp.sampleactivity.SampleMenuActivity;import com.tongfu.mytestapp.service.MusicPlayActivity;import com.tongfu.mytestapp.shell.ShellActivity;import com.tongfu.mytestapp.signature.SignatureActivity;import com.tongfu.mytestapp.smoothexit.SmoothExitMenuActivity;import com.tongfu.mytestapp.statusbar.StatusBarActivity;import com.tongfu.mytestapp.swiperefresh.SwipeRefreshActivity;import com.tongfu.mytestapp.systeminfo.SystemInfoActivity;import com.tongfu.mytestapp.topactivity.TopMenuActivity;import com.tongfu.mytestapp.transition.TransitionActivity;import com.tongfu.mytestapp.transition.TransitionMenuActivity;import com.tongfu.mytestapp.uiwidget.UIWidgetMenuActivity;import com.tongfu.mytestapp.video.VideoPlayEntryActivity;import com.tongfu.mytestapp.viewbinding.ViewBindingActivity;import com.tongfu.mytestapp.webview.WebViewActivity;import butterknife.ButterKnife;import butterknife.OnClick;public class MainActivity extends AppCompatActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);    }    @Override    protected void onResume() {        super.onResume();    }    @Override    protected void onPause() {        super.onPause();    }    @OnClick({R.id.btnCustomViewOnTouchEvent,R.id.btn_memory,R.id.btn_content_provider,R.id.btn_music_service,            R.id.btn_broadcast_receiver,R.id.btn_network,R.id.btn_database,R.id.btn_notification,R.id.btn_video,            R.id.btn_smooth_exit,R.id.btn_image,R.id.btn_anim,R.id.btn_crash_record,            R.id.btn_swipe_refresh,R.id.btn_multiple_process,R.id.btn_event_bus,R.id.btn_permissoin,R.id.btn_lifecycle,            R.id.btn_activity_sample,R.id.btn_ui_widget,R.id.btn_ndk,R.id.btn_dagger2,R.id.btn_data_binding,            R.id.btn_hot_update , R.id.btn_hook , R.id.btn_status_bar , R.id.btn_manager_service ,            R.id.btn_top_activity , R.id.btn_multi_dialog , R.id.btn_system_info , R.id.btn_dispatch_event , R.id.btn_console,            R.id.btn_chart,R.id.btn_transition , R.id.btn_architecture , R.id.btn_advertise , R.id.btn_rxjava,            R.id.btn_saf,R.id.btn_media_store,R.id.btn_signature_check , R.id.btn_bitmap_transform ,            R.id.btn_contact , R.id.btn_loader_manager,R.id.btn_coroutine , R.id.btn_view_binding ,            R.id.btn_web_view})    void onClick(View v){        switch (v.getId()){            case R.id.btn_memory:{                Intent intent = new Intent(this , MemoryCheckActivity.class);                startActivity(intent) ;                break;            }            case R.id.btnCustomViewOnTouchEvent:{                Intent intent = new Intent(this ,OnTouchEventTestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_content_provider:{                Intent intent = new Intent( this , ContentProviderActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_music_service:{                Intent intent = new Intent(this , MusicPlayActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_broadcast_receiver:{                Intent intent = new Intent(this , BroadcastReceiverActivity.class);                startActivity(intent);                break;            }            case R.id.btn_network:{                Intent intent = new Intent(this , NetworkActivity.class);                startActivity(intent);                break;            }            case R.id.btn_database:{                Intent intent = new Intent(this , DatabaseMenuActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_notification:{                Intent intent = new Intent(this , NotificationActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_video:{                Intent intent = new Intent(this , VideoPlayEntryActivity.class);                startActivity(intent);                break;            }            case R.id.btn_smooth_exit:{                Intent intent = new Intent(this , SmoothExitMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_image:{                Intent intent = new Intent(this , ImageLoadEntryActivity.class);                startActivity(intent);                break;            }            case R.id.btn_anim:{                Intent intent = new Intent(this , AnimationEntryActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_crash_record:{                Intent intent = new Intent(this , CrashRecordActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_swipe_refresh:{                Intent intent = new Intent(this , SwipeRefreshActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_multiple_process:{                Intent intent = new Intent(this , MultiProcessActivity.class);                startActivity(intent);                break;            }            case R.id.btn_event_bus:{                Intent intent = new Intent(this , EventBusActivity.class);                startActivity(intent);                break;            }            case R.id.btn_permissoin:{                Intent intent = new Intent(this , PermissionActivity.class);                startActivity(intent);                break;            }            case R.id.btn_lifecycle:{                Intent intent = new Intent(this , LifecycleActivity.class);                startActivity(intent);                break;            }            case R.id.btn_activity_sample:{                Intent intent = new Intent(this , SampleMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_ui_widget:{                Intent intent = new Intent(this , UIWidgetMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_ndk:{                Intent intent = new Intent(this , NdkMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_dagger2:{                Intent intent = new Intent(this , Dagger2TestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_data_binding:{                Intent intent = new Intent(this , DataBindingActivity.class);                startActivity(intent);                break;            }            case R.id.btn_hot_update:{                Intent intent = new Intent(this, HotUpdateMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_hook:{                Intent intent = new Intent(this , HookMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_status_bar:{                Intent intent = new Intent(this , StatusBarActivity.class);                startActivity(intent);                break;            }            case R.id.btn_manager_service:{                Intent intent = new Intent(this , ManagerServiceActivity.class);                startActivity(intent);                break;            }            case R.id.btn_top_activity:{                Intent intent = new Intent(this , TopMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_multi_dialog:{                Intent intent = new Intent(this , MultiDialogActivity.class);                startActivity(intent);                break;            }            case R.id.btn_system_info:{                Intent intent = new Intent(this , SystemInfoActivity.class);                startActivity(intent);                break;            }            case R.id.btn_dispatch_event:{                Intent intent = new Intent(this , EventDispatchTestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_console:{                Intent intent = new Intent(this , ShellActivity.class);                startActivity(intent);                break;            }            case R.id.btn_chart:{                Intent intent = new Intent(this , MPAndroidChartActivity.class);                startActivity(intent);                break;            }            case R.id.btn_transition:{                Intent intent = new Intent(this, TransitionMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_architecture:{                Intent intent = new Intent(this , ArchitectureActivity.class);                startActivity(intent);                break;            }            case R.id.btn_advertise:{                Intent intent = new Intent(this , AdvertiseActivity.class);                startActivity(intent);                break;            }            case R.id.btn_rxjava:{                Intent intent = new Intent(this , RxJavaActivity.class);                startActivity(intent);                break;            }            case R.id.btn_saf:{                Intent intent = new Intent(this , SAFActivity.class);                startActivity(intent);                break;            }            case R.id.btn_media_store:{                Intent intent = new Intent(this , MediaStoreActivity.class);                startActivity(intent);                break;            }            case R.id.btn_signature_check:{                Intent intent = new Intent(this , SignatureActivity.class);                startActivity(intent);                break;            }            case R.id.btn_bitmap_transform:{                Intent intent = new Intent(this , BitmapTransformActivity.class);                startActivity(intent);                break;            }            case R.id.btn_contact:{                Intent intent = new Intent(this , ContactActivity.class);                startActivity(intent);                break;            }            case R.id.btn_loader_manager:{                Intent intent = new Intent(this , LoaderManagerActivity.class);                startActivity(intent);                break;            }            case R.id.btn_coroutine:{                startActivity(new Intent(this , CoroutineActivity.class));                break;            }            case R.id.btn_view_binding:{                startActivity(new Intent(this , ViewBindingActivity.class));                break;            }            case R.id.btn_web_view:{                startActivity(new Intent(this , WebViewActivity.class));                break;            }        }    }}
>>>>>>> 117c350... web view demo
=======
package com.tongfu.mytestapp;import android.content.Intent;import android.os.Bundle;import android.provider.MediaStore;import android.view.View;import androidx.appcompat.app.AppCompatActivity;import com.tongfu.mytestapp.advertise.AdvertiseActivity;import com.tongfu.mytestapp.animation.AnimationEntryActivity;import com.tongfu.mytestapp.architecture.ArchitectureActivity;import com.tongfu.mytestapp.bitmap.BitmapTransformActivity;import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;import com.tongfu.mytestapp.chart.MPAndroidChartActivity;import com.tongfu.mytestapp.contact.ContactActivity;import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;import com.tongfu.mytestapp.coroutine.CoroutineActivity;import com.tongfu.mytestapp.crashrecord.CrashRecordActivity;import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;import com.tongfu.mytestapp.dagger2.Dagger2TestActivity;import com.tongfu.mytestapp.database.DatabaseMenuActivity;import com.tongfu.mytestapp.databinding.DataBindingActivity;import com.tongfu.mytestapp.eventbus.EventBusActivity;import com.tongfu.mytestapp.eventdispatch.EventDispatchTestActivity;import com.tongfu.mytestapp.hook.HookMenuActivity;import com.tongfu.mytestapp.hotupdate.HotUpdateMenuActivity;import com.tongfu.mytestapp.imageload.ImageLoadEntryActivity;import com.tongfu.mytestapp.lifecycle.LifecycleActivity;import com.tongfu.mytestapp.loadermanager.LoaderManagerActivity;import com.tongfu.mytestapp.managerservice.ManagerServiceActivity;import com.tongfu.mytestapp.mediastore.MediaStoreActivity;import com.tongfu.mytestapp.memory.MemoryCheckActivity;import com.tongfu.mytestapp.multidialog.MultiDialogActivity;import com.tongfu.mytestapp.multiprocess.MultiProcessActivity;import com.tongfu.mytestapp.ndk.NdkMenuActivity;import com.tongfu.mytestapp.network.NetworkActivity;import com.tongfu.mytestapp.nonification.NotificationActivity;import com.tongfu.mytestapp.permission.PermissionActivity;import com.tongfu.mytestapp.renderscript.RenderScriptActivity;import com.tongfu.mytestapp.rxjava.RxJavaActivity;import com.tongfu.mytestapp.saf.SAFActivity;import com.tongfu.mytestapp.sampleactivity.SampleMenuActivity;import com.tongfu.mytestapp.service.MusicPlayActivity;import com.tongfu.mytestapp.shell.ShellActivity;import com.tongfu.mytestapp.signature.SignatureActivity;import com.tongfu.mytestapp.smoothexit.SmoothExitMenuActivity;import com.tongfu.mytestapp.statusbar.StatusBarActivity;import com.tongfu.mytestapp.swiperefresh.SwipeRefreshActivity;import com.tongfu.mytestapp.systeminfo.SystemInfoActivity;import com.tongfu.mytestapp.topactivity.TopMenuActivity;import com.tongfu.mytestapp.transition.TransitionActivity;import com.tongfu.mytestapp.transition.TransitionMenuActivity;import com.tongfu.mytestapp.uiwidget.UIWidgetMenuActivity;import com.tongfu.mytestapp.video.VideoPlayEntryActivity;import com.tongfu.mytestapp.viewbinding.ViewBindingActivity;import com.tongfu.mytestapp.webview.WebViewActivity;import butterknife.ButterKnife;import butterknife.OnClick;public class MainActivity extends AppCompatActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);    }    @Override    protected void onResume() {        super.onResume();    }    @Override    protected void onPause() {        super.onPause();    }    @OnClick({R.id.btnCustomViewOnTouchEvent,R.id.btn_memory,R.id.btn_content_provider,R.id.btn_music_service,            R.id.btn_broadcast_receiver,R.id.btn_network,R.id.btn_database,R.id.btn_notification,R.id.btn_video,            R.id.btn_smooth_exit,R.id.btn_image,R.id.btn_anim,R.id.btn_crash_record,            R.id.btn_swipe_refresh,R.id.btn_multiple_process,R.id.btn_event_bus,R.id.btn_permissoin,R.id.btn_lifecycle,            R.id.btn_activity_sample,R.id.btn_ui_widget,R.id.btn_ndk,R.id.btn_dagger2,R.id.btn_data_binding,            R.id.btn_hot_update , R.id.btn_hook , R.id.btn_status_bar , R.id.btn_manager_service ,            R.id.btn_top_activity , R.id.btn_multi_dialog , R.id.btn_system_info , R.id.btn_dispatch_event , R.id.btn_console,            R.id.btn_chart,R.id.btn_transition , R.id.btn_architecture , R.id.btn_advertise , R.id.btn_rxjava,            R.id.btn_saf,R.id.btn_media_store,R.id.btn_signature_check , R.id.btn_bitmap_transform ,            R.id.btn_contact , R.id.btn_loader_manager,R.id.btn_coroutine , R.id.btn_view_binding ,            R.id.btn_web_view , R.id.btn_render_script})    void onClick(View v){        switch (v.getId()){            case R.id.btn_memory:{                Intent intent = new Intent(this , MemoryCheckActivity.class);                startActivity(intent) ;                break;            }            case R.id.btnCustomViewOnTouchEvent:{                Intent intent = new Intent(this ,OnTouchEventTestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_content_provider:{                Intent intent = new Intent( this , ContentProviderActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_music_service:{                Intent intent = new Intent(this , MusicPlayActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_broadcast_receiver:{                Intent intent = new Intent(this , BroadcastReceiverActivity.class);                startActivity(intent);                break;            }            case R.id.btn_network:{                Intent intent = new Intent(this , NetworkActivity.class);                startActivity(intent);                break;            }            case R.id.btn_database:{                Intent intent = new Intent(this , DatabaseMenuActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_notification:{                Intent intent = new Intent(this , NotificationActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_video:{                Intent intent = new Intent(this , VideoPlayEntryActivity.class);                startActivity(intent);                break;            }            case R.id.btn_smooth_exit:{                Intent intent = new Intent(this , SmoothExitMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_image:{                Intent intent = new Intent(this , ImageLoadEntryActivity.class);                startActivity(intent);                break;            }            case R.id.btn_anim:{                Intent intent = new Intent(this , AnimationEntryActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_crash_record:{                Intent intent = new Intent(this , CrashRecordActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_swipe_refresh:{                Intent intent = new Intent(this , SwipeRefreshActivity.class) ;                startActivity(intent);                break;            }            case R.id.btn_multiple_process:{                Intent intent = new Intent(this , MultiProcessActivity.class);                startActivity(intent);                break;            }            case R.id.btn_event_bus:{                Intent intent = new Intent(this , EventBusActivity.class);                startActivity(intent);                break;            }            case R.id.btn_permissoin:{                Intent intent = new Intent(this , PermissionActivity.class);                startActivity(intent);                break;            }            case R.id.btn_lifecycle:{                Intent intent = new Intent(this , LifecycleActivity.class);                startActivity(intent);                break;            }            case R.id.btn_activity_sample:{                Intent intent = new Intent(this , SampleMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_ui_widget:{                Intent intent = new Intent(this , UIWidgetMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_ndk:{                Intent intent = new Intent(this , NdkMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_dagger2:{                Intent intent = new Intent(this , Dagger2TestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_data_binding:{                Intent intent = new Intent(this , DataBindingActivity.class);                startActivity(intent);                break;            }            case R.id.btn_hot_update:{                Intent intent = new Intent(this, HotUpdateMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_hook:{                Intent intent = new Intent(this , HookMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_status_bar:{                Intent intent = new Intent(this , StatusBarActivity.class);                startActivity(intent);                break;            }            case R.id.btn_manager_service:{                Intent intent = new Intent(this , ManagerServiceActivity.class);                startActivity(intent);                break;            }            case R.id.btn_top_activity:{                Intent intent = new Intent(this , TopMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_multi_dialog:{                Intent intent = new Intent(this , MultiDialogActivity.class);                startActivity(intent);                break;            }            case R.id.btn_system_info:{                Intent intent = new Intent(this , SystemInfoActivity.class);                startActivity(intent);                break;            }            case R.id.btn_dispatch_event:{                Intent intent = new Intent(this , EventDispatchTestActivity.class);                startActivity(intent);                break;            }            case R.id.btn_console:{                Intent intent = new Intent(this , ShellActivity.class);                startActivity(intent);                break;            }            case R.id.btn_chart:{                Intent intent = new Intent(this , MPAndroidChartActivity.class);                startActivity(intent);                break;            }            case R.id.btn_transition:{                Intent intent = new Intent(this, TransitionMenuActivity.class);                startActivity(intent);                break;            }            case R.id.btn_architecture:{                Intent intent = new Intent(this , ArchitectureActivity.class);                startActivity(intent);                break;            }            case R.id.btn_advertise:{                Intent intent = new Intent(this , AdvertiseActivity.class);                startActivity(intent);                break;            }            case R.id.btn_rxjava:{                Intent intent = new Intent(this , RxJavaActivity.class);                startActivity(intent);                break;            }            case R.id.btn_saf:{                Intent intent = new Intent(this , SAFActivity.class);                startActivity(intent);                break;            }            case R.id.btn_media_store:{                Intent intent = new Intent(this , MediaStoreActivity.class);                startActivity(intent);                break;            }            case R.id.btn_signature_check:{                Intent intent = new Intent(this , SignatureActivity.class);                startActivity(intent);                break;            }            case R.id.btn_bitmap_transform:{                Intent intent = new Intent(this , BitmapTransformActivity.class);                startActivity(intent);                break;            }            case R.id.btn_contact:{                Intent intent = new Intent(this , ContactActivity.class);                startActivity(intent);                break;            }            case R.id.btn_loader_manager:{                Intent intent = new Intent(this , LoaderManagerActivity.class);                startActivity(intent);                break;            }            case R.id.btn_coroutine:{                startActivity(new Intent(this , CoroutineActivity.class));                break;            }            case R.id.btn_view_binding:{                startActivity(new Intent(this , ViewBindingActivity.class));                break;            }            case R.id.btn_web_view:{                startActivity(new Intent(this , WebViewActivity.class));                break;            }            case R.id.btn_render_script:{                startActivity(new Intent(this , RenderScriptActivity.class));                break;            }        }    }}
>>>>>>> b81af3e... camerax demo（未完成)和renderscript demo
