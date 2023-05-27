/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mahmoud
 */
public class RecommendationRunner implements Recommender{

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> movieId =new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println(movies.size());
        Random r =new Random();
        for( int i = 0 ; i< 15 ; i++)
        {
         
            int x  =  r.nextInt(movies.size());
            movieId.add(movies.get(x));
        }
        return movieId;
    }
    
    public void test()
    {
    
        System.out.println(getItemsToRate());
    
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
       FourthRatings fr =new FourthRatings();
       ArrayList<Rating>  ra = fr.getSimilarRatingsByFilter(webRaterID, 10, 4, new TrueFilter()); 
       System.out.println("<html>");
       if(ra.size() == 0)
       {
           System.out.println("");
       
       }
        System.out.println("<table style=\" color: aqua; font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif; width: 100%;background-color: lightslategray\"><tr><th > MovieId</th><th >  Title</th><th > Year</th><th > Poster</th></tr>");
       for(Rating r : ra)
       {
       
           String movieId = r.getItem();
           String movieTitle = MovieDatabase.getTitle(movieId);
           int movieYear = MovieDatabase.getYear(movieId);
           String moviePoster = MovieDatabase.getPoster(movieId);
           
           System.out.println("<tr><th>"+ movieId + "</th><th >"+ movieTitle+"</th><th > "+movieYear+"</th><th><img src= "+"\"" +moviePoster+"\""+"></th></tr>");
           
       
       
       }
       
        
        System.out.println("</table></html>");
    }
    
}
