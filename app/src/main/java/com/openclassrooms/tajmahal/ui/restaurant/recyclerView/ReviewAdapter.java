package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.ReviewsFragment;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private final List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }


    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.reviewList.size();
    }

    @Override
    public ReviewViewHolder onCreatViewHolder(ViewGroup parent, int viewType) {
        // HERE WE CREATE VIEW HOLDER AND INFLATE HIS IT XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_reviews, parent, false);

        return new ReviewViewHolder(view);
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    // UPDATE VIEW HOLDER WITH A NEW INFO (REVIEW)
    @Override
    public void onBindViewHolder(ReviewViewHolder viewHolder, int position) {
        viewHolder.updateReview(this.reviewList.get(position));
    }




    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        ImageView imageUser;

        public ReviewViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.userName);
            imageUser = itemView.findViewById(R.id.profileUser);

            Review review;
            View context;
            Glide.with(context)
                    .load(review.getPicture())
                    .into(this.imageUser);
        }

        public void updateReview(Review review) {
            this.username.setText(review.getUsername());
        }

    }
}
