/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mahmoud
 */
public class EfficientRater implements Rater{
    private String myID;
    private HashMap<String, Rating> myRatings;

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<>();
    }

    @Override
    public void addRating(String item, double rating) {
       
        if(!myRatings.containsKey(item))
        {
          myRatings.put(item, new Rating(item, rating));
        }
        
    }

    @Override
    public boolean hasRating(String item)
    {
      return myRatings.containsKey(item);
    }
        
       

    @Override
    public String getID() {
        return myID;
    }

    @Override
    public double getRating(String item) {
       if(hasRating(item))
        return  myRatings.get(item).getValue();
        
       return  -1;
    }

    @Override
    public int numRatings() {
        return myRatings.size();
    }

    @Override
    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
         for(String r : myRatings.keySet())
             list.add(r);
        
        return list;
    }
}
