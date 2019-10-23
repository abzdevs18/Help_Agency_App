package com.sf_help.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Views.HomeFragments.Category;
import com.sf_help.app.Views.HomeFragments.Chat;
import com.sf_help.app.Views.HomeFragments.Job;
import com.sf_help.app.Views.HomeFragments.Profile;
import com.sf_help.app.Views.HomeFragments.Search;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

public class Home extends AppCompatActivity {
    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//        bottomNavigationView.setVisibility(View.GONE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        // TODO: 10/17/2019 We need the below 2 lines of code so that on startup it opens the Fragment Category with clicking first
        selectedFragment = new Category();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment,"Categeory").addToBackStack("category").commit();
//        Fragment currentFragment = this.getFragmentManager().findFragmentById(R.id.fragment_holder);
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_holder);
//        if (fragment instanceof ProfileUpdate){
//            Toast.makeText(this,"Kd",Toast.LENGTH_SHORT).show();
//        }
//        Fragment visibleFragment=getActiveFragment();
//            Toast.makeText(this,"Kd",Toast.LENGTH_SHORT).show();
        hideBottomNavigationView(bottomNavigationView);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            Fragment selectedFragment = null;
//            menuItem.getItemId();
            String tag = "";
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
//                    Toast.makeText(Home.this,"f",Toast.LENGTH_LONG).show();
                    selectedFragment = new Category();
                    tag = "Categeory";
                    break;
                case R.id.navigation_message:
                    selectedFragment = new Chat();
                    tag = "Chat";
                    break;
                case R.id.navigation_job:
                    selectedFragment = new Job();
                    tag = "Job";
                    break;
                case R.id.navigation_search:
                    selectedFragment = new Search();
                    tag = "Search";
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new Profile();
                    tag = "Profile";
                    break;
                default:
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment,tag).addToBackStack("home").commit();
//            ActionBar actionBar = getSupportActionBar();
//            actionBar.setElevation(0);
            return true;
        }
    };

    private void hideBottomNavigationView(BottomNavigationView view) {
        view.clearAnimation();
        view.animate().translationY(view.getHeight()).setDuration(300);
    }

    public void showBottomNavigationView(BottomNavigationView view) {
        view.clearAnimation();
        view.animate().translationY(0).setDuration(300);
    }

    public Fragment getActiveFragment(){
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_holder);
        return currentFragment;
    }
}
