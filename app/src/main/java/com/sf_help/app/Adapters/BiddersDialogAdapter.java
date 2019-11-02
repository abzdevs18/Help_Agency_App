package com.sf_help.app.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.google.android.material.snackbar.Snackbar;
import com.sf_help.app.Home;
import com.sf_help.app.Models.BiddersDialog;
import com.sf_help.app.Models.Categories;
import com.sf_help.app.R;
import com.sf_help.app.Views.HomeFragments.BidderProfile;
import com.sf_help.app.api.ApiClient;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.google.android.material.snackbar.Snackbar.LENGTH_SHORT;

public class BiddersDialogAdapter extends RecyclerView.Adapter<BiddersDialogAdapter.ViewHolder> {
    private final Context mContext;
    private List<BiddersDialog> mData;

    public BiddersDialogAdapter(Context mContext, List<BiddersDialog> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bidder_profile_icon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String apiClient = ApiClient.getBaseUrl();

        holder.mBidderProfileId.setText(mData.get(position).getWorkerId());


        if (mData.get(position).getUserProf() != null){
            Glide.with(mContext)
                    .load(apiClient + "/img/profiles/" + mData.get(position).getUserProf())
                    .fitCenter()
                    .into(holder.mProfile);
            Log.d("RES", "Bidder Not Null: " + mData.get(position).getUserProf());
        }else{
//            Glide.with(mContext)
//                    .load(mData.get(position).getUserProf())
//                    .fitCenter()
//                    .into(holder.mProfile);
            Log.d("RES", "Bidder: " + mData.get(position).getUserProf());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mProfile;
        TextView mBidderProfileId;
        Fragment selectedFragment;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            mProfile = itemView.findViewById(R.id.bidder);
            mBidderProfileId = itemView.findViewById(R.id.bidder_profile_id);

            //The following code works because the bidder which is our ID is located in our mJobDetails: bidders is child of mJobDetails
//            mBidder = mJobDetails.findViewById(R.id.bidder);
            mProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    BidderProfile bidderProfile = new BidderProfile();
//                    FragmentManager fragmentManager = ((itemView.get))
////                    FragmentManager fragmentManager = ((FragmentActivity)itemView.getContext()).getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment_holder,bidderProfile);
//                    fragmentTransaction.addToBackStack("bidder_profile");
//                    fragmentTransaction.commit();
                    Intent intent = new Intent(itemView.getContext(), Home.class);
                    intent.putExtra("Fragment","Bidder");
                    intent.putExtra("workerId",mBidderProfileId.getText());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
