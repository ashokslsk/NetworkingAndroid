package com.androidabcd.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidabcd.networking.adapter.RecyclerViewAdapter;
import com.androidabcd.networking.model.ItemsItem;
import com.androidabcd.networking.network.ApiInterface;
import com.androidabcd.networking.network.Apiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView  = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        ApiInterface apiService = Apiclient.getClient().create(ApiInterface.class);
        Call<List<ItemsItem>> call = apiService.getUsers();
        call.enqueue(new Callback<List<ItemsItem>>() {
            @Override
            public void onResponse(Call<List<ItemsItem>> call, Response<List<ItemsItem>> response) {
                Log.d("sucess", response.toString());
                recyclerViewAdapter.setListItems(response.body());
                recyclerViewAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ItemsItem>> call, Throwable t) {
                Log.d("failed", t.getLocalizedMessage());

            }
        });
    }
}