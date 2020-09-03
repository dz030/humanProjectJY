package Test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.FestivalDAO;
import DAO.SigninDAO;
import DTO.FestivalDTO;

public class FestivalTest {
	FestivalDAO festivalDAO = null;
	
	@Before
	public void loading() {
		festivalDAO = new FestivalDAO();
	}
	
	@Test
	public void selectAllTest() {
		ArrayList<FestivalDTO> festDTOArray = festivalDAO.selectAll();
		for(int i=0; i<festDTOArray.size(); i++) {
			System.out.println(festDTOArray.get(i).getNo()+"------------------------------------");
			System.out.print(festDTOArray.get(i).getName()+" | ");
			System.out.print(festDTOArray.get(i).getLocation()+" | ");
			System.out.print(festDTOArray.get(i).getDay()+" | ");
			System.out.println("$"+festDTOArray.get(i).getPrice());
		}
		
	}
}
