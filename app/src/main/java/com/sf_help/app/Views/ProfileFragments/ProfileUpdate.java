package com.sf_help.app.Views.ProfileFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;
import com.sf_help.app.Views.HomeFragments.Profile;

public class ProfileUpdate extends Fragment {
    BottomNavigationView mBottomNav;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_update, container, false);
        Home home = new Home();
        BottomNavigationView bottomNavigationView = ((Home)getActivity()).findViewById(R.id.bottom_nav);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_holder);
        ProfileUpdate profileUpdate = (ProfileUpdate)getFragmentManager().findFragmentByTag("Profile_Update_Fragment");
        if (fragment.getTag().equals("Profile_Update_Fragment")){
//            bottomNavigationView.setVisibility(View.GONE);
            hideBottomNavigationView(bottomNavigationView);
        }
        return v;
    }

    private void hideBottomNavigationView(BottomNavigationView view) {
        view.clearAnimation();
        view.animate().translationY(view.getHeight()).setDuration(300);
    }

    public void showBottomNavigationView(BottomNavigationView view) {
        view.clearAnimation();
        view.animate().translationY(0).setDuration(300);
    }
}
