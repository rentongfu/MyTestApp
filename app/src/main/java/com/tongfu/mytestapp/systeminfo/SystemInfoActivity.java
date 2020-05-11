package com.tongfu.mytestapp.systeminfo;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemInfoActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvContent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        ButterKnife.bind(this);
        StringBuilder sb = new StringBuilder();
        sb.append("品牌（Brand）：" +Build.BRAND).append('\n');
        sb.append("用户（User）：" +Build.USER).append('\n');
        sb.append("设备（Device）：" +Build.DEVICE).append('\n');
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sb.append("支持的ABI（Supported abis）：");
            for(String string : Build.SUPPORTED_ABIS){
                sb.append(string + "; ");
            }
            sb.append("\n");
        }
        sb.append("BuildId：" +Build.ID ).append('\n');
        sb.append("Display：" +Build.DISPLAY ).append('\n');
        sb.append("厂商：" +Build.MANUFACTURER ).append('\n');
        sb.append("MODEL：" +Build.MODEL  ).append('\n');
        sb.append("HARDWARE：" +Build.HARDWARE  ).append('\n');
        sb.append("CODENAME：" +Build.VERSION.CODENAME ).append('\n');
        sb.append("RELEASE：" +Build.VERSION.RELEASE ).append('\n');
        sb.append("SDK_INT：" + Build.VERSION.SDK_INT  ).append('\n');
        sb.append("BASE_OS：" + Build.VERSION.BASE_OS  ).append('\n');
        sb.append("OS名称：" + System.getProperty("os.name" , "(null)")).append('\n');
        sb.append("OS版本号 ：" + System.getProperty("os.version" , "(null)")).append('\n');
        sb.append("OS架构：" + System.getProperty("os.arch" , "(null)")).append('\n');
        sb.append("Java版本：" + System.getProperty("java.version" , "(null)")).append('\n');
        sb.append("Java class版本：" + System.getProperty("java.class.version" , "(null)")).append('\n');
        sb.append("时区 ：" + System.getProperty("user.timezone" , "(null)")).append('\n');
        tvContent.setText(sb.toString());
    }
}
