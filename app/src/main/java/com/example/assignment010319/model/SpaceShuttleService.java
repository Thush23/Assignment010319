package com.example.assignment010319.model;

import com.example.assignment010319.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpaceShuttleService {

        @GET(Constants.DOMAIN_ENDPOINT)
        Call<LaunchRepos> getLaunchDetail(@Path("launchDate") String date);

}
