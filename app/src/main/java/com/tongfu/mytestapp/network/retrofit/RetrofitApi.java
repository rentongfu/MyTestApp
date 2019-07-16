package com.tongfu.mytestapp.network.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApi {
    @GET("/RCMS/HomePage")
    @Headers( value =  "abc:123"  )
    Call<ResponseBody> getHomePage(@Query("pageNumber") int pageNumber , @Header("def")String def);

    @POST("/RCMS/HomePage")
    @FormUrlEncoded
    Call<ResponseBody> postHomePage(@Query("pageNumber") int pageNumber , @Field("a") String a , @Field("b") String b);
}
