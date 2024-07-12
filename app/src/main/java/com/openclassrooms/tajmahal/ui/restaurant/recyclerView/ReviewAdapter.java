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
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private final List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_reviews, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder viewHolder, int position) {
        viewHolder.updateReview(this.reviewList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.reviewList.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        ImageView imageUser;

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
}
