package com.sf_help.app.Views.HomeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sf_help.app.R;

public class Search extends Fragment {
    TextView mSearchJob;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        mSearchJob = v.findViewById(R.id.search_jobs);
        mSearchJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchJob jobFragment = new SearchJob();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,jobFragment);
                fragmentTransaction.addToBackStack("Job_Searching");
                fragmentTransaction.commit();

            }
        });

        return v;
    }
}
