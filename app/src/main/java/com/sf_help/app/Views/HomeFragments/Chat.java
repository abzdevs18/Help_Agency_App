package com.sf_help.app.Views.HomeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sf_help.app.Home;
import com.sf_help.app.R;

public class Chat extends Fragment {

    LinearLayout mWorker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        Home home = new Home();
        BottomNavigationView bottomNavigationView = ((Home)getActivity()).findViewById(R.id.bottom_nav);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_holder);
        if (!fragment.getTag().equals("Messenger")){
            bottomNavigationView.setVisibility(View.VISIBLE);
//            hideBottomNavigationView(bottomNavigationView);
        }

        mWorker = v.findViewById(R.id.worker_items);
        mWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), Messaging.class));
//                getActivity().finish();
                Messenger messenger = new Messenger();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,messenger,"Messenger");
                fragmentTransaction.addToBackStack("Messenger");
                fragmentTransaction.commit();


            }
        });
        return v;
    }
}
