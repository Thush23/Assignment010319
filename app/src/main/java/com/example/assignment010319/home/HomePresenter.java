package com.example.assignment010319.home;

import com.example.assignment010319.model.DataSource;
import com.example.assignment010319.model.LaunchRepos;
import com.example.assignment010319.model.RemoteDataSource;

public class HomePresenter implements HomeContract.Presenter, DataSource.DataListener {
    private final DataSource dataSource;
    private final HomeContract.View view;
        public HomePresenter(HomeContract.View view) {
            this.view = view;
            dataSource = new RemoteDataSource(this);
        }
    @Override
    public void onLaunchRetrieval(LaunchRepos launchRepos) {
        view.showLaunches(launchRepos.getLaunches());
    }

    @Override
    public void onError(Throwable throwable) {
        view.showError(throwable.getMessage());
    }

    @Override
    public void getLaunchDate(String date) {
        final DataSource dataSource = new RemoteDataSource(this);
        if(date.isEmpty()){
        view.showError("Please Enter Accordingly");
        return;
    }else{
        dataSource.getLaunchData(date);
        }
    }
}
