package com.example.assignment010319.model;

import com.example.assignment010319.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpaceShuttleService {

        @GET(Constants.DOMAIN_ENDPOINT)
        Call<List<SpaceShuttleRepos>> getDataForSpaceShuttle(@Query("total")String name);

}
