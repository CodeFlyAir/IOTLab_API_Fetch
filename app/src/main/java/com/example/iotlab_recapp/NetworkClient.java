package com.example.iotlab_recapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    protected static NetworkClient instance;
    protected ApiInterface apiInterface;
    private static String BASE_URL = "https://fakestoreapi.com/";

    NetworkClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static NetworkClient getRetrofitInstance() {
        if (instance == null) {
            instance= new NetworkClient();
        }
        return instance;
    }
}
