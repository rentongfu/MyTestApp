package com.tongfu.mytestapp.shell;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class ShellActivity extends AppCompatActivity {

    @BindView(R.id.tv_console)
    TextView tvConsole ;
    @BindView(R.id.et_command)
    EditText etCommand ;

    Runtime runtime = Runtime.getRuntime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        ButterKnife.bind(this);
        try {
            Process ps = runtime.exec("ps -aux");
            ps.waitFor();
            String result = IOUtils.toString(ps.getInputStream() , Charset.defaultCharset());
            tvConsole.setText(result);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage() ,Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage() ,Toast.LENGTH_SHORT).show();
        }
    }

    @OnEditorAction(R.id.et_command)
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        if(actionId == EditorInfo.IME_ACTION_SEND
                || actionId == EditorInfo.IME_ACTION_DONE
                || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())){
            try {
                String command = etCommand.getText().toString();
                Process ps = runtime.exec(command);
//                ps.waitFor();

                String result = IOUtils.toString(ps.getInputStream() , Charset.defaultCharset());
                tvConsole.setText(result);
            } catch (Exception e){
                Toast.makeText(this, e.getMessage() ,Toast.LENGTH_SHORT).show();
                StringWriter sw = new StringWriter();
                PrintWriter writer = new PrintWriter(sw);
                e.printStackTrace(writer);
                String logContent = sw.getBuffer().toString();
                tvConsole.setText(logContent);
            }finally {
                etCommand.setText("");
            }
            return true ;
        }
        return false;
    }
}
