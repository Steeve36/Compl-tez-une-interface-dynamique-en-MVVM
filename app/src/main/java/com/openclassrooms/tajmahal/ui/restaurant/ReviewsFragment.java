package com.openclassrooms.tajmahal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.restaurant.recyclerView.ReviewAdapter;

import java.util.Arrays;
import java.util.List;

public class ReviewsFragment extends Fragment {

//    List<Review> reviews = Arrays.asList(
//            new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 5),
//            new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
//            new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
//            new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
//            new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4)
//    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews, container, false );

        // ReviewAdapter recyclerAdapter = new ReviewAdapter(reviews);
    }

    public static Fragment newInstance() { return new ReviewsFragment(); }

}