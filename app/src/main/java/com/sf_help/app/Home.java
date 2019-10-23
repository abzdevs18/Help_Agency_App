package com.sf_help.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Views.HomeFragments.Category;
import com.sf_help.app.Views.HomeFragments.Chat;
import com.sf_help.app.Views.HomeFragments.Job;
import com.sf_help.app.Views.HomeFragments.Profile;
import com.sf_help.app.Views.HomeFragments.Search;

public class Home extends AppCompatActivity {
    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        // TODO: 10/17/2019 We need the below 2 lines of code so that on startup it opens the Fragment Category with clicking first
        selectedFragment = new Category();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).addToBackStack("category").commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            Fragment selectedFragment = null;
//            menuItem.getItemId();
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
//                    Toast.makeText(Home.this,"f",Toast.LENGTH_LONG).show();
                    selectedFragment = new Category();
                    break;
                case R.id.navigation_message:
                    selectedFragment = new Chat();
                    break;
                case R.id.navigation_job:
                    selectedFragment = new Job();
                    break;
                case R.id.navigation_search:
                    selectedFragment = new Search();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new Profile();
                    break;
                default:
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).addToBackStack("home").commit();
//            ActionBar actionBar = getSupportActionBar();
//            actionBar.setElevation(0);
            return true;
        }
    };
}
