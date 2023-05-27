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
public class FourthRatings {
    
   
    double getAverageByID(String id, int minimalRaters)
    {
      int rat =0 , num = 0;
        for(Rater r : RaterDatabase.getRaters())
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
    
    
    public double dotProduct(Rater me, Rater r) 
            
    {  
        double x = 0.0, a = 0.0, b = 0.0;
        ArrayList<String> ma = me.getItemsRated();
        ArrayList<String> ta =r.getItemsRated();
      
        for(String s : ma)
        {
        if(ta.contains(s))
        {
         a = me.getRating(s);
         b = r.getRating(s);
         
         if(a != 0.0)
         {
          a = a-5;
         }
         
         if(b != 0.0)
         {
          b = b-5;
         }
         
          x += a*b;  
            
        }
           
        }
      
        return  x;
    }
    
    private ArrayList<Rating> getSimilarities(String id)
    {
     ArrayList<Rating> list = new ArrayList<>();
     
      Rater me = RaterDatabase.getRater(id);
      
      for(Rater r : RaterDatabase.getRaters())
      {
      
        if(!r.getID().equals(id))
        {
          list.add(new Rating(r.getID(),dotProduct(me, r)));
        }
       
       }
      
      
      Collections.sort(list, Collections.reverseOrder());
      return  list;
    
    }
    
    
   public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int  minimalRaters)
   {
    
     ArrayList<Rating> list = new ArrayList<>();
    
     ArrayList<Rating> min = getSimilarities(id);
     ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
      
    for(String mov : movies)
    {
     double weighted = 0.0;   
     int  totalRaters = 0;
     for(int i = 0 ; i< numSimilarRaters; i++)
     {
       String curId = min.get(i).getItem();
       Rater curRater = RaterDatabase.getRater(curId);
       
       if(curRater.hasRating(mov))
       {
           totalRaters++;
           weighted += min.get(i).getValue() * curRater.getRating(mov);
     
       }
     }
      
       if(totalRaters >= minimalRaters)
       {
        
        double avg  = weighted / totalRaters;
        list.add( new Rating(mov, avg));
       }
     
    
    }
     Collections.sort(list, Collections.reverseOrder());
   
     return  list;
     
     }
   
   public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int  minimalRaters, Filter f)
   {
    
     ArrayList<Rating> list = new ArrayList<>();
       ArrayList<Rating> min = new ArrayList<>();
    try
    {
     min = getSimilarities(id);
    
    
     ArrayList<String> movies = MovieDatabase.filterBy(f);
      
    for(String mov : movies)
    {
     double weighted = 0.0;   
     int  totalRaters = 0;
     for(int i = 0 ; i< numSimilarRaters; i++)
     {
       String curId = min.get(i).getItem();
       Rater curRater = RaterDatabase.getRater(curId);
       
       if(curRater.hasRating(mov))
       {
           totalRaters++;
           weighted += min.get(i).getValue() * curRater.getRating(mov);
     
       }
     }
      
       if(totalRaters >= minimalRaters)
       {
        
        double avg  = weighted / totalRaters;
        list.add( new Rating(mov, avg));
       }
     
    
    }
    }
     catch (NullPointerException e)
     {
       System.out.println("The Rater ID Not Found");
     }
     Collections.sort(list, Collections.reverseOrder());
   
     return  list;
   }
    
} 

