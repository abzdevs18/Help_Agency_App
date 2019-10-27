package com.sf_help.app.Views.HomeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sf_help.app.Adapters.ViewPagerProfile;
import com.sf_help.app.Home;
import com.sf_help.app.R;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

public class Profile extends Fragment {
    Layout mProfile;
    ViewPager mViewpager;
    TextView mUpdateProfile;
    int statusHeight = 0;
    AppBarLayout chatAppBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        mViewpager = v.findViewById(R.id.profile_view_pager);
        mViewpager.setAdapter(new ViewPagerProfile(getChildFragmentManager()));

        // TODO: 10/27/2019 to make the appBar below to the status bar
        chatAppBar = v.findViewById(R.id.appBarLayout);
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            statusHeight = getResources().getDimensionPixelSize(resourceId);
            chatAppBar.setPadding(0,statusHeight,0,0);
        }
        //End status bar

        TabLayout tabLayout = v.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewpager);
//        Profile update
        mUpdateProfile = v.findViewById(R.id.updateProfile);
        mUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileUpdate jobFragment = new ProfileUpdate();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,jobFragment,"Profile_Update_Fragment");
                fragmentTransaction.addToBackStack("Profile_Update");
                fragmentTransaction.commit();
            }
        });
        Home home = new Home();
        BottomNavigationView bottomNavigationView = ((Home)getActivity()).findViewById(R.id.bottom_nav);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_holder);
        ProfileUpdate profileUpdate = (ProfileUpdate)getFragmentManager().findFragmentByTag("Profile_Update_Fragment");
        if (!fragment.getTag().equals("Profile_Update_Fragment")){
//            bottomNavigationView.setVisibility(View.GONE);
            showBottomNavigationView(bottomNavigationView);
        }
        return  v;
    }

    public void showBottomNavigationView(BottomNavigationView view) {
        view.clearAnimation();
        view.animate().translationY(0).setDuration(300);
    }
}
