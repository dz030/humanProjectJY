package Test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.SigninDAO;
import DTO.SignInDTO;

public class SignInTest {
	SigninDAO signinDAO = null;
	
	@Before
	public void loading() {
		signinDAO = new SigninDAO();
	}
	
	@Test
	public void selectAllTest() {
		ArrayList<SignInDTO> signinDTO = signinDAO.selectAll();
		for(int i=0; i<signinDTO.size(); i++) {
			System.out.println(signinDTO.get(i).getNo());
			System.out.println(signinDTO.get(i).getUserid());
			System.out.println(signinDTO.get(i).getPw());
		}
		
	}
	
}
