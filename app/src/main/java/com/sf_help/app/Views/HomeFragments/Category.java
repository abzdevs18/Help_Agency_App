package com.sf_help.app.Views.HomeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

public class Category extends Fragment {
    BottomNavigationView mBottomNav;

    CardView mGardening;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_category, container, false);


        mGardening = v.findViewById(R.id.cardGardening);
        mGardening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(v.getContext(),));
                Job jobFragment = new Job();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,jobFragment);
                fragmentTransaction.addToBackStack("Job");
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
