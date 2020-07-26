package com.example.myapplication;



import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "http://shibe.online";

    @GET("api/shibes")
    Call<JsonArray> getHeroes(@Query("count") int count,@Query("urls") boolean status
                             );
}
