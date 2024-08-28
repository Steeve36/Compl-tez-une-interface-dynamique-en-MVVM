package com.openclassrooms.tajmahal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.restaurant.DetailsViewModel;
import com.openclassrooms.tajmahal.ui.restaurant.ReviewsViewModel;
import com.openclassrooms.tajmahal.ui.restaurant.recyclerView.ReviewAdapter;

import java.util.Arrays;
import java.util.List;

public class ReviewsFragment extends Fragment {

    private ReviewsViewModel reviewsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews, container, false );

    }

    public void initRecyclerView(List<Review> reviews) {
        ReviewAdapter recyclerAdapter = new ReviewAdapter(reviews);
    }

    public static Fragment newInstance() { return new ReviewsFragment(); }

}