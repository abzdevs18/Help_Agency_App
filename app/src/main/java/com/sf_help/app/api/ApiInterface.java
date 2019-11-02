package com.sf_help.app.api;

import com.sf_help.app.Models.BiddersDialog;
import com.sf_help.app.Models.Categories;
import com.sf_help.app.Models.GetJob;
import com.sf_help.app.Models.SignIn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Users/signin")
    //user Call<List<[yourModel]>> if you are expecting array in response, use below code if expecting object response
    Call<SignIn> signin(
            @Field("uNameEmail") String uEmailName,
            @Field("uPassword") String uPassword);
    @POST("api/getjobs")
    Call<List<GetJob>> availableJobs();

    @POST("api/getJobCat/{categoryId}")
    Call<List<GetJob>> availableJobs(@Path("categoryId") String categoryId);

    @POST("api/getCatNum")
    Call<List<Categories>> getCategories();

    @GET("api/getbidders/{job_id}")
    Call<List<BiddersDialog>> jobBidders(@Path("job_id") String jobBidder);
}
