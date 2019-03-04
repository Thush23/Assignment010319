package com.example.assignment010319.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment010319.R;
import com.example.assignment010319.model.SpaceShuttleRepos;

import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>  {

        private final List<SpaceShuttleRepos> results = new ArrayList<>();

        public void setData(List<SpaceShuttleRepos> data) {
            results.clear();
            results.addAll(data);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_result, viewGroup, false);

            return new ResultViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ResultViewHolder resultViewHolder, int position) {
            SpaceShuttleRepos spaceShuttleRepos = results.get(position);
            resultViewHolder.tvlaunchdetails.setText(spaceShuttleRepos.getTotal());
        }

        @Override
        public int getItemCount() {
            return results.size();
        }

        static class ResultViewHolder extends RecyclerView.ViewHolder {

            TextView tvlaunchdetails;

            public ResultViewHolder(@NonNull View itemView) {
                super(itemView);
                tvlaunchdetails = itemView.findViewById(R.id.tvlaunchdetails);
            }


        }
    }

