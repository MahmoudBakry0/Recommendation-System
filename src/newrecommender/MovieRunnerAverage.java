/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


/**
 *
 * @author Mahmoud
 */
public class MovieRunnerAverage {
  
    public void printAverageRatings()
    {
      SecondRatings ob =new SecondRatings("build/ratedmoviesfull.csv", "build/ratings.csv");
      
      ArrayList<Rating> ra = ob.getAverageRatings(12);
        System.out.println(ra.size());
        
      ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+ "  "+ ob.getTitle(r.getItem()));
      
      }
     
    }
    
    public void getAverageRatingOneMovie(String movie)
     {
     SecondRatings ob =new SecondRatings("build/ratedmoviesfull.csv", "build/ratings.csv");
     ArrayList<Rating> ra = ob.getAverageRatings(0);

       ob.sorRating(ra);
      for(Rating r : ra)
      {
          if(ob.getTitle(r.getItem()).equals(movie))
          {
              
            System.out.println(r.getValue()+ "  "+ ob.getTitle(r.getItem()));
          }
      
      }
      
     
     }
}
