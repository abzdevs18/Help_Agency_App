package com.sf_help.app.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.sf_help.app.Models.GetJob;
import com.sf_help.app.R;
import com.sf_help.app.Views.HomeFragments.BidderProfile;
import com.sf_help.app.Views.HomeFragments.CompanyProfile;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.mJTitle.setText(mData.get(position).getjTitle());
        holder.mJSalary.setText(mData.get(position).getjSalary());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView mJTitle,mJSalary;
        ImageView mJobCompany;
        Dialog mJobDetails;
        CircleImageView mBidder;
        LinearLayout mJob;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            mJSalary = itemView.findViewById(R.id.job_list_salary);
            mJTitle = itemView.findViewById(R.id.jobTitleOnListing);

            mJobCompany = itemView.findViewById(R.id.job_list_comp_logo);
            mJobCompany.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    CompanyProfile companyProfile = new CompanyProfile();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment_holder,companyProfile);
//                    fragmentTransaction.addToBackStack("company_profile");
//                    fragmentTransaction.commit();
                    Toast.makeText(v.getContext(),"s",Toast.LENGTH_LONG).show();
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

            //The following code works because the bidder which is our ID is located in our mJobDetails: bidders is child of mJobDetails
            mBidder = mJobDetails.findViewById(R.id.bidder);
            mBidder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    BidderProfile bidderProfile = new BidderProfile();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment_holder,bidderProfile);
//                    fragmentTransaction.addToBackStack("bidder_profile");
//                    fragmentTransaction.commit();
                    Toast.makeText(v.getContext(),"K",Toast.LENGTH_LONG).show();
                    mJobDetails.hide();
                }
            });
        }
    }


}
