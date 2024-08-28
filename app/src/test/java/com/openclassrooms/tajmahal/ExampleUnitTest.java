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

//        assertThrows("Super restaurant !", review.getComment());
    }

}