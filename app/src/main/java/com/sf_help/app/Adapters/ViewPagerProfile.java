package com.sf_help.app.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sf_help.app.Views.ProfileFragments.Experience;
import com.sf_help.app.Views.ProfileFragments.PendingApplicationFragment;

public class ViewPagerProfile extends FragmentPagerAdapter {

    public ViewPagerProfile(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Experience(); //ChildFragment1 at position 0
            case 1:
                return new PendingApplicationFragment(); //ChildFragment2 at position 1
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 1;
    }
}
