package com.sf_help.app.api;

import com.sf_help.app.Models.SignIn;
import com.sf_help.app.Models.UserD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Users/signin")
    //user Call<List<[yourModel]>> if you are expecting array in response, use below code if expecting object response
    Call<SignIn> signin(
            @Field("uNameEmail") String uEmailName,
            @Field("uPassword") String uPassword);
}
