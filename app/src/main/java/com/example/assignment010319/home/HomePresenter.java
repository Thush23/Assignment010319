package com.example.assignment010319.home;

import com.example.assignment010319.model.DataSource;
import com.example.assignment010319.model.RemoteDataSource;
import com.example.assignment010319.model.SpaceShuttleRepos;

import java.util.List;
    public class HomePresenter implements HomeContract.Presenter, DataSource.DataListener {

        private final DataSource dataSource = new RemoteDataSource();
        private final HomeContract.View view;

        public HomePresenter(HomeContract.View view) {
            this.view = view;
            dataSource.setListener(this);
        }

        @Override
        public void getDataForSpaceShuttle(String name) {
            dataSource.getDataForSpaceShuttle(name);
        }

        @Override
        public void onDataRetrieved(List<SpaceShuttleRepos> result) {
            view.showResults(result);
        }


        @Override
        public void onFailure(Throwable throwable) {
            view.showError(throwable.getMessage());
        }

    }

