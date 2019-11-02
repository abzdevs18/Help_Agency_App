package com.sf_help.app.Views.HomeFragments;

import android.app.Activity;
import android.content.Context;
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
import com.sf_help.app.api.ApiClient;
import com.sf_help.app.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Category extends Fragment {
    BottomNavigationView mBottomNav;
    List<Categories> listCat;

    CardView mGardening;
    RecyclerView mRecycler;

//    OnCategoryId categoryId;
//
//    public interface OnCategoryId{
//        public void OnIdSent(String categoryId);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_category, container, false);

        getCategory();

        mRecycler = v.findViewById(R.id.cat_recycler);


        return v;
    }

    private void getCategory() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Categories>> call = apiInterface.getCategories();
        call.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                listCat = response.body();
                CategoryRecyclerAdapter categoryRecyclerAdapter = new CategoryRecyclerAdapter(getContext(),listCat);
                mRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
                mRecycler.setAdapter(categoryRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        Activity activity = (Activity) context;
//
//        try {
//            categoryId = (OnCategoryId) activity;
//        }catch (ClassCastException e){
//            throw new ClassCastException(activity.toString()+" must implement interface");
//        }
//    }
}
