/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud
 */
public class MovieRunnerSimilarRatings {
    
    public FourthRatings start()
    {
    FourthRatings ob =new FourthRatings();
    RaterDatabase.initialize("ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
    System.out.println(MovieDatabase.size());
    System.out.println(RaterDatabase.size());
    return  ob;
    }
    
    public void printAverageRatings()
    {
      FourthRatings ob = start();
      ArrayList<Rating> ra = ob.getAverageRatings(1);
      System.out.println(ra.size());
      ob.sorRating(ra);
      for(Rating r : ra)
      {
        System.out.println(r.getValue()+ "  "+MovieDatabase.getTitle(r.getItem()));
      }
     
    }
    
    public void  printSimilarRatings()
    {
    FourthRatings ob =start();
    ArrayList<Rating> r = ob.getSimilarRatings("71", 20, 5);
     for(Rating re : r)
            System.out.println(MovieDatabase.getTitle(re.getItem())+"  "+re.getValue());
    }
   
    
    public void printSimilarRatingsByGenre()
    {
     FourthRatings ob =start();
     ArrayList<Rating> r = ob.getSimilarRatingsByFilter("964", 20, 5, new GenreFilter("Mystery"));
     
      for(Rating re : r)
            System.out.println(MovieDatabase.getTitle(re.getItem())+"  "+re.getValue());
    }
     
     
    public void  printSimilarRatingsByDirector()
    {
     FourthRatings ob =start();
     ArrayList<Rating> r = ob.getSimilarRatingsByFilter("120", 10, 2, new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
     
      for(Rating re : r)
            System.out.println(MovieDatabase.getTitle(re.getItem())+"  "+re.getValue());
    }
    
    
     public void printSimilarRatingsByGenreAndMinutes()
     {
     FourthRatings ob =start();
     AllFilters fi =new AllFilters();
     fi.addFilter(new MinutesFilter(80, 160));
     fi.addFilter(new GenreFilter("Drama"));
     
     ArrayList<Rating> r = ob.getSimilarRatingsByFilter("314", 10, 3, fi );
     
      for(Rating re : r)
            System.out.println(MovieDatabase.getTitle(re.getItem())+"  "+re.getValue());
     
         
     }
     
     public void  printSimilarRatingsByYearAfterAndMinute()
     {
     FourthRatings ob =start();
     AllFilters fi =new AllFilters();
     fi.addFilter(new MinutesFilter(70, 200));
     fi.addFilter(new YearAfterFilter(1975));
     
     ArrayList<Rating> r = ob.getSimilarRatingsByFilter("100", 10, 5, fi );
     
      for(Rating re : r)
            System.out.println(MovieDatabase.getTitle(re.getItem())+"  "+re.getValue());
     
         
     }
    
}
