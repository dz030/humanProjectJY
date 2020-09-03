package INF;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.CartDAO;
import DAO.FestivalDAO;
import DAO.SigninDAO;
import DTO.CartDTO;
import DTO.FestivalDTO;

public class ShopINF_Imp implements ShopINF{
	private Scanner in = new Scanner(System.in);
	private SigninDAO signinDAO = new SigninDAO();
	private FestivalDAO festDAO = new FestivalDAO();
	private CartDAO cartDAO = new CartDAO();
	
	@Override
	public void signIn() {
		while(true) {
			System.out.println("----SignIn plz----");
			System.out.println("ID:    ");
			String id = in.nextLine();
			for(int i=0; i<signinDAO.selectAll().size(); i++) {
				if(id.equals(signinDAO.selectAll().get(i).getUserid())) {
					System.out.println("PW:    ");
					String pw = in.nextLine();
					if(pw.equals(signinDAO.selectAll().get(i).getPw())) {
						System.out.println("+++LogIn Success+++");
						break;
					}else {
						System.out.println("ID/PW ERROR");
						signIn();
					}
					
				}
			}break;
		}
		 
	}
	@Override
	public ArrayList<FestivalDTO> list() {
		ArrayList<FestivalDTO> festDTOArray = festDAO.selectAll();
		for(int i=0; i<festDTOArray.size(); i++) {
			System.out.println("NO:"+festDTOArray.get(i).getNo()+"------------------------------------");
			System.out.print(festDTOArray.get(i).getName()+" | ");
			System.out.print(festDTOArray.get(i).getLocation()+" | ");
			System.out.print(festDTOArray.get(i).getDay()+" | ");
			System.out.println("$"+festDTOArray.get(i).getPrice());
		}
		return festDTOArray;
	}

	@Override
	public void purchase() {
		System.out.println();
		System.out.println("구매하실 페스티벌 번호를 적어주세요 ^*^");
		int setNo = in.nextInt();
		in.nextLine();
		
		ArrayList<FestivalDTO> festDTOArray = festDAO.selectAll();
		for(int i=0; i<festDTOArray.size(); i++) {
			if(i+1 == setNo) {
				
				System.out.println("구매하실 티켓 수량을 적어주세요 ㅇ.ㅇ");
				int setCnt = in.nextInt();
				in.nextLine();
				
				cartDAO.insert(setNo,festDTOArray.get(i).getName(),setCnt,festDTOArray.get(i).getPrice());
				System.out.println("마이카트 추가완료!^.^!");
				break;
			}
		}
		
		
		
	}

	@Override
	public ArrayList<CartDTO> myCart() {
		ArrayList<CartDTO> cartDTOArray = cartDAO.selectAll();
		for(int i=0; i<cartDTOArray.size(); i++) {
			System.out.println("NO:"+cartDTOArray.get(i).getNo()+"----------------------");
			System.out.print(cartDTOArray.get(i).getName()+" | ");
			System.out.print(cartDTOArray.get(i).getCnt()+" | ");
			System.out.println("$"+cartDTOArray.get(i).getPrice());
		}
		return cartDTOArray;	
	} 

}
