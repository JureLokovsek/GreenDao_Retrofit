package com.example.jure_lokovsek.greendao_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.jure_lokovsek.greendao_app.Baza.DatabaseManager;
import com.example.jure_lokovsek.greendao_app.DataBase.Nutrient;
import com.example.jure_lokovsek.greendao_app.Interface.Api;
import com.example.jure_lokovsek.greendao_app.Utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    DatabaseManager databaseManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        databaseManager = new DatabaseManager(context);


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


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);


        Call<List<Nutrient>> call = api.getNutrient(2);

        call.enqueue(new Callback<List<Nutrient>>() {
            @Override
            public void onResponse(Call<List<Nutrient>> call, Response<List<Nutrient>> response) {
                Log.d("nu", "Size Before " + databaseManager.getNuSize());
                List<Nutrient> nutrients = response.body();
                databaseManager.saveNutrients(nutrients);
                Log.d("nu", "Size After " + databaseManager.getNuSize());
            }

            @Override
            public void onFailure(Call<List<Nutrient>> call, Throwable t) {
                Log.d("napaka", "Napaka " + t.getMessage());
            }
        });

        Log.d("nu", "Size After" + databaseManager.getNuSize());



       // databaseManager.deleteAllDaos();

        double vrednost = 12.5648484148474D;
        Log.d("round", "Stara Vrednost "+ vrednost + " Nova Vrednost " + Utility.roundUpDoubleValue(vrednost,2));


    }
}
