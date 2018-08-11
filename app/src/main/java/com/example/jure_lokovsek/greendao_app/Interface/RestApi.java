package com.example.jure_lokovsek.greendao_app.Interface;



import com.example.jure_lokovsek.greendao_app.DataBase.Album;
import com.example.jure_lokovsek.greendao_app.DataBase.Nutrient;
import com.example.jure_lokovsek.greendao_app.DataBase.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// http://buysellcattle.eu/api/nutrition/dailyintake/1
public interface RestApi {

    @GET("api/nutrition/dailyintake/{id}")
    Call<List<Nutrient>> getNutrient(@Path("id") int id);

    @GET("posts")
    Call<List<Post>> get100Posts();

    @GET("albums")
    Call<List<Album>> get500Albums();

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @POST("posts")
    Call<ResponseBody> postDataPost(@Body Post post);


}
