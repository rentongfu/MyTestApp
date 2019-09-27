package com.tongfu.mytestapp.network.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
class ResultType{

}

class TargetType{

}

public class MyCallAdapter implements CallAdapter<ResultType , TargetType> {


    @Override
    public Type responseType() {
        return null;
    }

    @Override
    public TargetType adapt(Call<ResultType> call) {
        return null;
    }



    public static class Fcatory extends CallAdapter.Factory{
        @Override
        public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            return new MyCallAdapter();
        }
    }
}
