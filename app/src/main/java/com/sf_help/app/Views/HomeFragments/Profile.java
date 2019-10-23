package com.sf_help.app.Views.HomeFragments;

import android.app.Application;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sf_help.app.Adapters.ViewPagerProfile;
import com.sf_help.app.R;

public class Profile extends Fragment {
    Layout mProfile;
    ViewPager mViewpager;
    TextView mUpdateProfile;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        mViewpager = v.findViewById(R.id.profile_view_pager);
        mViewpager.setAdapter(new ViewPagerProfile(getChildFragmentManager()));

        TabLayout tabLayout = v.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewpager);

//        Profile update
        mUpdateProfile = v.findViewById(R.id.updateProfile);
        mUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"H",Toast.LENGTH_LONG).show();
            }
        });
        return  v;
    }
}
