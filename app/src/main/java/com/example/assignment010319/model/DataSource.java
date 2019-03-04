package com.example.assignment010319.model;

public interface DataSource {
    void getLaunchData(String date);

    interface DataListener{
        void onLaunchRetrieval(LaunchRepos launchRepos);
        void onError(Throwable throwable);
    }
}
