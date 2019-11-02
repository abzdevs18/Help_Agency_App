package com.sf_help.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sf_help.app.R;

import java.util.ArrayList;

public class JobTagAdapter extends RecyclerView.Adapter<JobTagAdapter.ViewHolder> {

    String tags[];
    Context context;

    public JobTagAdapter(String[] tags, Context context) {
        this.tags = tags;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_tags, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.mJobTag.setText(tags[position]);
    }

    @Override
    public int getItemCount() {
        return tags.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mJobTag;
        public ViewHolder(View v){
            super(v);
            mJobTag = v.findViewById(R.id.jTags);

        }
    }
}
