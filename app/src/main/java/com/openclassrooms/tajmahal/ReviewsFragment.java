package com.openclassrooms.tajmahal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.restaurant.ReviewsViewModel;
import com.openclassrooms.tajmahal.ui.restaurant.recyclerView.ReviewAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReviewsFragment extends Fragment {

    // Création des variables
    private EditText addReviewField; // Champ pour écrire un avis
    private RatingBar ratingBar; // Champ pour ajouter une note
    private Button submitReviewButton; // Bouton pour soumettre un avis
    private Button backButton; // Bouton pour revenir en arrière
    private List<Review> reviewArrayList = new ArrayList<>();
    private ReviewAdapter reviewAdapter;
    private ReviewsViewModel reviewsViewModel;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViewModel();

        // Initialisation des éléments du layout
        recyclerView = view.findViewById(R.id.recyclerView);
        addReviewField = view.findViewById(R.id.addReview); // Correction du champ d'avis
        ratingBar = view.findViewById(R.id.ratingBar);
        submitReviewButton = view.findViewById(R.id.submitReview);
        backButton = view.findViewById(R.id.backButton); // Bouton de retour

        // Initialisation de l'adaptateur pour le RecyclerView
        reviewAdapter = new ReviewAdapter(reviewArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reviewAdapter);

        // Observer les avis depuis le ViewModel pour mettre à jour l'interface utilisateur
        reviewsViewModel.getReviews().observe(getViewLifecycleOwner(), reviews -> {
            if (reviews != null) {
                initRecyclerView(reviews);
                Log.d("Steeve", "Initialisation Recycler View");
            }
            Log.d("Steeve", "Init Recycler View");
        });

        // Configuration du bouton "Retour" pour revenir au fragment précédent
        backButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Configuration du bouton pour ajouter un avis
        submitReviewButton.setOnClickListener(view1 -> {
            String reviewText = addReviewField.getText().toString().trim();
            float ratingValue = ratingBar.getRating();

            if (!reviewText.isEmpty()) {
                Review newReview = new Review("Utilisateur Anonyme", "", reviewText, (int) ratingValue);
                try {
                    // Ajouter l'avis via le ViewModel
                    reviewsViewModel.addReviews(newReview);
                    Toast.makeText(getContext(), "Review added successfully!", Toast.LENGTH_SHORT).show();

                    // Réinitialiser les champs après soumission
                    addReviewField.setText("");
                    ratingBar.setRating(0);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Error adding review: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getContext(), "Review field cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView(List<Review> reviews) {
        // Mettre à jour l'adaptateur avec la nouvelle liste d'avis
        reviewAdapter.updateReviews(reviews);
        Log.d("Steeve", "Review.Size:" + reviews.size());
    }

    private void setupViewModel() {
        reviewsViewModel = new ViewModelProvider(this).get(ReviewsViewModel.class);
    }

    public static Fragment newInstance() {
        return new ReviewsFragment();
    }
}

// TO DO : Créer une fonction pour qu'au click du boutton valider, ajouter une review. S'inspirer du boutton laisser un avis
// Créer une fonction AddReview dans ReviewViewModel
// Gérer la flèche de retour pour qu'elle revienne au fragment précédent et non pas qu'elle sorte de l'appli
// CORRIGER L'ERREUR at com.openclassrooms.tajmahal.ReviewsFragment.onViewCreated(ReviewsFragment.java:66)
