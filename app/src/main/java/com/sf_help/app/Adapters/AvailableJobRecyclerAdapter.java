package com.sf_help.app.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sf_help.app.Models.BiddersDialog;
import com.sf_help.app.Models.GetJob;
import com.sf_help.app.R;
import com.sf_help.app.Views.HomeFragments.BidderProfile;
import com.sf_help.app.Views.HomeFragments.CompanyProfile;
import com.sf_help.app.api.ApiClient;
import com.sf_help.app.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableJobRecyclerAdapter extends RecyclerView.Adapter<AvailableJobRecyclerAdapter.MyViewholder> {

    Context mContext;
    List<GetJob> mData;

    public AvailableJobRecyclerAdapter(Context mContext, List<GetJob> mData) {
        this.mContext = mContext.getApplicationContext();
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item_recycleview,parent,false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewholder holder, int position) {
        holder.mJTitle.setText(mData.get(position).getjTitle());
        holder.mJSalary.setText(mData.get(position).getjSalary());
        holder.mJobId.setText(mData.get(position).getjId());
        holder.jDescription.setText(mData.get(position).getjDesc());
        holder.jDialogSalary.setText(mData.get(position).getjSalary() + "/Month");
        holder.jDialogTitle.setText(mData.get(position).getjTitle());

        String jobId = mData.get(position).getjId();

        Glide.with(mContext).
                load(R.drawable.black_logo)
                .fitCenter()
                .into(holder.jCompanyLogoDialog);

        String n = mData.get(position).getjType();
        if (String.valueOf(n).equals("Full time")){
            //Layout
            holder.jTFromLayout.setText("Full time");
            holder.jTFromLayout.setBackgroundResource(R.drawable.job_type_full_time);
            //Dialog
            holder.mJobTypeDialog.setText("Full time");
            holder.mJobTypeDialog.setBackgroundResource(R.drawable.job_type_full_time);
        } else if (String.valueOf(n).equals("Freelance")){
            //Layout
            holder.jTFromLayout.setText("Freelance");
            holder.jTFromLayout.setBackgroundResource(R.drawable.job_type_freelance);
            //Dialog
            holder.mJobTypeDialog.setText("Freelance");
            holder.mJobTypeDialog.setBackgroundResource(R.drawable.job_type_freelance);
        } else if (String.valueOf(n).equals("Part time")){
            //Layout
            holder.jTFromLayout.setText("Part time");
            holder.jTFromLayout.setBackgroundResource(R.drawable.job_type_part_time);
            //Dialog
            holder.mJobTypeDialog.setText("Part time");
            holder.mJobTypeDialog.setBackgroundResource(R.drawable.job_type_part_time);
        }

        if (!mData.get(position).getjTags().isEmpty()){
            String tagss = mData.get(position).getjTags();
            String[] tags = tagss.split(", ");
            JobTagAdapter adapter = new JobTagAdapter(tags,holder.mJobDetails.getContext());
            holder.recyclerViewTags.setAdapter(adapter);
//            for (int i = 0; i < tags.length; i++){
//
//                Log.d("R",tags[i]);
//            }
        }

        try {
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<BiddersDialog>> call = apiInterface.jobBidders(jobId);
            call.enqueue(new Callback<List<BiddersDialog>>() {
                @Override
                public void onResponse(Call<List<BiddersDialog>> call, Response<List<BiddersDialog>> response) {
                    List<BiddersDialog> biddersDialogs = response.body();
                    BiddersDialogAdapter biddersDialogAdapter = new BiddersDialogAdapter(holder.mJobDetails.getContext(),biddersDialogs);
                    holder.mBidderRecyclerView.setAdapter(biddersDialogAdapter);
                }

                @Override
                public void onFailure(Call<List<BiddersDialog>> call, Throwable t) {

                }
            });
        }catch (Exception e){
            return;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView mJTitle,mJSalary,mJobId, mJobTypeDialog, jTFromLayout, jDescription,jDialogSalary,jDialogTitle;
        ImageView mJobCompany, jCompanyLogoDialog;
        Dialog mJobDetails;
        TextView mBidder;
        LinearLayout mJob;
        Button mJobBtn;

        //TAGS of jobs
//        String[] tags;
        RecyclerView recyclerViewTags, mBidderRecyclerView;
//        JobTagAdapter adapter;
        public MyViewholder(@NonNull final View itemView) {
            super(itemView);

            mJSalary = itemView.findViewById(R.id.job_list_salary);
            mJTitle = itemView.findViewById(R.id.jobTitleOnListing);
            jTFromLayout = itemView.findViewById(R.id.job_type_);

            mJobCompany = itemView.findViewById(R.id.job_list_comp_logo);
            mJobCompany.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CompanyProfile companyProfile = new CompanyProfile();
                    // TODO: 10/28/2019 Below code: showing how to get/use fragmentmanager inside recyclerview
                    FragmentManager fragmentManager = ((AppCompatActivity)itemView.getContext()).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_holder,companyProfile);
                    fragmentTransaction.addToBackStack("company_profile");
                    fragmentTransaction.commit();
                }
            });

            mJobDetails = new Dialog(itemView.getContext());
            mJobDetails.setContentView(R.layout.dialog_job_details);
            mJobDetails.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mJobDetails.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            mJobDetails.setCancelable(true);
            mJobDetails.setCanceledOnTouchOutside(true);

            mJob = itemView.findViewById(R.id.job_item);
            mJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mJobDetails.show();
                }
            });

            mJobId = mJobDetails.findViewById(R.id.job_id);
            mJobBtn = mJobDetails.findViewById(R.id.jobAppBtn);
            mJobTypeDialog = mJobDetails.findViewById(R.id.job_type_);
            jDescription = mJobDetails.findViewById(R.id.descriptionScroll);
            jCompanyLogoDialog = mJobDetails.findViewById(R.id.companyLogoDialog);
            jDialogTitle = mJobDetails.findViewById(R.id.jDialogTitle);
            jDialogSalary = mJobDetails.findViewById(R.id.jDialogSalary);

            recyclerViewTags = mJobDetails.findViewById(R.id.jobTags);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerViewTags.setLayoutManager(layoutManager);
            recyclerViewTags.setHasFixedSize(true);

//            profiles of bidders
            mBidderRecyclerView = mJobDetails.findViewById(R.id.profile_icon_bidder_recycler);
            LinearLayoutManager bidderlayoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            mBidderRecyclerView.setLayoutManager(bidderlayoutManager);
            mBidderRecyclerView.setHasFixedSize(true);

            mJobBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),mJobId.getText(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }


}
