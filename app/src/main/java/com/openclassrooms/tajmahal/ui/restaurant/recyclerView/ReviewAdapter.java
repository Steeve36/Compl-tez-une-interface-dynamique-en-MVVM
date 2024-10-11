package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {

    // THIS IS FOR THE DATA
    private List<Review> reviewList;

    // THIS IS THE CONSTRUCTOR
    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // THIS CREATE A VIEW HOLDER AND INFLATE ITS WITH THE CONTENT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_reviews, parent, false);

        return new ReviewViewHolder(view);
    }

    // UPDATE THE VIEW HOLDER
    @Override
    public void onBindViewHolder(ReviewViewHolder viewHolder, int position) {
        viewHolder.updateReview(this.reviewList.get(position));
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.reviewList.size();
    }
}


