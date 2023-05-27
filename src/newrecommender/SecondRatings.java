

package newrecommender;

import java.util.*;

public class SecondRatings {
    
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    
    public SecondRatings(String moviefile, String ratingfile)
    {
    
        FirstRatings f =new FirstRatings();
        
        myMovies = f.loadMovies(moviefile);
        myRaters = f.loadRaters(ratingfile);
    
    
    }
    
    public int getMovieSize()
    {
      return myMovies.size();
    }
    
    public int  getRaterSize()
    {
      return myRaters.size();
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
      ArrayList<String> name =new ArrayList<>();
        for(Rater r : myRaters)
        {
          String id = r.getID();
          
        if(!(name.contains(id)))
        {
          double av = getAverageByID(id, min);
          Rating oa = new Rating(id, av);
             
          if(av != 0.0){
            list.add(oa);
           
          }
           name.add(id);
        }
        }
        return  list;
    }
    
    public String getTitle(String id)
    {
        
         for(Movie m : myMovies)
         {
         if(m.getID().equals(id))
             return m.getTitle();
         
         
         }
    
    return "ID was not found";
    
    }
    
    public void sorRating(ArrayList<Rating> li)
    {
     
       Collections.sort(li);
    
    
    
    }
    
}
