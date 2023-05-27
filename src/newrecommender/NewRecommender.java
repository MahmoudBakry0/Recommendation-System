/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

/**
 *
 * @author Mahmoud
 */
public class NewRecommender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     //new MovieRunnerSimilarRatings().printSimilarRatings();
     //new MovieRunnerSimilarRatings().printSimilarRatingsByGenre();
    // new MovieRunnerSimilarRatings().printSimilarRatingsByDirector();
      //new MovieRunnerSimilarRatings(). printSimilarRatingsByGenreAndMinutes();
        new MovieRunnerSimilarRatings(). printSimilarRatingsByYearAfterAndMinute();
        new RecommendationRunner().test();
     
    }
    
}
