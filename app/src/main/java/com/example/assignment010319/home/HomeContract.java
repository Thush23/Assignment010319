package com.example.assignment010319.home;


import com.example.assignment010319.model.Repos.Launch;

import java.util.List;

public interface HomeContract {

        interface Presenter {
            void getLaunchDate(String date);
        }

        interface View {
            void showLaunches(List<Launch> result);
            void showError(String errorMessage);
        }
    }



