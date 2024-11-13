package com.openclassrooms.tajmahal;

import org.junit.Test;

import static org.junit.Assert.*;

import com.openclassrooms.tajmahal.domain.model.Review;

import javax.annotation.Nullable;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Object addReview;
    private String addReviewValue;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testReviewIsCreated() throws Exception {
        // Create a new Review, with the comment "Super restaurant !" in it
        Review review = new Review("Steeve MOKOKO", "", "Super restaurant !", 5);
        // Check the review actually say in comment "Super restaurant !"
        assertEquals("Super restaurant !", review.getComment());

        // assertThrows("Super restaurant !", review.getComment());
    }

    @Test
    public void whenReviewIsValid() {

        // Simuler la valeur de la ratingBar et du champ
        Object addReview1 = addReview;
        float ratingBarValue = 1.0f; // Simuler une valeur inférieure à 0 String
        String addReviewValue = "Texte de la review"; // Simuler un champ de texte rempli

        // Vérifier si la ratingBar est supérieure à 0 et si le champ addReview n'est pas vide
        boolean isValidReview = (ratingBarValue > 0) && !addReviewValue.isEmpty();

        // Assertion du test
        assertTrue(isValidReview);
    }
}
