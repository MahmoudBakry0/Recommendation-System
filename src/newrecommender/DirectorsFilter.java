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
public class DirectorsFilter implements Filter{
    
  private  String dirc;
    
    public DirectorsFilter(String director)
    {
    dirc = director;
    }

    @Override
    public boolean satisfies(String id) {
        return dirc.contains(MovieDatabase.getDirector(id));
    }
    
}
