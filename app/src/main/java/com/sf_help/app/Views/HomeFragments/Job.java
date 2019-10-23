package com.sf_help.app.Views.HomeFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Job extends Fragment {
    Fragment selectedFragment;
    LinearLayout mJob;
    Dialog mJobDetails;
    CircleImageView mBidder;
    ImageView mJobCompany;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_job, container, false);

        mJobCompany = v.findViewById(R.id.job_list_comp_logo);
        mJobCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompanyProfile companyProfile = new CompanyProfile();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,companyProfile);
                fragmentTransaction.addToBackStack("company_profile");
                fragmentTransaction.commit();
            }
        });


        mJobDetails = new Dialog(v.getContext());
        mJobDetails.setContentView(R.layout.dialog_job_details);
        mJobDetails.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mJobDetails.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        mJobDetails.setCancelable(true);
        mJobDetails.setCanceledOnTouchOutside(true);

        mJob = v.findViewById(R.id.job_item);
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
                BidderProfile bidderProfile = new BidderProfile();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,bidderProfile);
                fragmentTransaction.addToBackStack("bidder_profile");
                fragmentTransaction.commit();
                mJobDetails.hide();
                Toast.makeText(v.getContext(),"Bidders",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
