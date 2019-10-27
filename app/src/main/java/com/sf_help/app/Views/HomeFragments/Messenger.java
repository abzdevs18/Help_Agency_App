package com.sf_help.app.Views.HomeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

public class Messenger extends Fragment {
    androidx.appcompat.widget.Toolbar toolbar;
    int statusHeight = 0;
    AppBarLayout chatAppBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //For showing options item in the AppBar
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_messenger, container, false);

        // TODO: 10/27/2019 to make the appBar below to the status bar
        chatAppBar = v.findViewById(R.id.appBarLayout);
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            statusHeight = getResources().getDimensionPixelSize(resourceId);
            chatAppBar.setPadding(0,statusHeight,0,0);
        }
        //End status bar

        Home home = new Home();
        BottomNavigationView bottomNavigationView = ((Home)getActivity()).findViewById(R.id.bottom_nav);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_holder);
        if (fragment.getTag().equals("Messenger")){
            bottomNavigationView.setVisibility(View.GONE);
//            hideBottomNavigationView(bottomNavigationView);
        }

        toolbar = v.findViewById(R.id.profile_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        For Fragments
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                Toast.makeText(getActivity(),"Home",Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
                return true;
            case R.id.chat_info:
                // app icon in action bar clicked; goto parent activity.
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.chat_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
