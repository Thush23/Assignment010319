package com.example.assignment010319.model;

import java.util.List;

    public interface DataSource {
        void getDataForSpaceShuttle(String name);
        void setListener(DataListener listener);

        interface DataListener {
            void onDataRetrieved(List<SpaceShuttleRepos> result);
            void onFailure(Throwable throwable);
        }
    }


