package com.example.jure_lokovsek.greendao_app.Network;

public class ApiUtils {
    public static String BASE_URL_NUTRIENT ="http://buysellcattle.eu/";
    public static String BASE_URL_POSTS ="https://jsonplaceholder.typicode.com/";

    public ApiUtils() {  }

    public static RestApi getRestApi(String tipPovezave){
        if(tipPovezave == ApiUtils.BASE_URL_NUTRIENT){
            return RetrofitClient.getClient(BASE_URL_NUTRIENT).create(RestApi.class);
        }else if(tipPovezave == ApiUtils.BASE_URL_POSTS){
            return RetrofitClient.getClient(BASE_URL_POSTS).create(RestApi.class);
        }
        return null;
    }


}
