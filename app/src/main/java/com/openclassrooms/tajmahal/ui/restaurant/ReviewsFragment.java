package com.openclassrooms.tajmahal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReviewsFragment extends Fragment {

    private ReviewsViewModel reviewsViewModel;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews, container, false );

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViewModel();

        // THIS ONE GO GET THE XML ELEMENTS
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        reviewsViewModel.getReviews().observe(requireActivity(), this::initRecyclerView);
        Review review = new Review("", "", "", 0);
        reviewsViewModel.addReviews(review);
    }

    public void initRecyclerView(List<Review> reviews) {
        ReviewAdapter recyclerAdapter = new ReviewAdapter(reviews);

        // THIS ONE INITIALIZE THE RECYCLERVIEW WITH THE ADAPTER
        recyclerView.setAdapter(recyclerAdapter);

        // THIS ONE GIVE THE POSITION OF THE RECYCLERVIEW (WE WANTED IT TO BE VERTICAL)
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setupViewModel() {
        reviewsViewModel = new ViewModelProvider(this).get(ReviewsViewModel.class);
    }

    public static Fragment newInstance() { return new ReviewsFragment(); }

    // TO DO : Créer une fonction pour qu'au click du boutton valider, ajouter une review. S'inspirer du boutton laisser un avis
    // Créer une fonction AddReview dans ReviewViewModel
    // Gérer la flèche de retour pour qu'elle revienne au fragment précédent et non pas qu'elle sorte de l'appli




}