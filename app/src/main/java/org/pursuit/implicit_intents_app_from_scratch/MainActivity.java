package org.pursuit.implicit_intents_app_from_scratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.implicit_intents_app_from_scratch.controller.ZodiacAdapter;
import org.pursuit.implicit_intents_app_from_scratch.models.ZodiacWrapper;
import org.pursuit.implicit_intents_app_from_scratch.network.RetrofitSingleton;
import org.pursuit.implicit_intents_app_from_scratch.network.ZodiacService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.zodiac_recyclerview);


        Retrofit retrofitSingleton = RetrofitSingleton.getInstance();
        ZodiacService zodiacService = retrofitSingleton.create(ZodiacService.class);

        final Call<ZodiacWrapper> zodiacCall = zodiacService.getZodiacs();
        zodiacCall.enqueue(new Callback<ZodiacWrapper>() {
            @Override
            public void onResponse(Call<ZodiacWrapper> call, Response<ZodiacWrapper> response) {
                Log.d(TAG, "Luis " + response.body().getZodiacs().get(0).getName());
                ZodiacAdapter adapter = new ZodiacAdapter(response.body().getZodiacs());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ZodiacWrapper> call, Throwable t) {

            }
        });

    }
}
