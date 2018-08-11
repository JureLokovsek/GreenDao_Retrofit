package com.example.jure_lokovsek.greendao_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.jure_lokovsek.greendao_app.Baza.DatabaseManager;
import com.example.jure_lokovsek.greendao_app.DataBase.Album;
import com.example.jure_lokovsek.greendao_app.DataBase.Nutrient;
import com.example.jure_lokovsek.greendao_app.DataBase.Post;
import com.example.jure_lokovsek.greendao_app.Interface.ApiUtils;
import com.example.jure_lokovsek.greendao_app.Interface.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private DatabaseManager mDatabaseManager;
    private Context mContext;
    private RestApi mRestApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        mDatabaseManager = new DatabaseManager(mContext);
        mRestApi = ApiUtils.getRestApi(ApiUtils.BASE_URL_NUTRIENT);


     //   databaseManager.add();

      //  Log.d("user", "Size " + databaseManager.getSize());

       // databaseManager.deleteAllUsers();

       // Log.d("user", "Size " + databaseManager.getSize());
        //


        /*
        databaseManager.addNu();
        Log.d("nu", "Size " + databaseManager.getNuSize());
        databaseManager.deleteAllNu();
        Log.d("nu", "Size " + databaseManager.getNuSize());
        */


        mRestApi.getNutrient(2).enqueue(new Callback<List<Nutrient>>() {
            @Override
            public void onResponse(Call<List<Nutrient>> call, Response<List<Nutrient>> response) {
               // Log.d("nu", "Size Before " + databaseManager.getNuSize());
                List<Nutrient> nutrients = response.body();
                //databaseManager.saveNutrients(nutrients);
                Log.d("nut", "Size " + nutrients.size());
               // Log.d("nu", "Size After " + databaseManager.getNuSize());
            }

            @Override
            public void onFailure(Call<List<Nutrient>> call, Throwable t) {
                Log.d("napaka", "Napaka " + t.getMessage());
            }
        });

      //  Log.d("nu", "Size After" + databaseManager.getNuSize());



       // databaseManager.deleteAllDaos();

      //  double vrednost = 12.5648484148474D;
       // Log.d("round", "Stara Vrednost "+ vrednost + " Nova Vrednost " + Utility.roundUpDoubleValue(vrednost,2));


        // Timestamp compare
      //  https://stackoverflow.com/questions/7913264/compare-two-timestamp-in-java



        /*
        mRestApi.get100Posts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                int users = 0;
                Log.d("size", "Count " + posts.size());
                for (Post post : posts) {
                    if (post.getUserid() == 2) {
                        users++;
                        Log.d("post",  "USER ID " + post.getUserid() + " POST ID " + post.getId() + " TITLE " + post.getTitle() + " BODY " + post.getBody().substring(10));
                    }
                }
                Log.d("users", "Stevilo userjev " + users);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("error", "Napaka " + t.getMessage());
            }
        });
        */



        /*
        mRestApi.get500Albums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumi = response.body();
                Log.d("album",  "###################################");
                for (Album album : albumi) {
                    Log.d("album",  "ALBUM ID " + album.getUserid() + " ALBUM ID " + album.getId() + " TITLE " + album.getTitle().substring(10));
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
        */


/*
        mRestApi.getPostById(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                if(post != null){
                    Log.d("post", "Post " + post.getTitle());
                }else {
                    Log.d("post", "Is Null? - > JA");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

        */

    }

}
