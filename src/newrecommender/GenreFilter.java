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
public class GenreFilter implements Filter{
   private String genre;
    public GenreFilter(String genre)
    {
      this.genre = genre;
    }
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getGenres(id).contains(genre);
    }
    
}
