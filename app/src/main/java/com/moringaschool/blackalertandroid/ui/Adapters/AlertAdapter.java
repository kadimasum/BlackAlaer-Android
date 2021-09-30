package com.moringaschool.blackalertandroid.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.blackalertandroid.R;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.created_alert_time, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder holder, int position) {
        Alert alert = alerts.get(position);
        holder.textView.setText(alert.getBlackoutLocation());
        holder.textView2.setText(alert.getBlackoutTime());
    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);


        }
    }
}
