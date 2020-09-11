package com.tongfu.mytestapp.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.FlowableSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class RxJavaActivity : AppCompatActivity() {

    val compositeDisposable by lazy{CompositeDisposable()}

    /**
     * 0 无行为
     * 1 onNext
     * 2 onError
     * 3 onComplete
     * -1 退出
     */
    var flag = 0

    var observable :Observable<String>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)
        ButterKnife.bind(this)
    }

    @BindView(R.id.tv_console)
    lateinit var tvConsole:TextView

    @OnClick(R.id.btn_init,R.id.btn_show_disposable_size , R.id.btn_next ,
            R.id.btn_error , R.id.btn_complete , R.id.btn_exit ,
            R.id.btn_clear_composite_disposable)
    fun onClick(view: View){
        when(view.id){
            R.id.btn_init -> {
                if(observable==null){
                    observable = Observable.create<String> {
                        while (flag >= 0) {
                            if(flag==0){
                                try{
                                    Thread.sleep(200)
                                }catch (e:InterruptedException){

                                }
                            }else if (flag == 1) {
                                flag = 0
                                it.onNext("")
                            }else if(flag == 2){
                                flag = 0
                                it.onError(Exception())
                            }else if(flag ==3){
                                flag = 0
                                it.onComplete()
                            }
                        }
                    }
                    compositeDisposable.add(observable!!.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).toFlowable(BackpressureStrategy.BUFFER).subscribe(
                            { showMessage("收到Next") },
                            { showMessage("收到Error") },
                            { showMessage("收到Complete") })
                    )
                    showMessage("初始化成功")
                }else{
                    showMessage("已初始化过，无需再初始化")
                }

            }
            R.id.btn_show_disposable_size->{
                showMessage("当前compositeDisposable容量为${compositeDisposable.size()}")
            }
            R.id.btn_next->{
                flag = 1
            }
            R.id.btn_error->{
                flag = 2
            }
            R.id.btn_complete->{
                flag = 3
            }
            R.id.btn_exit->{
                flag = -1
            }
            R.id.btn_clear_composite_disposable->{
                compositeDisposable.clear()
                showMessage("清除成功")
            }
        }


    }
    fun showMessage(message:String){
        tvConsole.setText(  "${tvConsole.text}\n${message}")
    }
    fun clearConsole(){
        tvConsole.setText("")
    }
}
