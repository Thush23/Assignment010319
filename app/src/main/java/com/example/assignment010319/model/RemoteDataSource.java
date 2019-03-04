package com.example.assignment010319.model;

import com.example.assignment010319.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource implements DataSource {

    private final DataSource.DataListener listener;
    private final SpaceShuttleService spaceShuttleService;

    public  RemoteDataSource(DataListener listener) {
        this.listener = listener;

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        spaceShuttleService = retrofit.create(SpaceShuttleService.class);
        }
        @Override
                public void getLaunchData(String date){
            spaceShuttleService.getLaunchDetail(date).enqueue(new Callback<LaunchRepos>() {
                @Override
                public void onResponse(Call<LaunchRepos> call, Response<LaunchRepos> response) {
                    if (response.isSuccessful()) {
                        listener.onLaunchRetrieval(response.body());
                    }
                }

                @Override
                public void onFailure(Call<LaunchRepos> call, Throwable t) { listener.onError(t);}
                });

        }
}