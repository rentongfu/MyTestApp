package com.tongfu.mytestapp.memory;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemoryCheckActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvContent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_check);
        ButterKnife.bind(this);
        refreshMemory();
    }

    private void refreshDebugMemory(){
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        StringBuilder stringBuilder = new StringBuilder();
        memoryInfo.getTotalPrivateClean();
        stringBuilder.append("dalvikPrivateClean=").append(memoryInfo.dalvikPrivateDirty).append('\n');
    }
    private void refreshMemory(){
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivityManager.MemoryInfo()").append('\n');
        stringBuilder.append("availMem=").append(memoryInfo.availMem).append('=').append(memoryInfo.availMem / (1024 * 1024 ) ).append("MB").append('\n');
        stringBuilder.append("totalMem=").append(memoryInfo.totalMem).append('=').append(memoryInfo.totalMem / (1024 * 1024 )).append("MB").append('\n');
        stringBuilder.append("threshold=").append(memoryInfo.threshold).append('=').append(memoryInfo.threshold / (1024 * 1024 )).append("MB").append('\n');
        stringBuilder.append("lowMemory=").append(memoryInfo.lowMemory).append('=').append('\n');
        stringBuilder.append("\n");



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            stringBuilder.append("ActivityManager.getProcessMemoryInfo").append('\n');
            Debug.MemoryInfo memoryInfo2 = activityManager.getProcessMemoryInfo(new int[]{Os.getpid()})[0];
            stringBuilder.append("dalvikPss=").append(memoryInfo2.dalvikPss).append('=').append(memoryInfo2.dalvikPss / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("dalvikPrivateDirty=").append(memoryInfo2.dalvikPrivateDirty).append('=').append(memoryInfo2.dalvikPrivateDirty / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("dalvikSharedDirty=").append(memoryInfo2.dalvikSharedDirty).append('=').append(memoryInfo2.dalvikSharedDirty / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("nativePss=").append(memoryInfo2.nativePss).append('=').append(memoryInfo2.nativePss / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("nativePrivateDirty=").append(memoryInfo2.nativePrivateDirty).append('=').append(memoryInfo2.nativePrivateDirty / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("nativeSharedDirty=").append(memoryInfo2.nativeSharedDirty).append('=').append(memoryInfo2.nativeSharedDirty / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("otherPss=").append(memoryInfo2.otherPss).append('=').append(memoryInfo2.otherPss / (1024  ) ).append("MB").append('\n');
            stringBuilder.append("otherPrivateDirty=").append(memoryInfo2.otherPrivateDirty).append('=').append(memoryInfo2.otherPrivateDirty / (1024) ).append("MB").append('\n');
            stringBuilder.append("otherSharedDirty=").append(memoryInfo2.otherSharedDirty).append('=').append(memoryInfo2.otherSharedDirty / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalPrivateClean=").append(memoryInfo2.getTotalPrivateClean()).append('=').append(memoryInfo2.getTotalPrivateClean() / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalPss=").append(memoryInfo2.getTotalPss()).append('=').append(memoryInfo2.getTotalPss() / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalSwappablePss=").append(memoryInfo2.getTotalSwappablePss()).append('=').append(memoryInfo2.getTotalSwappablePss() / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalPrivateDirty=").append(memoryInfo2.getTotalPrivateDirty()).append('=').append(memoryInfo2.getTotalPrivateDirty() / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalSharedDirty=").append(memoryInfo2.getTotalSharedDirty()).append('=').append(memoryInfo2.getTotalSharedDirty() / (1024 ) ).append("MB").append('\n');
            stringBuilder.append("getTotalSwappablePss=").append(memoryInfo2.getTotalSwappablePss()).append('=').append(memoryInfo2.getTotalSwappablePss() / (1024 ) ).append("MB").append('\n');
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                stringBuilder.append("summary.java-heap=").append(memoryInfo2.getMemoryStat("summary.java-heap")).append("KB").append('\n');
                stringBuilder.append("summary.native-heap=").append(memoryInfo2.getMemoryStat("summary.native-heap")).append("KB").append('\n');
                stringBuilder.append("summary.code=").append(memoryInfo2.getMemoryStat("summary.code")).append("KB").append('\n');
                stringBuilder.append("summary.stack=").append(memoryInfo2.getMemoryStat("summary.stack")).append("KB").append('\n');
                stringBuilder.append("summary.graphics=").append(memoryInfo2.getMemoryStat("summary.graphics")).append("KB").append('\n');
                stringBuilder.append("summary.private-other=").append(memoryInfo2.getMemoryStat("summary.private-other")).append("KB").append('\n');
                stringBuilder.append("summary.system=").append(memoryInfo2.getMemoryStat("summary.system")).append("KB").append('\n');
                stringBuilder.append("summary.total-pss=").append(memoryInfo2.getMemoryStat("summary.total-pss")).append("KB").append('\n');
                stringBuilder.append("summary.total-swap=").append(memoryInfo2.getMemoryStat("summary.total-swap")).append("KB").append('\n');
            }
        }

        tvContent.setText(stringBuilder.toString());
    }
}
