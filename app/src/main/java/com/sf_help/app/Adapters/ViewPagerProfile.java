package com.sf_help.app.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sf_help.app.Views.ProfileFragments.Experience;
import com.sf_help.app.Views.ProfileFragments.Applications;

public class ViewPagerProfile extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public ViewPagerProfile(@NonNull FragmentManager fm) {
        super(fm);

        childFragments = new Fragment[]{
                new Experience(),
                new Applications()
        };
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Experience(); //ChildFragment1 at position 0
            case 1:
                return new Applications(); //ChildFragment2 at position 1
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return childFragments.length; //Length of our array of child fragments
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }
}
