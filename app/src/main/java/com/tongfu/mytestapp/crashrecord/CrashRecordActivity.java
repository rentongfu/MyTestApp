package com.tongfu.mytestapp.crashrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CrashRecordActivity extends AppCompatActivity {

    private static final String logDir = "crashrecord" ;
    private static final String logFile = "crashlog.txt" ;

    File getLogFile(){
        return  new File(getDir(logDir , 0)+ logFile);
    }

    @BindView(R.id.tv_crash_log)
    TextView tvCrashLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_record);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_init)
    void onBtnClicked(){
        Thread.setDefaultUncaughtExceptionHandler(new MyCrashHandler(getLogFile()));
    }

    @OnClick(R.id.btn_read_crash)
    void onBtnReadCrashClicked(){
        File file = getLogFile();
        if(!file.exists()){
            tvCrashLog.setText("读取日志错误：" + "文件不存在");
            return;
        }
        try {
            tvCrashLog.setText(FileUtils.readFileToString(file , (String)null ));
        } catch (IOException e) {
            e.printStackTrace();
            tvCrashLog.setText("读取日志错误：" + e.getMessage());
        }
    }

    @OnClick(R.id.btn_crash)
    void onBtnCrashClicked(){
        String a = null ;
        a.length() ;
    }
    @OnClick(R.id.btn_clear)
    void onBtnClearClicked(){
        File file = getLogFile();
        if(file.exists()){
            file.delete();
        }
    }

    public static class MyCrashHandler implements Thread.UncaughtExceptionHandler{
        private File mFile ;
        public MyCrashHandler(File file){
            mFile = file ;
        }
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            if(mFile==null) return ;
            if(!mFile.exists()) {
                try {
                    mFile.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new FileWriter(mFile , true));
                writer.write("崩溃时间：" + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()) + "\n");
                writer.write("日志内容：\n");
                e.printStackTrace(writer);
                writer.write("--------------------------------\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }finally {
                writer.close();
            }

        }
    }
}
