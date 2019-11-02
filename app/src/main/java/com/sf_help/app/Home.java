package com.sf_help.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Views.HomeFragments.BidderProfile;
import com.sf_help.app.Views.HomeFragments.Category;
import com.sf_help.app.Views.HomeFragments.Chat;
import com.sf_help.app.Views.HomeFragments.Job;
import com.sf_help.app.Views.HomeFragments.Profile;
import com.sf_help.app.Views.HomeFragments.Search;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

import static java.lang.String.valueOf;

public class Home extends AppCompatActivity {
    Fragment selectedFragment;
    FrameLayout mFrame;
    int Navigation = 0;
    RelativeLayout mHomeLayout;
    ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFrame = findViewById(R.id.fragment_holder);
        mFrame.bringToFront();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mHomeLayout = findViewById(R.id.relativeHome);
        int resourceId = getResources().getIdentifier("navigation_bar_height","dimen","android");
        if (resourceId > 0){
            Navigation = getResources().getDimensionPixelSize(resourceId);
            mHomeLayout.setPadding(0,0,0,Navigation);
        }

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

        Intent intent = getIntent();
        String value = intent.getStringExtra("Fragment");
//        workerId From bidder Fragment
        String workerId = intent.getStringExtra("workerId");

        if (value.equals("Bidder")){
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
            // TODO: 10/17/2019 We need the below 2 lines of code so that on startup it opens the Fragment Category with clicking first
            selectedFragment = new BidderProfile();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment,"Categeory").addToBackStack("category").commit();
        }else if(value.equals("Job")){
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
            // TODO: 10/17/2019 We need the below 2 lines of code so that on startup it opens the Fragment Category with clicking first
            selectedFragment = new Job();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment,"Categeory").addToBackStack("category").commit();

        }

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
                    Bundle bundle = new Bundle();
                    bundle.putString("categoryId","");
                    selectedFragment.setArguments(bundle);
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
