package com.sf_help.app.Views.HomeFragments;

import android.app.ActionBar;
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

import com.google.android.material.appbar.AppBarLayout;
import com.sf_help.app.R;

public class BidderProfile extends Fragment {
    androidx.appcompat.widget.Toolbar toolbar;
    Drawable upArrow;
    AppBarLayout mAppBarLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bidder_profile, container, false);
         upArrow = v.getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
         mAppBarLayout = v.findViewById(R.id.appBarLayout);
//
//        toolbar = v.findViewById(R.id.profile_toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
////        upArrow.setColorFilter();
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setElevation(0);

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Log.d("Home","Naa Home");

                Toast.makeText(getActivity(),"HOMEEE",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
