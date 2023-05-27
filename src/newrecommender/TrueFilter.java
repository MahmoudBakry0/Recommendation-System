/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newrecommender;

public class TrueFilter implements Filter {
	@Override
	public boolean satisfies(String id) {
		return true;
	}

}
