package com.example.assignment010319.home;


import com.example.assignment010319.model.SpaceShuttleRepos;

import java.util.List;

    public interface HomeContract {

        interface Presenter {
            void getDataForSpaceShuttle(String name);
        }

        interface View {
            void showResults(List<SpaceShuttleRepos> results);
            void showError(String errorMessage);
        }
    }

