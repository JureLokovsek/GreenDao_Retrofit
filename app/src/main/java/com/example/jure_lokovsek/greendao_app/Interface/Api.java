package com.example.jure_lokovsek.greendao_app.Interface;



import com.example.jure_lokovsek.greendao_app.DataBase.Nutrient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// http://buysellcattle.eu/api/nutrition/dailyintake/1
public interface Api {

    String BASE_URL ="http://buysellcattle.eu/";

    @GET("api/nutrition/dailyintake/{id}")
    Call<List<Nutrient>> getNutrient(@Path("id") int id);

}
