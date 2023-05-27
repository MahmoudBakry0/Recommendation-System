
package newrecommender;


import edu.duke.*;
import org.apache.commons.csv.*;

import java.util.ArrayList;
/**
 *
 * @author Mahmoud
 */
public class FirstRatings {
    
     
    public ArrayList<Movie> loadMovies(String filename)
    {
     ArrayList<Movie> list = new ArrayList<>();
    FileResource fr =new FileResource(filename);
    CSVParser pa = fr.getCSVParser();
    
    for(CSVRecord re : pa)
    {
       
        int min = Integer.parseInt(re.get("minutes"));
       
        Movie m =new Movie(re.get("id"), re.get("title"),re.get("year"), re.get("genre"), re.get("director"), re.get("country"),
          re.get("poster"), min);
       
        list.add(m);
    
    }
    
    return  list;
    }
    
    public ArrayList<Rater> loadRaters(String filename)
    {
     ArrayList<Rater> list = new ArrayList<>();
     
    FileResource fr =new FileResource(filename);
    CSVParser pa = fr.getCSVParser();
    
    for(CSVRecord re : pa)
    { 
        Rater ra =new EfficientRater(re.get("rater_id"));
        double rate = Double.parseDouble(re.get("rating"));
        ra.addRating(re.get("movie_id"), rate);
        
        list.add(ra);
    }
      return list;
    }
    
   
}
