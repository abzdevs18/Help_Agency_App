package com.sf_help.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sf_help.app.Home;
import com.sf_help.app.Models.Categories;
import com.sf_help.app.R;
import com.sf_help.app.Views.HomeFragments.Category;
import com.sf_help.app.Views.HomeFragments.CompanyProfile;
import com.sf_help.app.Views.HomeFragments.Job;
import com.sf_help.app.api.ApiClient;

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
//        View view;
//        LayoutInflater mInflater = LayoutInflater.from(mContext);
//        view = mInflater.inflate(R.layout.cardview_category,parent,false);
//        return new ViewHolder(view);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_category,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String apiClient = ApiClient.getBaseUrl();
//        Categories categories = mData.get(position);
        holder.mCatId.setText(mData.get(position).getCatId());
        holder.mCatName.setText(mData.get(position).getCatName());
        holder.mCatJob.setText(mData.get(position).getNumJobCat() + " Jobs");
        Glide.with(mContext)
                .load(apiClient + "/img/categories/" + mData.get(position).getCatImage())
                .centerCrop()
                .into(holder.mCatImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mCatName,mCatJob, mCatId;
        ImageView mCatImage;
        CardView mCardView;
//        Category.OnCategoryId categoryId;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mCatName = itemView.findViewById(R.id.cat_name);
            mCatJob = itemView.findViewById(R.id.cat_jobs_available);
            mCatImage = itemView.findViewById(R.id.cat_image);
            mCatId = itemView.findViewById(R.id.cat_id);
            mCardView = itemView.findViewById(R.id.categoryItem);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Job job = new Job();
                    Bundle bundle = new Bundle();
                    bundle.putString("categoryId",mCatId.getText().toString());
                    job.setArguments(bundle);

                    // TODO: 10/28/2019 Below code: showing how to get/use fragmentmanager inside recyclerview
                    FragmentManager fragmentManager = ((AppCompatActivity)itemView.getContext()).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_holder,job);
                    fragmentTransaction.addToBackStack("company_profile");
                    fragmentTransaction.commit();

//                    categoryId.OnIdSent((String) mCatId.getText());
//                    Intent intent = new Intent(itemView.getContext(), Home.class);
//                    intent.putExtra("CategoryId",mCatId.getText());
//                    itemView.getContext().startActivity(intent);
//                    Toast.makeText(itemView.getContext(),mCatName.toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
