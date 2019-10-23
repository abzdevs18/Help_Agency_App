package com.sf_help.app.Views.ProfileFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sf_help.app.R;

public class Applications extends Fragment {
    Dialog mJobDetails;
    Button mJob;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_pending_fragment, container, false);

        mJobDetails = new Dialog(v.getContext());
        mJobDetails.setContentView(R.layout.dialog_job_details);
        mJobDetails.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mJobDetails.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        mJobDetails.setCancelable(true);
        mJobDetails.setCanceledOnTouchOutside(true);

        mJob = v.findViewById(R.id.pending_job_profile);
        mJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mJobDetails.show();
                Toast.makeText(getContext(),"Up",Toast.LENGTH_LONG).show();

            }
        });

        return  v;
    }
}
