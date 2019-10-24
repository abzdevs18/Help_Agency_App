package com.sf_help.app.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sf_help.app.Models.Categories;
import com.sf_help.app.R;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<Categories> mData;

    public CategoryRecyclerAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categories categories = mData.get(position);
        holder.mCatName.setText(mData.get(position).getmCatName());
        holder.mCatJob.setText(mData.get(position).getmCatJobs());
        Glide.with(mContext)
                .load(mData.get(position).getmCatImage())
                .centerCrop()
                .into(holder.mCatImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mCatName,mCatJob;
        ImageView mCatImage;
        CardView mCardView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mCatName = itemView.findViewById(R.id.cat_name);
            mCatJob = itemView.findViewById(R.id.cat_jobs_available);
            mCatImage = itemView.findViewById(R.id.cat_image);
            mCardView = itemView.findViewById(R.id.categoryItem);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),mCatName.toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
