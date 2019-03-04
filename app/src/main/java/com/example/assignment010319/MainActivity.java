package com.example.assignment010319;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment010319.model.SpaceShuttleRepos;
import com.example.assignment010319.home.HomeContract;
import com.example.assignment010319.home.HomePresenter;
import com.example.assignment010319.home.ResultsAdapter;

import java.util.List;

    public class MainActivity extends AppCompatActivity implements HomeContract.View {

        private final ResultsAdapter resultsAdapter = new ResultsAdapter();

        private final HomeContract.Presenter presenter = new HomePresenter(this);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            RecyclerView recyclerView = findViewById(R.id.rvResults);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(resultsAdapter);

            final EditText etlaunchdate = findViewById(R.id.etlaunchdate);

            Button btnstation = findViewById(R.id.btnstation);

            btnstation.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    presenter.getDataForSpaceShuttle(etlaunchdate.getText().toString());
                }
            });
        }


        @Override
        public void showResults(List<SpaceShuttleRepos> results) {
            resultsAdapter.setData(results);

        }

        @Override
        public void showError(String errorMessage) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

