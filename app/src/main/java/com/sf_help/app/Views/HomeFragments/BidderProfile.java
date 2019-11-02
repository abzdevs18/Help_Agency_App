package com.sf_help.app.Views.HomeFragments;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;

public class BidderProfile extends Fragment {
    androidx.appcompat.widget.Toolbar toolbar;
    Drawable upArrow;
    AppBarLayout mAppBarLayout;
    int statusHeight = 0;
    AppBarLayout chatAppBar;
    Context mContext;
    Fragment selectedFragment;

    BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bidder_profile, container, false);
         upArrow = v.getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
         mAppBarLayout = v.findViewById(R.id.appBarLayout);

        // TODO: 10/27/2019 to make the appBar below to the status bar
        chatAppBar = v.findViewById(R.id.appBarLayout);
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            statusHeight = getResources().getDimensionPixelSize(resourceId);
            chatAppBar.setPadding(0,statusHeight,0,0);
        }

         bottomNavigationView = v.findViewById(R.id.bottom_nav);
        //End status bar
//
        toolbar = v.findViewById(R.id.profile_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
//        upArrow.setColorFilter();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setElevation(0);


        return v;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeAsUp:
                Log.d("Home","DDD");
               return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
