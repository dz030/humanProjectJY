package INF;

import java.util.ArrayList;

import DTO.CartDTO;
import DTO.FestivalDTO;

public interface ShopINF {
	public void signIn() ;
	public ArrayList<FestivalDTO> list();
	public void purchase();
	public ArrayList<CartDTO> myCart();
}
