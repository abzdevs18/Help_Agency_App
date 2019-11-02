package com.sf_help.app.Views.HomeFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Adapters.AvailableJobRecyclerAdapter;
import com.sf_help.app.Models.GetJob;
import com.sf_help.app.R;
import com.sf_help.app.api.ApiClient;
import com.sf_help.app.api.ApiInterface;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Job extends Fragment {
    Fragment selectedFragment;
    LinearLayout mJob;
    CircleImageView mBidder;
    ShimmerFrameLayout shimmerFrameLayout;

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLManger;
    private List<GetJob> getJobs;
    AvailableJobRecyclerAdapter availableJobRecyclerAdapter;
    String mId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_job, container, false);
//        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottom_nav);
//        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        mRecycler = v.findViewById(R.id.recyclerItemJobs);
        mLManger = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLManger);
        mRecycler.setHasFixedSize(true);

        shimmerFrameLayout = v.findViewById(R.id.shimmer_view_container);


        Bundle bundle = getArguments();
        mId = bundle.getString("categoryId");

        if (!mId.isEmpty()){
            getJobWithId();
        }else{
            getJobList();
        }


//        Toast.makeText(v.getContext(),"s",Toast.LENGTH_LONG).show();
        return v;
    }

    private void getJobWithId() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<GetJob>> call = apiInterface.availableJobs(mId);
        call.enqueue(new Callback<List<GetJob>>() {
            @Override
            public void onResponse(Call<List<GetJob>> call, Response<List<GetJob>> response) {
                getJobs = response.body();
                availableJobRecyclerAdapter = new AvailableJobRecyclerAdapter(getActivity(),getJobs);
                mRecycler.setAdapter(availableJobRecyclerAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<GetJob>> call, Throwable t) {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

    private void getJobList() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<GetJob>> call = apiInterface.availableJobs();
        call.enqueue(new Callback<List<GetJob>>() {
            @Override
            public void onResponse(Call<List<GetJob>> call, Response<List<GetJob>> response) {

                getJobs = response.body();
                availableJobRecyclerAdapter = new AvailableJobRecyclerAdapter(getActivity(),getJobs);
                mRecycler.setAdapter(availableJobRecyclerAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(),response.body().get(0).getjSalary(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<GetJob>> call, Throwable t) {

            }
        });

    }
}
