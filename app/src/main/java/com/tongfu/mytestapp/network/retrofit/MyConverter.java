package com.tongfu.mytestapp.network.retrofit;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class MyConverter {
    public static class MyConverterFactory extends Converter.Factory{
        public MyConverterFactory() {
            super();
        }

        @Nullable
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            return super.responseBodyConverter(type, annotations, retrofit);
        }

        @Nullable
        @Override
        public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
        }

        @Nullable
        @Override
        public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            return super.stringConverter(type, annotations, retrofit);
        }
    }
}
