package com.example.assignment010319;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment010319.home.HomeContract;
import com.example.assignment010319.home.HomePresenter;
import com.example.assignment010319.home.ResultsAdapter;
import com.example.assignment010319.model.Repos.Launch;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View {
    EditText etYear;
    EditText etMonth;
    EditText etDay;
    Button btngetdata;
    ResultsAdapter resultsAdapter = new ResultsAdapter();
    private HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etYear = findViewById(R.id.etYear);
        etMonth = findViewById(R.id.etMonth);
        etDay = findViewById(R.id.etDay);
        btngetdata = findViewById(R.id.btngetdata);



        RecyclerView recyclerView = findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(resultsAdapter);
        presenter = new HomePresenter(this);
        btngetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yearNum = Integer.parseInt(etYear.getText().toString());
                String year = String.format("%04d",yearNum);
                int monthNum = Integer.parseInt(etMonth.getText().toString());
                String month = String.format("%02d",monthNum);
                int dayNum = Integer.parseInt(etDay.getText().toString());
                String day =  String.format("%02d",dayNum);
                final String date = year+"-"+month+"-"+day;
                presenter.getLaunchDate(date);
                }
        });
    }

    @Override
    public void showLaunches(List<Launch> result) {resultsAdapter.setData(result);}


    @Override
    public void showError(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }
}
