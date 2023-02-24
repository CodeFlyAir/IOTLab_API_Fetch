package com.example.iotlab_recapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    List<Model> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
    }

    void fetchData()
    {
        NetworkClient.getRetrofitInstance().apiInterface.getData().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                data = response.body();
                Log.d("API","Data Fetched");
                recyclerView.setAdapter(new ViewAdapter(MainActivity.this,data));
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("API", t.getMessage());
                Toast.makeText(MainActivity.this, "Unable to fetch data.Retrying....", Toast.LENGTH_SHORT).show();
                fetchData();
            }
        });
    }
}