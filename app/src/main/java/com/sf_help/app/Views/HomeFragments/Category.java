package com.sf_help.app.Views.HomeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Adapters.CategoryRecyclerAdapter;
import com.sf_help.app.Home;
import com.sf_help.app.Models.Categories;
import com.sf_help.app.R;
import com.sf_help.app.Views.ProfileFragments.ProfileUpdate;

import java.util.ArrayList;
import java.util.List;

public class Category extends Fragment {
    BottomNavigationView mBottomNav;
    List<Categories> listCat;

    CardView mGardening;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_category, container, false);

        listCat = new ArrayList<>();
        listCat.add(new Categories("Carpentry","34 Jobs",R.drawable.helmet));
        listCat.add(new Categories("Groceries","34 Jobs",R.drawable.check));
        listCat.add(new Categories("Baby Seating","34 Jobs",R.drawable.boy));
        listCat.add(new Categories("Plumbing","34 Jobs",R.drawable.leak));
        listCat.add(new Categories("Gardening","34 Jobs",R.drawable.plant));
        listCat.add(new Categories("Carpentry","34 Jobs",R.drawable.helmet));

        RecyclerView mRecycler = v.findViewById(R.id.cat_recycler);
        CategoryRecyclerAdapter categoryRecyclerAdapter = new CategoryRecyclerAdapter(getContext(),listCat);
        mRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecycler.setAdapter(categoryRecyclerAdapter);



//        mGardening = v.findViewById(R.id.cardGardening);
//        mGardening.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                startActivity(new Intent(v.getContext(),));
//                Job jobFragment = new Job();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_holder,jobFragment);
//                fragmentTransaction.addToBackStack("Job");
//                fragmentTransaction.commit();
//            }
//        });

        return v;
    }
}
