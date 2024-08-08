package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    TextView username;
    ImageView imageUser;

    // THIS IS THE CONTRUCTOR
    public ReviewViewHolder(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.userName);
        imageUser = itemView.findViewById(R.id.profileUser);

    }

    public void updateReview(Review review) {
        this.username.setText(review.getUsername());
        Glide.with(itemView.getContext())
                .load(review.getPicture())
                .into(this.imageUser);
    }
}
