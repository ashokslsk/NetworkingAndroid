package com.androidabcd.networking.network;

import com.androidabcd.networking.model.ItemsItem;
import com.androidabcd.networking.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/users?q=ashok")
    Call<List<ItemsItem>> getUsers();
}
