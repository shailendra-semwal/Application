package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroesAdapter adapter;

    JSONArray heroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RetroFit();

    }
    public void RetroFit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://shibe.online")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api retrofitService = retrofit.create(Api.class);
        Call<JsonArray> call = null;
        call = retrofitService.getHeroes(50,true);
        if(call != null) {
            call.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                    if (response.isSuccessful())
                    {
                        try {
                            JSONArray array = new JSONArray(response.body().getAsJsonArray().toString());
                adapter = new HeroesAdapter(MainActivity.this, array);
                recyclerView.setAdapter(adapter);
                        } catch (Exception ex) {

                        }
                    }
                    else
                    {
                    }
                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {

                }


            });
        }
    }
}
