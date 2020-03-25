package com.tongfu.mytestapp.architecture.viewmodel;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> name ;

    public MutableLiveData<String> getName() {
        if(name == null){
            name = new MutableLiveData<>();
            loadName();
        }
        return name;
    }

    private void loadName(){
        new AsyncTask<String , String , String>(){

            @Override
            protected String doInBackground(String... strings) {
                try {
                    Thread.sleep(3000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                name.setValue("任同福");
            }
        }.execute();
    }
}
