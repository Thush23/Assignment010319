package com.example.assignment010319.model;

import com.example.assignment010319.Constants;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource implements DataSource {

    private DataSource.DataListener listener = null;

    @Override
    public void setListener(DataListener listener) {
        this.listener = listener;
    }

    @Override
    public void getDataForSpaceShuttle(String name) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpaceShuttleService service = retrofit.create(SpaceShuttleService.class);

        service.getDataForSpaceShuttle(name)
                .enqueue(new Callback<List<SpaceShuttleRepos>>() {
                    @Override
                    public void onResponse(Call<List<SpaceShuttleRepos>> call, Response<List<SpaceShuttleRepos>> response) {
                        if (listener != null) {
                            listener.onDataRetrieved(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SpaceShuttleRepos>> call, Throwable throwable) {
                        if (listener != null) {
                            listener.onFailure(throwable);
                        }
                    }
                });
    }
}
