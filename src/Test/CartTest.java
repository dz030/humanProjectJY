package Test;

import org.junit.Before;
import org.junit.Test;

import DAO.CartDAO;
import DTO.CartDTO;


public class CartTest {
CartDAO cartDAO = null;
	
	@Before
	public void loading() {
		cartDAO = new CartDAO();
	}
	
	@Test
	public void insertTest() {
		cartDAO.insert(2, "EDC", 1, 100);
	}
	
	
}
