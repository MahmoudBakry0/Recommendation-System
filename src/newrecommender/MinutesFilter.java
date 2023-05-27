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
public class MinutesFilter implements Filter{

    private int min, max;
    
    public MinutesFilter(int min , int max)
    {
    this.min = min;
    this.max  = max;
    }
    
    
    @Override
    public boolean satisfies(String id) 
    {
       int x = MovieDatabase.getMinutes(id);
    
       return   x >= min && x <= max;
    }
}