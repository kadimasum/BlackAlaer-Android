package com.moringaschool.blackalertandroid.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.blackalertandroid.ui.modules.Alert;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {

    List<Alert> alerts;
    Context mContext;

    public AlertAdapter(List<Alert> alerts, Context mContext) {
        this.alerts = alerts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
