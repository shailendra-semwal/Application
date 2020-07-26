package com.example.myapplication;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<JSONArray> heroList;

    //we will call this method to get the data
    public LiveData<JSONArray> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<JSONArray>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://shibe.online/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        Api api = retrofit.create(Api.class);
//        Call<JSONArray> call = api.getHeroes(50,true);
//
//
//        call.enqueue(new Callback<JSONArray>() {
//            @Override
//            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
//
//                //finally we are setting the list to our MutableLiveData
//                heroList.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<JSONArray> call, Throwable t) {
//
//            }
//
//
//        });
    }
}
