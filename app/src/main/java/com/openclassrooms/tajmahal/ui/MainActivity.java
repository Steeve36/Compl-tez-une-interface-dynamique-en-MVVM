package com.openclassrooms.tajmahal.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.ActivityMainBinding;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.restaurant.DetailsFragment;
import com.openclassrooms.tajmahal.ui.restaurant.recyclerView.ReviewAdapter;

import java.text.BreakIterator;
import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // Création des variables
    EditText addReview; // editTextNote
    Button submitReview; // addNoteButton
    RecyclerView recyclerView; // noList

    // Création d'une liste dynamique
    ArrayList<String>reviewArrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance())
                    .commitNow();
        }
        addReview = findViewById(R.id.reviewField);
        submitReview = findViewById(R.id.submitReview);
        recyclerView = findViewById(R.id.viewRecyclerView);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item_reviews, R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ReviewAdapter reviewAdapter = new ReviewAdapter(reviewArrayList);
        recyclerView.setAdapter(reviewAdapter);
        submitReview.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String review = addReview.getText().toString().trim();
                if (!review.isEmpty()) {
                    Review newReview = new Review("", "", review, 5);

                    reviewViewModel.addReview(newReview);
                    reviewArrayList.add(review);
                    recyclerView.notifyDataSetChanged();
                }
            }
        });
    }


}