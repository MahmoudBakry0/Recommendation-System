/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

import java.util.ArrayList;


public class MovieRunnerWithFilters {
    
    public ThirdRatings start()
    {
    ThirdRatings ob =new ThirdRatings("build/ratings_short.csv");
    System.out.println(ob.getRaterSize());
      
    MovieDatabase.initialize("ratedmovies_short.csv");
    System.out.println(MovieDatabase.size());
    return  ob;
    }
    
    public void printAverageRatings()
    {
      ThirdRatings ob = start();
      ArrayList<Rating> ra = ob.getAverageRatings(35);
      System.out.println(ra.size());
        
      ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+ "  "+ MovieDatabase.getTitle(r.getItem()));
      
      }
     
    }
    
    public  void printAverageRatingsByYear()
    {
    
     ThirdRatings ob = start();
      ArrayList<Rating> ra = ob.getAverageRatingsByFilter(20, new YearAfterFilter(2000));
      System.out.println(ra.size());
      
       ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+ "  "+MovieDatabase.getYear(r.getItem())+"  "+MovieDatabase.getTitle(r.getItem()));
          
      }
      
    }
    
    
     public  void printAverageRatingsByGenre()
    {
    
     ThirdRatings ob = start();
      ArrayList<Rating> ra = ob.getAverageRatingsByFilter(20, new GenreFilter("Comedy"));
      System.out.println(ra.size());
      
       ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+ "  "+MovieDatabase.getTitle(r.getItem()));
          System.out.println(MovieDatabase.getGenres(r.getItem()));
      }
      
    }
     
    public  void printAverageRatingsByMinuts()
    {
    
     ThirdRatings ob = start();
      ArrayList<Rating> ra = ob.getAverageRatingsByFilter(3, new MinutesFilter(90, 180));
      System.out.println(ra.size());
      
       ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+" Time: "+MovieDatabase.getMinutes(r.getItem())+ "  "+MovieDatabase.getTitle(r.getItem()));
          
      }
      
    }
    
     public  void printAverageRatingsByDirectors()
    {
    
     ThirdRatings ob = start();
    
      ArrayList<Rating> ra = ob.getAverageRatingsByFilter(4, new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
      System.out.println(ra.size());
      
       ob.sorRating(ra);
      for(Rating r : ra)
      {
          System.out.println(r.getValue()+ "  "+MovieDatabase.getTitle(r.getItem()));
          System.out.println("    "+ MovieDatabase.getDirector(r.getItem()));
      }
      
    }
     
    public void printAverageRatingsByYearAfterAndGenre()
     {
      ThirdRatings ob = start();
       AllFilters f =new AllFilters();
       f.addFilter(new YearAfterFilter(1990));
       f.addFilter(new GenreFilter("Drama"));
         
      ArrayList<Rating> ra  = ob.getAverageRatingsByFilter(8,f);
         System.out.println(ra.size());
         ob.sorRating(ra);
      for(Rating r : ra)
      {
         
         System.out.println(r.getValue()+" "+MovieDatabase.getYear(r.getItem())+ "  "+MovieDatabase.getTitle(r.getItem()));
         System.out.println("    "+ MovieDatabase.getGenres(r.getItem()));
          
      }
       
      
     }
    
     public void  printAverageRatingsByDirectorsAndMinutes()
     {
      ThirdRatings ob = start();
       AllFilters f =new AllFilters();
       f.addFilter(new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"));
       f.addFilter(new MinutesFilter(30, 170));
         
      ArrayList<Rating> ra  = ob.getAverageRatingsByFilter(1,f);
         System.out.println(ra.size());
         ob.sorRating(ra);
      for(Rating r : ra)
      {
         
          System.out.println(r.getValue()+" Time: "+MovieDatabase.getMinutes(r.getItem())+ "  "+MovieDatabase.getTitle(r.getItem()));
          System.out.println("    "+ MovieDatabase.getDirector(r.getItem()));
          
      }
       
      
     }
}
