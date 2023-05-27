/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Mahmoud
 */
public class ThirdRatings {
    
    
    private ArrayList<Rater> myRaters;
    
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    
    public ThirdRatings( String ratingfile)
    {
    
        FirstRatings f =new FirstRatings();
        
        myRaters = f.loadRaters(ratingfile);
    
    
    }
    
    
    public int  getRaterSize()
    {
        ArrayList<String> ra =new ArrayList<>();
       for(Rater r : myRaters)
       {
          
        if(!ra.contains(r.getID()))
            ra.add(r.getID());
       }
      return ra.size();
    }
    
    
    double getAverageByID(String id, int minimalRaters)
    {
      int rat =0 , num = 0;
        for(Rater r : myRaters)
        {
          if(r.hasRating(id))
          {
          num++;
          rat+= r.getRating(id);
          }
        
        
        }
         if(num < minimalRaters )
             return 0.0;
         
      return  (double) rat / num ;
    
    }
    
    public ArrayList<Rating> getAverageRatings(int min)
    {
      ArrayList<Rating> list =new ArrayList<>();
      ArrayList<String> movie = MovieDatabase.filterBy(new TrueFilter());
      ArrayList<String> name =new ArrayList<>();
        for(String r : movie)
        {
         
        if(!(name.contains(r)))
        {
          double av = getAverageByID(r, min);
          Rating oa = new Rating(r, av);
             
          if(av != 0.0){
            list.add(oa);
           
          }
           name.add(r);
        }
        }
        return  list;
    }
    
   
    
    public void sorRating(ArrayList<Rating> li)
    {
     
       Collections.sort(li);
    
    }
    
    public ArrayList<Rating>  getAverageRatingsByFilter(int minimalRaters, Filter  filterCriteria)
    {
    
      ArrayList<String> movie = MovieDatabase.filterBy(filterCriteria);
      
      ArrayList<Rating> rating = getAverageRatings(minimalRaters);
      ArrayList<Rating> rat = new ArrayList<>();
      for(Rating ra : rating)
      {
       if( movie.contains(ra.getItem()))
           rat.add(ra);
      }
      
     return rat;
    }
}
