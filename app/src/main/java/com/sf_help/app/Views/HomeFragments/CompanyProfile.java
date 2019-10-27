package com.sf_help.app.Views.HomeFragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.sf_help.app.R;

public class CompanyProfile extends Fragment {
    int statusHeight = 0;
//    int mToolbar = 0;
    AppBarLayout chatAppBar;
//    LinearLayout mToolbarComp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_company_profile, container, false);
//        mToolbarComp = v.findViewById(R.id.toolbarCompProfile);

        //ActionBar
//            mToolbar = getResources().getDimensionPixelSize(toolResourceId);
//        ActionBar ab = ((AppCompatActivity)getActivity()).getActionBar();
//        mToolbar = ab.getHeight();
//        int barSize = mToolbar * -1;
//        LinearLayout.LayoutParams LinearL = (LinearLayout.LayoutParams) mToolbarComp.getLayoutParams();
//        LinearL.setMargins(0,barSize,0,0);
//        mToolbarComp.setLayoutParams(LinearL);

        // TODO: 10/27/2019 to make the appBar below to the status bar
        chatAppBar = v.findViewById(R.id.appBarLayout);
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");

        int toolResourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            statusHeight = getResources().getDimensionPixelSize(resourceId);
            chatAppBar.setPadding(0,statusHeight,0,0);
        }
        //End status bar
        return v;
    }
}
