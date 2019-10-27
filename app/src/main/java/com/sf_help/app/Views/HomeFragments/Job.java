package com.sf_help.app.Views.HomeFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLManger;
    private List<GetJob> getJobs;
    AvailableJobRecyclerAdapter availableJobRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_job, container, false);
        mRecycler = v.findViewById(R.id.recyclerItemJobs);
        mLManger = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLManger);
        mRecycler.setHasFixedSize(true);
        getJobList();
//        Toast.makeText(v.getContext(),"s",Toast.LENGTH_LONG).show();
        return v;
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
                Toast.makeText(getContext(),response.body().get(0).getjSalary(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<GetJob>> call, Throwable t) {

            }
        });

    }
}
