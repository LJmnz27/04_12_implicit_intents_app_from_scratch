package org.pursuit.implicit_intents_app_from_scratch.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit retrofitInstance;

    public static Retrofit getInstance() {
        if (retrofitInstance != null) {
            return retrofitInstance;
        }
        retrofitInstance = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitInstance;
    }

    private RetrofitSingleton() { }
}