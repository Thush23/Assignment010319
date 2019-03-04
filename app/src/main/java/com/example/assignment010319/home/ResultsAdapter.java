package com.example.assignment010319.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment010319.R;
import com.example.assignment010319.model.Repos.Launch;

import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>  {

    private final List<Launch> data;

    public ResultsAdapter() {this.data = new ArrayList<>();}
    public void setData (List<Launch> newData){
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View rootView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_result, viewGroup, false);
            return new ResultViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(@NonNull ResultViewHolder resultViewHolder, int position) {
            Launch launch = data.get(position);
            resultViewHolder.tvLaunches.setText(launch.getName());
            resultViewHolder.tvTotal.setText(launch.getLocation().toString());
            resultViewHolder.tvOffset.setText(launch.getRocket().toString());
            resultViewHolder.tvCount.setText(launch.getMissions().toString());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


    static class ResultViewHolder extends RecyclerView.ViewHolder {

        TextView tvLaunches;
        TextView tvTotal;
        TextView tvOffset;
        TextView tvCount;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLaunches = itemView.findViewById(R.id.tvLaunches);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            tvOffset = itemView.findViewById(R.id.tvOffset);
            tvCount = itemView.findViewById(R.id.tvCount);


        }
    }}

